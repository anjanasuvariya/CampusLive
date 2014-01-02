/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import java.util.List;
import placeComm.model.PcInterestInvitesDtls;

import placeComm.model.PcStudentInterestInviteDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface StudentInterestInviteDAO {
    
    List getStudentIntInviteDtl(Long lLngUniversityId,Long lLngLoggerInUserId) throws Exception;
    
    void saveStudInvitationDtls(PcStudentInterestInviteDtls pcStudentInterestInviteDtl) throws Exception;
    
    PcStudentInterestInviteDtls getStudInvtDtlFromInvtDtlId(Long lLngIntInvtDtlId) throws Exception;
}
