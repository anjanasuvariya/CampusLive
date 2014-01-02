/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.model;

/**
 *
 * @author SACHIN PATEL
 */
public class AppointmentCustomVO {
    
     private Long appntDtlId;
     private String appntTitle;
     private String appntPurpose;
     private String appntFileName;
     private String appntCompanyId;
     private String appntCompanyName;
     private String ownerId;
     private String ownerName;
     private String assignedUserId;
     private String assignedUserName;
     private String appntStatus;
     private String lastUpdatedMsg;
     private String appntMessage;
     private String appntPriority;
     private Long hstAppntDtlId;

     public AppointmentCustomVO(){}

    public AppointmentCustomVO(Long appntDtlId, String appntTitle, String appntPurpose, String appntFileName, String appntCompanyId, String appntCompanyName,String ownerId, String ownerName, String assignedUserId, String assignedUserName,String appntStatus, String lastUpdatedMsg, String appntPriority, Long hstAppntDtlId) {
        this.appntDtlId = appntDtlId;
        this.appntTitle = appntTitle;
        this.appntPurpose = appntPurpose;
        this.appntFileName = appntFileName;
        this.appntCompanyId = appntCompanyId;
        this.appntCompanyName = appntCompanyName;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.assignedUserId = assignedUserId;
        this.assignedUserName = assignedUserName;
        this.appntStatus = appntStatus;
        this.lastUpdatedMsg = lastUpdatedMsg;
        this.appntPriority = appntPriority;
        this.hstAppntDtlId = hstAppntDtlId;
    }
     
   

    public AppointmentCustomVO(Long hstAppntDtlId,String assignedUserName, String appntMessage, String appntStatus) {
        this.assignedUserName = assignedUserName;
        this.appntStatus = appntStatus;
        this.appntMessage = appntMessage;
        this.hstAppntDtlId = hstAppntDtlId;
    }
        
    public Long getAppntDtlId() {
        return appntDtlId;
    }

    public void setAppntDtlId(Long appntDtlId) {
        this.appntDtlId = appntDtlId;
    }

    public String getAppntTitle() {
        return appntTitle;
    }

    public void setAppntTitle(String appntTitle) {
        this.appntTitle = appntTitle;
    }

    public String getAppntPurpose() {
        return appntPurpose;
    }

    public void setAppntPurpose(String appntPurpose) {
        this.appntPurpose = appntPurpose;
    }

    public String getAppntFileName() {
        return appntFileName;
    }

    public void setAppntFileName(String appntFileName) {
        this.appntFileName = appntFileName;
    }

    public String getAppntCompanyId() {
        return appntCompanyId;
    }

    public void setAppntCompanyId(String appntCompanyId) {
        this.appntCompanyId = appntCompanyId;
    }

    public String getAppntCompanyName() {
        return appntCompanyName;
    }

    public void setAppntCompanyName(String appntCompanyName) {
        this.appntCompanyName = appntCompanyName;
    }

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAssignedUserName() {
        return assignedUserName;
    }

    public void setAssignedUserName(String assignedUserName) {
        this.assignedUserName = assignedUserName;
    }

    public String getAppntStatus() {
        return appntStatus;
    }

    public void setAppntStatus(String appntStatus) {
        this.appntStatus = appntStatus;
    }

    public String getLastUpdatedMsg() {
        return lastUpdatedMsg;
    }

    public void setLastUpdatedMsg(String lastUpdatedMsg) {
        this.lastUpdatedMsg = lastUpdatedMsg;
    }

    public String getAppntMessage() {
        return appntMessage;
    }

    public void setAppntMessage(String appntMessage) {
        this.appntMessage = appntMessage;
    }

    public String getAppntPriority() {
        return appntPriority;
    }

    public void setAppntPriority(String appntPriority) {
        this.appntPriority = appntPriority;
    }

    public Long getHstAppntDtlId() {
        return hstAppntDtlId;
    }

    public void setHstAppntDtlId(Long hstAppntDtlId) {
        this.hstAppntDtlId = hstAppntDtlId;
    }
     
      
}
