/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author SACHIN PATEL
 */
public class HrDtlForm extends org.apache.struts.action.ActionForm {

    private Long hrDtlId;
    private String hrName;
    private String companyId;
    private String designation;
    private String hrTeleNo;
    private String hrMobileNo;
    private String hrEmailId;
    private String faxId;
    private String address;
    private String otherDtls;
    private String facebookLink;
    private String twitterLink;
    private String linkedinLink;

    public Long getHrDtlId() {
        return hrDtlId;
    }

    public void setHrDtlId(Long hrDtlId) {
        this.hrDtlId = hrDtlId;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getHrTeleNo() {
        return hrTeleNo;
    }

    public void setHrTeleNo(String hrTeleNo) {
        this.hrTeleNo = hrTeleNo;
    }

    public String getHrMobileNo() {
        return hrMobileNo;
    }

    public void setHrMobileNo(String hrMobileNo) {
        this.hrMobileNo = hrMobileNo;
    }

    public String getHrEmailId() {
        return hrEmailId;
    }

    public void setHrEmailId(String hrEmailId) {
        this.hrEmailId = hrEmailId;
    }

    public String getFaxId() {
        return faxId;
    }

    public void setFaxId(String faxId) {
        this.faxId = faxId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOtherDtls() {
        return otherDtls;
    }

    public void setOtherDtls(String otherDtls) {
        this.otherDtls = otherDtls;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    /**
     *
     */
    public HrDtlForm() {
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
//        if (hrName != null && !"".equals(hrName)) {
//            actionErrors.add("hrName", new ActionMessage("error.hrName.required"));
//        }
//        if (companyId != null && !"".equals(companyId)) {
//             actionErrors.add("companyId", new ActionMessage("error.companyId.required"));
//        }
        return actionErrors;
    }
}
