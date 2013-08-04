/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.UserContactDtls;


/**
 *
 * @author SACHIN PATEL
 */
public interface UserContactDtlDAO {
    
    void saveUserContactDtls(UserContactDtls userContactDtl) throws Exception;
    
    List<UserContactDtls> viewUserContactDtl(Long lLngUserId) throws Exception;
}
