/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author SACHIN PATEL
 */
public class InterestInvitesForm extends org.apache.struts.action.ActionForm {

    private Long invtDtlId;
    private String companyId;
    private String jobDesc;
    private String lastDate;
    private String jobDescDoc;
    private String otherDetails;

    public Long getInvtDtlId() {
        return invtDtlId;
    }

    public void setInvtDtlId(Long invtDtlId) {
        this.invtDtlId = invtDtlId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    
    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getJobDescDoc() {
        return jobDescDoc;
    }

    public void setJobDescDoc(String jobDescDoc) {
        this.jobDescDoc = jobDescDoc;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    /**
     *
     */
    public InterestInvitesForm() {
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
        ActionErrors errors = new ActionErrors();

        return errors;
    }
}
