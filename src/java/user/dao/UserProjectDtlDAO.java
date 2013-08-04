/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.UserProjectDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface UserProjectDtlDAO {
    
    void saveUserProjectDtls(UserProjectDtls userProjectDtl) throws Exception;
    
    List<UserProjectDtls> getUserProjectDtls(Long lLngUserId) throws Exception;
    
    void deleteUserProjectDtls(List<UserProjectDtls> lLstUserProjectDtls) throws Exception;
}
