/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;

import user.model.UserOrganizationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface UserOrganizationDtlDAO {
    
     void saveUserOrganizationDtls(UserOrganizationDtls userOrganizationDtl) throws Exception;
    
    List<UserOrganizationDtls> getUserOrganizationDtls(Long lLngUserId) throws Exception;
    
    void deleteUserOrganizationDtls(List<UserOrganizationDtls> lLstUserOrganizationDtls) throws Exception;
}
