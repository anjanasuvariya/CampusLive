package user.model;
// Generated Oct 6, 2013 1:32:05 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * UserRecommendationDtls generated by hbm2java
 */
public class UserRecommendationDtls  implements java.io.Serializable {


     private Long recmdDtlId;
     private String recmdTitle;
     private String recmdBy;
     private String recmdCompanyLocation;
     private String recmdDescription;
     private long createdUserId;
     private Date createdDate;
     private Long updatedUserId;
     private Date updatedDate;
     private Long universityId;

    public UserRecommendationDtls() {
    }

	
    public UserRecommendationDtls(String recmdTitle, long createdUserId, Date createdDate) {
        this.recmdTitle = recmdTitle;
        this.createdUserId = createdUserId;
        this.createdDate = createdDate;
    }
    public UserRecommendationDtls(String recmdTitle, String recmdBy, String recmdCompanyLocation, String recmdDescription, long createdUserId, Date createdDate, Long updatedUserId, Date updatedDate, Long universityId) {
       this.recmdTitle = recmdTitle;
       this.recmdBy = recmdBy;
       this.recmdCompanyLocation = recmdCompanyLocation;
       this.recmdDescription = recmdDescription;
       this.createdUserId = createdUserId;
       this.createdDate = createdDate;
       this.updatedUserId = updatedUserId;
       this.updatedDate = updatedDate;
       this.universityId = universityId;
    }
   
    public Long getRecmdDtlId() {
        return this.recmdDtlId;
    }
    
    public void setRecmdDtlId(Long recmdDtlId) {
        this.recmdDtlId = recmdDtlId;
    }
    public String getRecmdTitle() {
        return this.recmdTitle;
    }
    
    public void setRecmdTitle(String recmdTitle) {
        this.recmdTitle = recmdTitle;
    }
    public String getRecmdBy() {
        return this.recmdBy;
    }
    
    public void setRecmdBy(String recmdBy) {
        this.recmdBy = recmdBy;
    }
    public String getRecmdCompanyLocation() {
        return this.recmdCompanyLocation;
    }
    
    public void setRecmdCompanyLocation(String recmdCompanyLocation) {
        this.recmdCompanyLocation = recmdCompanyLocation;
    }
    public String getRecmdDescription() {
        return this.recmdDescription;
    }
    
    public void setRecmdDescription(String recmdDescription) {
        this.recmdDescription = recmdDescription;
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


