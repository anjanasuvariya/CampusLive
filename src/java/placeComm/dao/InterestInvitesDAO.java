/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import java.util.List;
import placeComm.model.AppointmentCustomVO;
import placeComm.model.PcAppointmentDtls;
import placeComm.model.PcInterestInvitesDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface InterestInvitesDAO {
    
    void saveInvitationDtls(PcInterestInvitesDtls pcInterestInvitesDtls) throws Exception;
    
    PcInterestInvitesDtls getInvtDtlFromId(Long intDtlId) throws Exception;
    
   List<PcInterestInvitesDtls> getInvtList(Long lLngLoggedInUserId) throws Exception;
    
    int deleteInvtDtls(List<Long> lLstInvtDtlId) throws Exception;
}
