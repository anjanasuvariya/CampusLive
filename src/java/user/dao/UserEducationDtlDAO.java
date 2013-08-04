/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.UserEducationDtls;


/**
 *
 * @author SACHIN PATEL
 */
public interface UserEducationDtlDAO {
    
    void saveUserEducationDtls(UserEducationDtls userEducationDtl) throws Exception;
    
    List<UserEducationDtls> getUserEducationDtls(Long lLngUserId) throws Exception;
    
    void deleteUserEducationDtls(List<UserEducationDtls> lLstUserEducationDtls) throws Exception;
}
