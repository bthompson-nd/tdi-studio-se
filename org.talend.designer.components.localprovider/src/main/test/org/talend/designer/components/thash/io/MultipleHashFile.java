// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2007 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.designer.components.thash.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

/**
 * 
 * DOC amaumont class global comment. Detailled comment <br/>
 * 
 */
class MultipleHashFile implements MapHashFile {

    private static MultipleHashFile instance;

    private MultipleHashFile() {
    }

    /**
     * getInstance.
     * 
     * @return the instance if this project handler
     */
    public static synchronized MultipleHashFile getInstance() {
        if (instance == null) {
            instance = new MultipleHashFile();
        }
        return instance;
    }

    RandomAccessFile[] bwArray = null;
    int[] bwPositionArray = null;

    boolean readonly;

    int numberFiles = 10;
    
    byte numberOfChars = (byte)(String.valueOf(numberFiles).length() - 1);

    RandomAccessFile[] raArray = null;

    Object[] lastRetrievedObjectArray = null;

    long[] lastRetrievedCursorPositionArray = null;
    
    int countUniqueGet;

    public Object get(String container, long cursorPosition, int hashcode) throws IOException, ClassNotFoundException {

        byte fileNumber = getFileNumber(hashcode);
        
        RandomAccessFile ra = raArray[fileNumber];

        if (cursorPosition != lastRetrievedCursorPositionArray[fileNumber]) {
            ++countUniqueGet;
            ra.seek(cursorPosition);
            byte[] byteArray = new byte[ra.readInt()];
            ra.read(byteArray);
            lastRetrievedObjectArray[fileNumber] = new ObjectInputStream(new ByteArrayInputStream(byteArray)).readObject();
            lastRetrievedCursorPositionArray[fileNumber] = cursorPosition;
        }
        return lastRetrievedObjectArray[fileNumber];
    }

    /**
     * DOC amaumont Comment method "getFileNumber".
     * 
     * @param hashcode
     * @return
     */
    private byte getFileNumber(int hashcode) {
        String valueOf = String.valueOf(Math.abs(hashcode));
        return Byte.parseByte(valueOf.substring(valueOf.length() - numberOfChars,valueOf.length()));
    }

    public long put(String container, Object bean) throws IOException {

        byte fileNumber = getFileNumber(bean.hashCode());
        
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(bean);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        int sizeBytes = byteArrayOutputStream.size();

        if (!readonly) {
            RandomAccessFile bw = bwArray[fileNumber];
            bw.writeInt(sizeBytes);
            bw.write(byteArrayOutputStream.toByteArray());
        }

        byteArrayOutputStream.close();

        long returnPosition = bwPositionArray[fileNumber];

        bwPositionArray[fileNumber] += (4 + sizeBytes);

        return returnPosition;
    }

    public void initPut(String container) throws IOException {
        if (!readonly) {
            bwArray = new RandomAccessFile[numberFiles];
            bwPositionArray = new int[numberFiles];
            for (int i = 0; i < numberFiles; i++) {
                File file = new File(container + i);
                file.delete();
                bwArray[i] = new RandomAccessFile(container + i, "rw");
            }
        }
    }

    public void endPut() throws IOException {
        if (!readonly) {
            for (int i = 0; i < numberFiles; i++) {
                bwArray[i].close();
            }
        }
    }

    public void initGet(String container) throws FileNotFoundException {
        raArray = new RandomAccessFile[numberFiles];
        lastRetrievedCursorPositionArray = new long[numberFiles]; 
        lastRetrievedObjectArray = new Object[numberFiles];
        for (int i = 0; i < numberFiles; i++) {
            raArray[i] = new RandomAccessFile(container + i, "r");
            lastRetrievedCursorPositionArray[i] = -1;
        }
    }

    public void endGet(String container) throws IOException {
        if (!readonly) {
            for (int i = 0; i < numberFiles; i++) {
                RandomAccessFile ra = raArray[i];
                if (ra != null) {
                    ra.close();
                }
                File file = new File(container + i);
//                file.delete();
            }
        }
        
        System.out.println("countUniqueGet = "+countUniqueGet);
    }

}
