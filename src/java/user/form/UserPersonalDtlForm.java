/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.form;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author SACHIN PATEL
 */
public class UserPersonalDtlForm extends org.apache.struts.action.ActionForm {

    private Long personalDtlId;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private File file;//The actual file  
    private String userPhotoContentType; //The content type of the file
    private String userPhotoFileName; //The uploaded file name
    private String personPhoto;
    private String dateOfBirth;
    private String gender;
    private String primaryLangauge;
    private String secondaryLanguage;
    private String interests;
    private String currentCity;
    private Long createdUserId;
    private String createdDate;
    private Long universityId;
    private String facebookLink;
    private String twitterLink;
    private String linkedInLink;

    public Long getPersonalDtlId() {
        return personalDtlId;
    }

    public void setPersonalDtlId(Long personalDtlId) {
        this.personalDtlId = personalDtlId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getUserPhotoContentType() {
        return userPhotoContentType;
    }

    public String getUserPhotoFileName() {
        return userPhotoFileName;
    }

    public void setUserPhotoContentType(String userPhotoContentType) {
        this.userPhotoContentType = userPhotoContentType;
    }

    public void setUserPhotoFileName(String userPhotoFileName) {
        this.userPhotoFileName = userPhotoFileName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonPhoto() {
        return personPhoto;
    }

    public void setPersonPhoto(String personPhoto) {
        this.personPhoto = personPhoto;
    }

    public String getPrimaryLangauge() {
        return primaryLangauge;
    }

    public void setPrimaryLangauge(String primaryLangauge) {
        this.primaryLangauge = primaryLangauge;
    }

    public String getSecondaryLanguage() {
        return secondaryLanguage;
    }

    public void setSecondaryLanguage(String secondaryLanguage) {
        this.secondaryLanguage = secondaryLanguage;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
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

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
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

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    
    
    /**
     *
     */
    public UserPersonalDtlForm() {
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

        if (userFirstName == null || userFirstName.length() < 1) {

            actionErrors.add("personName", new ActionMessage("error.personName"));
            // TODO: add 'error.name.required' key to your resources
        }


//        if (getDateOfBirth() != null || getDateOfBirth().length() < 1) {
//            actionErrors.add("dateOfBirth", new ActionMessage("error.dateOfBirth"));
//
//        } else {
//            Calendar cal = Calendar.getInstance();
//            Date lDtCurrDate = cal.getTime();
//            Date lDtDateOfBirth;
//            try {
//                lDtDateOfBirth = simpleDateFormat.parse(getDateOfBirth());
//                if (lDtDateOfBirth.after(lDtCurrDate) || getDateOfBirth().equals(lDtCurrDate)) {
//                    actionErrors.add("dateOfBirth", new ActionMessage("error.dateOfBirthCompCurDate"));
//
//                }
//            } catch (ParseException ex) {
//                Logger.getLogger(UserPersonalDtlForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }

        if (getGender() == null || getGender().length() < 1) {
            actionErrors.add("gender", new ActionMessage("error.gender"));
            // TODO: add 'error.name.required' key to your resources
        }
        return actionErrors;
    }
}
