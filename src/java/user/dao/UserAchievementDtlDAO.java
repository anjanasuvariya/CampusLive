/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.UserAchievementDtls;



/**
 *
 * @author SACHIN PATEL
 */
public interface UserAchievementDtlDAO {
    
    public List<UserAchievementDtls> getUserAchievementDtls(Long lLngUserId) throws Exception;
    
    public void saveUserAchievementDtls(UserAchievementDtls userAchievementDtl) throws Exception;
    
    void deleteUserAchievementDtls(List<UserAchievementDtls> lLstUserAchievementDtls) throws Exception;
}
