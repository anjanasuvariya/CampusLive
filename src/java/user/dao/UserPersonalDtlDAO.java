/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import user.model.UserPersonalDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface UserPersonalDtlDAO {
    
    void saveUserPersonalDtls(UserPersonalDtls userPersonalDtl) throws Exception;
    
    public UserPersonalDtls getUserPersonalDtl(Long lLngUserId) throws Exception;
}
