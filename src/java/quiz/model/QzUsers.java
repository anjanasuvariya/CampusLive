package quiz.model;
// Generated Aug 1, 2013 7:28:41 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * QzUsers generated by hbm2java
 */
public class QzUsers  implements java.io.Serializable {


     private Integer userId;
     private String username;
     private String email;
     private String password;
     private Date lastLog;
     private String ipAddress;

    public QzUsers() {
    }

    public QzUsers(String username, String email, String password, Date lastLog, String ipAddress) {
       this.username = username;
       this.email = email;
       this.password = password;
       this.lastLog = lastLog;
       this.ipAddress = ipAddress;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getLastLog() {
        return this.lastLog;
    }
    
    public void setLastLog(Date lastLog) {
        this.lastLog = lastLog;
    }
    public String getIpAddress() {
        return this.ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }




}


