/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dao;

import common.model.ComboValueVO;
import java.util.List;

/**
 *
 * @author SACHIN PATEL
 */
public interface CommonDAO {
    
    List<ComboValueVO> getCompanyList() throws Exception;
    
    List<ComboValueVO> getPlaceCommMemberList(Long lLngUnivesityId,Long lLngRoleId) throws Exception;
    
    List<ComboValueVO> getEducationList() throws Exception;
}
