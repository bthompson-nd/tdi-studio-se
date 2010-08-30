// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.business.diagram.custom.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.core.model.properties.BusinessProcessItem;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.RepositoryManager;
import org.talend.designer.business.model.business.diagram.part.BusinessDiagramEditor;
import org.talend.repository.editor.RepositoryEditorInput;
import org.talend.repository.model.IRepositoryNode;
import org.talend.repository.model.RepositoryNodeUtilities;
import org.talend.repository.ui.views.IRepositoryView;

/**
 * DOC xtan class global comment. <br/>
 */
public class SaveAsBusinessModelAction extends Action {

    private EditorPart editorPart;

    public SaveAsBusinessModelAction(EditorPart editorPart) {
        this.editorPart = editorPart;
    }

    @Override
    public void run() {
        SaveAsBusinessModelWizard processWizard = new SaveAsBusinessModelWizard(editorPart);

        WizardDialog dlg = new WizardDialog(Display.getCurrent().getActiveShell(), processWizard);
        if (dlg.open() == Window.OK) {

            try {

                RepositoryManager.refreshCreatedNode(ERepositoryObjectType.PROCESS);

                BusinessProcessItem businessProcessItem = processWizard.getBusinessProcessItem();

                IWorkbenchPage page = getActivePage();

                DiagramResourceManager diagramResourceManager = new DiagramResourceManager(page, new NullProgressMonitor());
                IFile file = diagramResourceManager.createDiagramFile();
                // Set readonly to false since created job will always be editable.
                RepositoryEditorInput newBusinessModelEditorInput = new RepositoryEditorInput(file, businessProcessItem);

                newBusinessModelEditorInput.setView((IRepositoryView) page.findView(IRepositoryView.VIEW_ID));
                IRepositoryNode repositoryNode = RepositoryNodeUtilities.getRepositoryNode(newBusinessModelEditorInput.getItem()
                        .getProperty().getId(), false);
                newBusinessModelEditorInput.setRepositoryNode(repositoryNode);

                // here really do the normal save as function
                IDocumentProvider provider = ((BusinessDiagramEditor) this.editorPart).getDocumentProvider();

                provider.aboutToChange(newBusinessModelEditorInput);
                provider.saveDocument(null, newBusinessModelEditorInput, provider.getDocument(this.editorPart.getEditorInput()),
                        true);
                provider.changed(newBusinessModelEditorInput);

                // copy back from the *.business_diagram file to *.item file.
                // @see:BusinessDiagramEditor.doSave(IProgressMonitor progressMonitor)
                diagramResourceManager.updateFromResource(businessProcessItem, newBusinessModelEditorInput.getFile());

                // open the new editor, because at the same time, there will update the jobSetting/componentSetting view
                IEditorPart openEditor = page.openEditor(newBusinessModelEditorInput, BusinessDiagramEditor.ID, true);
                // notice: here, must save it, unless close the editor without any modification, there won't save the
                // model again, so, will lost the graphic when reopen it.
                openEditor.doSave(null);

                // close the old editor
                page.closeEditor(this.editorPart, false);

            } catch (Exception e) {
                MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "Business model could not be saved"
                        + " : " + e.getMessage());
                ExceptionHandler.process(e);
            }
        }
    }

    private IWorkbenchPage getActivePage() {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    }

}
