package assignment.model;
// Generated Aug 1, 2013 7:28:41 PM by Hibernate Tools 3.2.1.GA



/**
 * AssgDtl generated by hbm2java
 */
public class AssgDtl  implements java.io.Serializable {


     private Integer assgDtlId;
     private int assgMstId;
     private int assgGroupFlag;
     private int assgUserId;
     private Integer assgDtlIdHide;

    public AssgDtl() {
    }

	
    public AssgDtl(int assgMstId, int assgGroupFlag, int assgUserId) {
        this.assgMstId = assgMstId;
        this.assgGroupFlag = assgGroupFlag;
        this.assgUserId = assgUserId;
    }
    public AssgDtl(int assgMstId, int assgGroupFlag, int assgUserId, Integer assgDtlIdHide) {
       this.assgMstId = assgMstId;
       this.assgGroupFlag = assgGroupFlag;
       this.assgUserId = assgUserId;
       this.assgDtlIdHide = assgDtlIdHide;
    }
   
    public Integer getAssgDtlId() {
        return this.assgDtlId;
    }
    
    public void setAssgDtlId(Integer assgDtlId) {
        this.assgDtlId = assgDtlId;
    }
    public int getAssgMstId() {
        return this.assgMstId;
    }
    
    public void setAssgMstId(int assgMstId) {
        this.assgMstId = assgMstId;
    }
    public int getAssgGroupFlag() {
        return this.assgGroupFlag;
    }
    
    public void setAssgGroupFlag(int assgGroupFlag) {
        this.assgGroupFlag = assgGroupFlag;
    }
    public int getAssgUserId() {
        return this.assgUserId;
    }
    
    public void setAssgUserId(int assgUserId) {
        this.assgUserId = assgUserId;
    }
    public Integer getAssgDtlIdHide() {
        return this.assgDtlIdHide;
    }
    
    public void setAssgDtlIdHide(Integer assgDtlIdHide) {
        this.assgDtlIdHide = assgDtlIdHide;
    }




}


