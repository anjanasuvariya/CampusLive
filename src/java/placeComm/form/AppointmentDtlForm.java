/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author SACHIN PATEL
 */
public class AppointmentDtlForm extends org.apache.struts.action.ActionForm {

    private Long appntDtlId;
    private String appntTitle;
    private String appntPurpose;
    private String appntFileName;
    private String appntCompany;
    private String assignedTo;
    private String appntStatus;
    private String appntMessage;
    private String appntPriority;
    private FormFile file;

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }
    
    public Long getAppntDtlId() {
        return appntDtlId;
    }

    public void setAppntDtlId(Long appntDtlId) {
        this.appntDtlId = appntDtlId;
    }

    public String getAppntTitle() {
        return appntTitle;
    }

    public void setAppntTitle(String appntTitle) {
        this.appntTitle = appntTitle;
    }

    public String getAppntPurpose() {
        return appntPurpose;
    }

    public void setAppntPurpose(String appntPurpose) {
        this.appntPurpose = appntPurpose;
    }

    public String getAppntFileName() {
        return appntFileName;
    }

    public void setAppntFileName(String appntFileName) {
        this.appntFileName = appntFileName;
    }

    public String getAppntCompany() {
        return appntCompany;
    }

    public void setAppntCompany(String appntCompany) {
        this.appntCompany = appntCompany;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    
    public String getAppntStatus() {
        return appntStatus;
    }

    public void setAppntStatus(String appntStatus) {
        this.appntStatus = appntStatus;
    }

    public String getAppntMessage() {
        return appntMessage;
    }

    public void setAppntMessage(String appntMessage) {
        this.appntMessage = appntMessage;
    }

    public String getAppntPriority() {
        return appntPriority;
    }

    public void setAppntPriority(String appntPriority) {
        this.appntPriority = appntPriority;
    }

    /**
     *
     */
    public AppointmentDtlForm() {
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
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors actionErrors = new ActionErrors();
       
        return actionErrors;
    }
}
