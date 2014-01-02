/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HR.dao;

import java.util.Date;
import java.util.List;
import placeComm.model.PcInterestInvitesDtls;
import user.model.UserEducationDtls;
import user.model.UserOrganizationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface HRSelectionDAO {
    
     int updateStudentSelectionDtl(List lLstStudInvtDtlId,String lStrHrSelectionFlag,Long lLngUserId,Date lDtUpdatedDate) throws Exception;
     
     List<PcInterestInvitesDtls> getHrWorkList(Long lLngLoggerInUserId,Long lLngUniversityId) throws Exception; 
     
     List getUserPersonalDtls(Long lLngInvtDtlId) throws Exception;
     
     List<UserEducationDtls> getUserEducationDtls(List<Long> lLstUserId) throws Exception;
     
     List<UserOrganizationDtls> getUserWorkExDtls(List<Long> lLstUserId) throws Exception;
     
}
