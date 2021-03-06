package common.model;
// Generated Jan 6, 2005 12:32:04 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * CmnRoleElementRlt generated by hbm2java
 */
public class CmnRoleElementRlt  implements java.io.Serializable {


     private Long roleElementId;
     private Long roleId;
     private Long elementId;
     private String activateFlag;
     private Long createdUserId;
     private Date createdDate;
     private Long updatedUserId;
     private Date updatedDate;

    public CmnRoleElementRlt() {
    }

	
    public CmnRoleElementRlt(String activateFlag) {
        this.activateFlag = activateFlag;
    }
    public CmnRoleElementRlt(Long roleId, Long elementId, String activateFlag, Long createdUserId, Date createdDate, Long updatedUserId, Date updatedDate) {
       this.roleId = roleId;
       this.elementId = elementId;
       this.activateFlag = activateFlag;
       this.createdUserId = createdUserId;
       this.createdDate = createdDate;
       this.updatedUserId = updatedUserId;
       this.updatedDate = updatedDate;
    }
   
    public Long getRoleElementId() {
        return this.roleElementId;
    }
    
    public void setRoleElementId(Long roleElementId) {
        this.roleElementId = roleElementId;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getElementId() {
        return this.elementId;
    }
    
    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }
    public String getActivateFlag() {
        return this.activateFlag;
    }
    
    public void setActivateFlag(String activateFlag) {
        this.activateFlag = activateFlag;
    }
    public Long getCreatedUserId() {
        return this.createdUserId;
    }
    
    public void setCreatedUserId(Long createdUserId) {
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


