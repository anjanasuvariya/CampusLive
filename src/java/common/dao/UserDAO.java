    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dao;

import java.util.List;
import common.model.CmnRoleActivationMpg;
import common.model.CmnUserMst;
import common.model.CmnUserRoleRlt;
import placeComm.model.PcHrDtls;
import admin.model.TmpUserExcelData;

/**
 *
 * @author SACHIN PATEL
 */
public interface UserDAO {
    
   void saveUser(CmnUserMst cmnUserMst) throws Exception;
   
   void insertUserRoleMpgDtl(CmnUserRoleRlt cmnUserRoleRlt) throws Exception;
   
   List<CmnUserMst> validateUserName(String lStrUserName) throws Exception;
   
   List<CmnRoleActivationMpg> validateActivationCode(String lStrActivationCode) throws Exception;
   
   List<PcHrDtls> validateActivationCodeForHR(String lStrActivationCode) throws Exception;
   
   List validateActnCodeForStudOrAlumniOfFaculty(String lStrUserType,String lStrActivationCode) throws Exception;
   
   List validateActivationCodeWithExistingCode(String lStrActivationCode) throws Exception;
   
}
