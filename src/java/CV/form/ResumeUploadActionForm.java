/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CV.form;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author admin
 */
public class ResumeUploadActionForm extends org.apache.struts.action.ActionForm {
    
    private FormFile file;
    private File resume;

    
    
    public void setResume(File resume) {
        this.resume = resume;
    }

    public File getResume() {
        return resume;
    }

    
    
    
    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    
    
    /**
     * @return
     */
    

    /**
     *
     */
    public ResumeUploadActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

   

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
   
}
