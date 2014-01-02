/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import java.util.List;
import placeComm.model.PcCompanyDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface CompanyDtlDAO {
    
    void saveCompanyDtls(PcCompanyDtls pcCompanyDtls) throws Exception;
    
    PcCompanyDtls getCompanyDtlFromId(Long companyId) throws Exception;
    
    List<PcCompanyDtls> getCompanyList(Long lLngLoggedInUserId) throws Exception;
    
    int deleteCompanyDtls(List<Long> lLstCompanyId) throws Exception;
}
