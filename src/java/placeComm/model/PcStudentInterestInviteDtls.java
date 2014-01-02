package placeComm.model;
// Generated Oct 16, 2013 10:33:49 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * PcStudentInterestInviteDtls generated by hbm2java
 */
public class PcStudentInterestInviteDtls  implements java.io.Serializable {


     private Long studInvtDtlId;
     private long invtDtlId;
     private long studUserId;
     private String studSelectionFlag;
     private String hrSelectionFlag;
     private long universityId;
     private long createdUserId;
     private Date createdDate;
     private Long updatedUserId;
     private Date updatedDate;

    public PcStudentInterestInviteDtls() {
    }

	
    public PcStudentInterestInviteDtls(long invtDtlId, long studUserId, long universityId, long createdUserId, Date createdDate) {
        this.invtDtlId = invtDtlId;
        this.studUserId = studUserId;
        this.universityId = universityId;
        this.createdUserId = createdUserId;
        this.createdDate = createdDate;
    }
    public PcStudentInterestInviteDtls(long invtDtlId, long studUserId, String studSelectionFlag, String hrSelectionFlag, long universityId, long createdUserId, Date createdDate, Long updatedUserId, Date updatedDate) {
       this.invtDtlId = invtDtlId;
       this.studUserId = studUserId;
       this.studSelectionFlag = studSelectionFlag;
       this.hrSelectionFlag = hrSelectionFlag;
       this.universityId = universityId;
       this.createdUserId = createdUserId;
       this.createdDate = createdDate;
       this.updatedUserId = updatedUserId;
       this.updatedDate = updatedDate;
    }
   
    public Long getStudInvtDtlId() {
        return this.studInvtDtlId;
    }
    
    public void setStudInvtDtlId(Long studInvtDtlId) {
        this.studInvtDtlId = studInvtDtlId;
    }
    public long getInvtDtlId() {
        return this.invtDtlId;
    }
    
    public void setInvtDtlId(long invtDtlId) {
        this.invtDtlId = invtDtlId;
    }
    public long getStudUserId() {
        return this.studUserId;
    }
    
    public void setStudUserId(long studUserId) {
        this.studUserId = studUserId;
    }
    public String getStudSelectionFlag() {
        return this.studSelectionFlag;
    }
    
    public void setStudSelectionFlag(String studSelectionFlag) {
        this.studSelectionFlag = studSelectionFlag;
    }
    public String getHrSelectionFlag() {
        return this.hrSelectionFlag;
    }
    
    public void setHrSelectionFlag(String hrSelectionFlag) {
        this.hrSelectionFlag = hrSelectionFlag;
    }
    public long getUniversityId() {
        return this.universityId;
    }
    
    public void setUniversityId(long universityId) {
        this.universityId = universityId;
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

