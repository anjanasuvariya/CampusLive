/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.form;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author SACHIN PATEL
 */
public class UserContactDtlForm extends org.apache.struts.action.ActionForm {
    
     private Long userContactId;
     private String mobileNo;
     private String homeContactNo;
     private String workPhoneNo;
     private String universityWebmailId;
     private String personalEmailId;
     private String website;
     private String blog;
     private String permanentAddress;
     private String currentAddress;
     private Long createdUserId;
     private String createdDate;

    public Long getUserContactId() {
        return userContactId;
    }

    public void setUserContactId(Long userContactId) {
        this.userContactId = userContactId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getHomeContactNo() {
        return homeContactNo;
    }

    public void setHomeContactNo(String homeContactNo) {
        this.homeContactNo = homeContactNo;
    }

    public String getWorkPhoneNo() {
        return workPhoneNo;
    }

    public void setWorkPhoneNo(String workPhoneNo) {
        this.workPhoneNo = workPhoneNo;
    }

    public String getUniversityWebmailId() {
        return universityWebmailId;
    }

    public void setUniversityWebmailId(String universityWebmailId) {
        this.universityWebmailId = universityWebmailId;
    }

    public String getPersonalEmailId() {
        return personalEmailId;
    }

    public void setPersonalEmailId(String personalEmailId) {
        this.personalEmailId = personalEmailId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    
     
    public UserContactDtlForm() {
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
        if (getMobileNo() == null || getMobileNo().length() < 1) {
            errors.add("mobileNo", new ActionMessage("error.mobileNo.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
