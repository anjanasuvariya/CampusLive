package assignment.model;
// Generated Aug 1, 2013 7:28:41 PM by Hibernate Tools 3.2.1.GA



/**
 * AssgSubmitMst generated by hbm2java
 */
public class AssgSubmitMst  implements java.io.Serializable {


     private Integer assgSubmitId;
     private Integer assgId;
     private Integer assgUserId;
     private Integer assgSubmitType;
     private String assgFileUrl;
     private String assgResponseText;
     private String assgUsername;
     private Integer assgSubmitIdHide;

    public AssgSubmitMst() {
    }

    public AssgSubmitMst(Integer assgId, Integer assgUserId, Integer assgSubmitType, String assgFileUrl, String assgResponseText, String assgUsername, Integer assgSubmitIdHide) {
       this.assgId = assgId;
       this.assgUserId = assgUserId;
       this.assgSubmitType = assgSubmitType;
       this.assgFileUrl = assgFileUrl;
       this.assgResponseText = assgResponseText;
       this.assgUsername = assgUsername;
       this.assgSubmitIdHide = assgSubmitIdHide;
    }
   
    public Integer getAssgSubmitId() {
        return this.assgSubmitId;
    }
    
    public void setAssgSubmitId(Integer assgSubmitId) {
        this.assgSubmitId = assgSubmitId;
    }
    public Integer getAssgId() {
        return this.assgId;
    }
    
    public void setAssgId(Integer assgId) {
        this.assgId = assgId;
    }
    public Integer getAssgUserId() {
        return this.assgUserId;
    }
    
    public void setAssgUserId(Integer assgUserId) {
        this.assgUserId = assgUserId;
    }
    public Integer getAssgSubmitType() {
        return this.assgSubmitType;
    }
    
    public void setAssgSubmitType(Integer assgSubmitType) {
        this.assgSubmitType = assgSubmitType;
    }
    public String getAssgFileUrl() {
        return this.assgFileUrl;
    }
    
    public void setAssgFileUrl(String assgFileUrl) {
        this.assgFileUrl = assgFileUrl;
    }
    public String getAssgResponseText() {
        return this.assgResponseText;
    }
    
    public void setAssgResponseText(String assgResponseText) {
        this.assgResponseText = assgResponseText;
    }
    public String getAssgUsername() {
        return this.assgUsername;
    }
    
    public void setAssgUsername(String assgUsername) {
        this.assgUsername = assgUsername;
    }
    public Integer getAssgSubmitIdHide() {
        return this.assgSubmitIdHide;
    }
    
    public void setAssgSubmitIdHide(Integer assgSubmitIdHide) {
        this.assgSubmitIdHide = assgSubmitIdHide;
    }




}


