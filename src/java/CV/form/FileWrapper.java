/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CV.form;
import java.io.*;
import org.apache.struts.upload.FormFile;

public class FileWrapper implements FormFile {
    private final File file;

    public FileWrapper(File file) {
        this.file = file;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public void setContentType(String s) {
    }

    @Override
    public int getFileSize() {
        return 0;
    }

    @Override
    public void setFileSize(int i) {
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public void setFileName(String s) {
    }

    @Override
    public byte[] getFileData() throws IOException {
        byte[] buffer = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(buffer);
        fileInputStream.close();
        return buffer;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    @Override
    public void destroy() {
        if (!file.delete()) {
            throw new RuntimeException("File " + file.getName() + " can't be deleted");
        }
    }
}
