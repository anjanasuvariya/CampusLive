/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.model;

import java.util.Date;

/**
 *
 * @author SACHIN PATEL
 */
public class StudentInterestInviteCustomVO {
    
    Long studInvtDtlId;
    Long invtDtlId;
    String companyTitle;
    String jobDesc;
    String jobDescDoc;
    String lastDate;
    String studSelectionFlag;
    String hrSelectionFlag;

    public Long getStudInvtDtlId() {
        return studInvtDtlId;
    }

    public void setStudInvtDtlId(Long studInvtDtlId) {
        this.studInvtDtlId = studInvtDtlId;
    }

    public Long getInvtDtlId() {
        return invtDtlId;
    }

    public void setInvtDtlId(Long invtDtlId) {
        this.invtDtlId = invtDtlId;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobDescDoc() {
        return jobDescDoc;
    }

    public void setJobDescDoc(String jobDescDoc) {
        this.jobDescDoc = jobDescDoc;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getStudSelectionFlag() {
        return studSelectionFlag;
    }

    public void setStudSelectionFlag(String studSelectionFlag) {
        this.studSelectionFlag = studSelectionFlag;
    }

    public String getHrSelectionFlag() {
        return hrSelectionFlag;
    }

    public void setHrSelectionFlag(String hrSelectionFlag) {
        this.hrSelectionFlag = hrSelectionFlag;
    }
    
    
}
