package common.model;
// Generated Oct 29, 2013 7:59:44 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * CmnEducationMst generated by hbm2java
 */
public class CmnEducationMst  implements java.io.Serializable {


     private Long educationId;
     private String educationTitle;
     private long createdUserId;
     private Date createdDate;
     private Long updatedUserId;
     private Date updatedDate;

    public CmnEducationMst() {
    }

	
    public CmnEducationMst(long createdUserId, Date createdDate) {
        this.createdUserId = createdUserId;
        this.createdDate = createdDate;
    }
    public CmnEducationMst(String educationTitle, long createdUserId, Date createdDate, Long updatedUserId, Date updatedDate) {
       this.educationTitle = educationTitle;
       this.createdUserId = createdUserId;
       this.createdDate = createdDate;
       this.updatedUserId = updatedUserId;
       this.updatedDate = updatedDate;
    }
   
    public Long getEducationId() {
        return this.educationId;
    }
    
    public void setEducationId(Long educationId) {
        this.educationId = educationId;
    }
    public String getEducationTitle() {
        return this.educationTitle;
    }
    
    public void setEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
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




}

