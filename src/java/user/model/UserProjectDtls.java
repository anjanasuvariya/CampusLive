package user.model;
// Generated Oct 6, 2013 1:31:18 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * UserProjectDtls generated by hbm2java
 */
public class UserProjectDtls  implements java.io.Serializable {


     private Long projDtlId;
     private String projName;
     private String projRole;
     private Date projStartDate;
     private Date projEndDate;
     private String projTeamMembers;
     private String projDescription;
     private long createdUserId;
     private Date createdDate;
     private Long updatedUserId;
     private Date updatedDate;
     private Long universityId;

    public UserProjectDtls() {
    }

	
    public UserProjectDtls(String projName, long createdUserId, Date createdDate) {
        this.projName = projName;
        this.createdUserId = createdUserId;
        this.createdDate = createdDate;
    }
    public UserProjectDtls(String projName, String projRole, Date projStartDate, Date projEndDate, String projTeamMembers, String projDescription, long createdUserId, Date createdDate, Long updatedUserId, Date updatedDate, Long universityId) {
       this.projName = projName;
       this.projRole = projRole;
       this.projStartDate = projStartDate;
       this.projEndDate = projEndDate;
       this.projTeamMembers = projTeamMembers;
       this.projDescription = projDescription;
       this.createdUserId = createdUserId;
       this.createdDate = createdDate;
       this.updatedUserId = updatedUserId;
       this.updatedDate = updatedDate;
       this.universityId = universityId;
    }
   
    public Long getProjDtlId() {
        return this.projDtlId;
    }
    
    public void setProjDtlId(Long projDtlId) {
        this.projDtlId = projDtlId;
    }
    public String getProjName() {
        return this.projName;
    }
    
    public void setProjName(String projName) {
        this.projName = projName;
    }
    public String getProjRole() {
        return this.projRole;
    }
    
    public void setProjRole(String projRole) {
        this.projRole = projRole;
    }
    public Date getProjStartDate() {
        return this.projStartDate;
    }
    
    public void setProjStartDate(Date projStartDate) {
        this.projStartDate = projStartDate;
    }
    public Date getProjEndDate() {
        return this.projEndDate;
    }
    
    public void setProjEndDate(Date projEndDate) {
        this.projEndDate = projEndDate;
    }
    public String getProjTeamMembers() {
        return this.projTeamMembers;
    }
    
    public void setProjTeamMembers(String projTeamMembers) {
        this.projTeamMembers = projTeamMembers;
    }
    public String getProjDescription() {
        return this.projDescription;
    }
    
    public void setProjDescription(String projDescription) {
        this.projDescription = projDescription;
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


