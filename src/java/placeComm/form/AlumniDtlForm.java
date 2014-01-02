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
public class AlumniDtlForm extends org.apache.struts.action.ActionForm {
    
     private Long alumniDtlId;
     private String alumniName;
     private String alumniCompany;
     private String alumniDesignation;
     private String alumniBatch;
     private String alumniTelephone;
     private String alumniMobile;
     private String alumniEmail;
     private String alumniFax;
     private String alumniAddress;
     private String alumniOtherDtls;
     private String facebookLink;
     private String twitterLink;
     private String linkedinLink;

    public Long getAlumniDtlId() {
        return alumniDtlId;
    }

    public void setAlumniDtlId(Long alumniDtlId) {
        this.alumniDtlId = alumniDtlId;
    }

    public String getAlumniName() {
        return alumniName;
    }

    public void setAlumniName(String alumniName) {
        this.alumniName = alumniName;
    }

    public String getAlumniCompany() {
        return alumniCompany;
    }

    public void setAlumniCompany(String alumniCompany) {
        this.alumniCompany = alumniCompany;
    }

    public String getAlumniDesignation() {
        return alumniDesignation;
    }

    public void setAlumniDesignation(String alumniDesignation) {
        this.alumniDesignation = alumniDesignation;
    }

    public String getAlumniBatch() {
        return alumniBatch;
    }

    public void setAlumniBatch(String alumniBatch) {
        this.alumniBatch = alumniBatch;
    }

    public String getAlumniTelephone() {
        return alumniTelephone;
    }

    public void setAlumniTelephone(String alumniTelephone) {
        this.alumniTelephone = alumniTelephone;
    }

    public String getAlumniMobile() {
        return alumniMobile;
    }

    public void setAlumniMobile(String alumniMobile) {
        this.alumniMobile = alumniMobile;
    }

    public String getAlumniEmail() {
        return alumniEmail;
    }

    public void setAlumniEmail(String alumniEmail) {
        this.alumniEmail = alumniEmail;
    }

    public String getAlumniFax() {
        return alumniFax;
    }

    public void setAlumniFax(String alumniFax) {
        this.alumniFax = alumniFax;
    }

    public String getAlumniAddress() {
        return alumniAddress;
    }

    public void setAlumniAddress(String alumniAddress) {
        this.alumniAddress = alumniAddress;
    }

    public String getAlumniOtherDtls() {
        return alumniOtherDtls;
    }

    public void setAlumniOtherDtls(String alumniOtherDtls) {
        this.alumniOtherDtls = alumniOtherDtls;
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
    public AlumniDtlForm() {
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
