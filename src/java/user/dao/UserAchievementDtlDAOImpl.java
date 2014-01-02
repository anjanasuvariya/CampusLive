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
import user.model.UserAchievementDtls;



/**
 *
 * @author SACHIN PATEL
 */
public class UserAchievementDtlDAOImpl implements UserAchievementDtlDAO{

    @Override
    public List<UserAchievementDtls> getUserAchievementDtls(Long lLngUserId) throws Exception {
        
        List<UserAchievementDtls> lLstUserAchievementDtls = new ArrayList<UserAchievementDtls>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            //session.beginTransaction();
            String lStrQuery = " from UserAchievementDtls u where u.createdUserId=" + lLngUserId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstUserAchievementDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstUserAchievementDtls;
    }

    @Override
    public void saveUserAchievementDtls(UserAchievementDtls userAchievementDtl) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("userAchievementDtl.getUserAchievementId....." + userAchievementDtl.getUserAchievementId());
            if (userAchievementDtl.getUserAchievementId() != null) {
                session.update(userAchievementDtl);
            } else {
                session.save(userAchievementDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void deleteUserAchievementDtls(List<UserAchievementDtls> lLstUserAchievementDtls) throws Exception {
       Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            for(UserAchievementDtls lObjUserAchievementDtl : lLstUserAchievementDtls)
            {
                session.delete(lObjUserAchievementDtl);
            }
            
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
}
