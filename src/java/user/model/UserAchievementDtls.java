package user.model;
// Generated Oct 3, 2013 8:53:36 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * UserAchievementDtls generated by hbm2java
 */
public class UserAchievementDtls  implements java.io.Serializable {


     private Long userAchievementId;
     private String achievementTitle;
     private String achievementCategory;
     private String achievementImage;
     private String eventName;
     private String eventOrganizers;
     private String eventDescription;
     private long createdUserId;
     private Date createdDate;
     private Long updatedUserId;
     private Date updatedDate;
     private Long universityId;

    public UserAchievementDtls() {
    }

	
    public UserAchievementDtls(String achievementTitle, long createdUserId, Date createdDate) {
        this.achievementTitle = achievementTitle;
        this.createdUserId = createdUserId;
        this.createdDate = createdDate;
    }
    public UserAchievementDtls(String achievementTitle, String achievementCategory, String achievementImage, String eventName, String eventOrganizers, String eventDescription, long createdUserId, Date createdDate, Long updatedUserId, Date updatedDate, Long universityId) {
       this.achievementTitle = achievementTitle;
       this.achievementCategory = achievementCategory;
       this.achievementImage = achievementImage;
       this.eventName = eventName;
       this.eventOrganizers = eventOrganizers;
       this.eventDescription = eventDescription;
       this.createdUserId = createdUserId;
       this.createdDate = createdDate;
       this.updatedUserId = updatedUserId;
       this.updatedDate = updatedDate;
       this.universityId = universityId;
    }
   
    public Long getUserAchievementId() {
        return this.userAchievementId;
    }
    
    public void setUserAchievementId(Long userAchievementId) {
        this.userAchievementId = userAchievementId;
    }
    public String getAchievementTitle() {
        return this.achievementTitle;
    }
    
    public void setAchievementTitle(String achievementTitle) {
        this.achievementTitle = achievementTitle;
    }
    public String getAchievementCategory() {
        return this.achievementCategory;
    }
    
    public void setAchievementCategory(String achievementCategory) {
        this.achievementCategory = achievementCategory;
    }
    public String getAchievementImage() {
        return this.achievementImage;
    }
    
    public void setAchievementImage(String achievementImage) {
        this.achievementImage = achievementImage;
    }
    public String getEventName() {
        return this.eventName;
    }
    
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getEventOrganizers() {
        return this.eventOrganizers;
    }
    
    public void setEventOrganizers(String eventOrganizers) {
        this.eventOrganizers = eventOrganizers;
    }
    public String getEventDescription() {
        return this.eventDescription;
    }
    
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
    public long getCreatedUserId() {
        return this.createdUserId;
    }
    
    public void setCreatedUserId(long createdUserId) {
        this.createdUserId = createdUserId;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Long getUpdatedUserId() {
        return this.updatedUserId;
    }
    
    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Long getUniversityId() {
        return this.universityId;
    }
    
    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }




}


