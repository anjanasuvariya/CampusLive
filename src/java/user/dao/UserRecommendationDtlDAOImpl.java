/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import user.model.UserRecommendationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserRecommendationDtlDAOImpl implements UserRecommendationDtlDAO{

    @Override
    public void saveUserRecommendationDtls(UserRecommendationDtls userRecommendationDtl) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            System.out.println("userRecommendationDtl.getRecmdDtlId....." + userRecommendationDtl.getRecmdDtlId());
            if (userRecommendationDtl.getRecmdDtlId() != null) {
                session.update(userRecommendationDtl);
            } else {
                session.save(userRecommendationDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<UserRecommendationDtls> getUserRecommendationDtls(Long lLngUserId) throws Exception {
         List<UserRecommendationDtls> lLstUserRecommendationDtls = new ArrayList<UserRecommendationDtls>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrHqlQuery = " from UserRecommendationDtls u where u.createdUserId=" + lLngUserId;
            System.out.println("Query======" + lStrHqlQuery);
            Query query = session.createQuery(lStrHqlQuery);
            
            lLstUserRecommendationDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstUserRecommendationDtls;
    }

    @Override
    public void deleteUserRecommendationDtls(List<UserRecommendationDtls> lLstUserRecommendationDtls) throws Exception {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            
            for(UserRecommendationDtls lObjUserRecommendationDtl : lLstUserRecommendationDtls)
            {
                session.delete(lObjUserRecommendationDtl);
            }
            
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
    
}
