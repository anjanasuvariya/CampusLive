/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import java.util.List;
import placeComm.model.PcAlumniDtls;


/**
 *
 * @author SACHIN PATEL
 */
public interface AlumniDtlDAO {
    
    void saveAlumniDtls(PcAlumniDtls pcAlumniDtl) throws Exception;
    
    PcAlumniDtls getAlumniDtlFromId(Long alumniDtlId) throws Exception;
    
    List<PcAlumniDtls> getAlumniList(Long lLngLoggedInUserId) throws Exception;
    
    int deleteAlumniDtls(List<Long> lLstAlumniDtlId) throws Exception;
}
