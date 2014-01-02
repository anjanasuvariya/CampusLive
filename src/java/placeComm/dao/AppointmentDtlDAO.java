/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import java.util.List;
import placeComm.model.AppointmentCustomVO;
import placeComm.model.HstAppointmentDtls;
import placeComm.model.PcAppointmentDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface AppointmentDtlDAO {
    
    void saveAppointmentDtls(PcAppointmentDtls pcAppointmentDtl) throws Exception;
    
    PcAppointmentDtls getAppntDtlFromId(Long appntDtlId) throws Exception;
    
    List<AppointmentCustomVO> getAppointmentList(Long lLngLoggedInUserId) throws Exception;
    
    int deleteAppntDtls(List<Long> lLstAppntDtlId) throws Exception;
    
    int deleteAppntHistory(List<Long> lLstAppntDtlId) throws Exception;
    
    void saveAppntHstDtls(HstAppointmentDtls hstAppointmentDtls) throws Exception;
    
    HstAppointmentDtls getHstAppntDtlFromId(Long hstAppntDtlId) throws Exception;
    
    List<AppointmentCustomVO> getApptHstByAppntId(Long lLngAppntDtlId) throws Exception;
}
