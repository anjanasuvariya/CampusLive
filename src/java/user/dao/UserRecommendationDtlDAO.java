/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import user.model.UserRecommendationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public interface UserRecommendationDtlDAO {
    
     void saveUserRecommendationDtls(UserRecommendationDtls userRecommendationDtl) throws Exception;
    
    List<UserRecommendationDtls> getUserRecommendationDtls(Long lLngUserId) throws Exception;
    
    void deleteUserRecommendationDtls(List<UserRecommendationDtls> lLstUserRecommendationDtls) throws Exception;
}
