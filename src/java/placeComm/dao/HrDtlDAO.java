/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import java.util.List;
import placeComm.model.PcHrDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface HrDtlDAO {
    
    void saveHrDtls(PcHrDtls pcHrDtls) throws Exception;
    
    PcHrDtls getHrDtlFromId(Long hrDtlId) throws Exception;
    
    List<PcHrDtls> getHrList(Long lLngLoggedInUserId) throws Exception;
    
    int deleteHrDtls(List<Long> lLstHrDtlId) throws Exception;
}
