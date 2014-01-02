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
import user.model.UserEducationDtls;


/**
 *
 * @author SACHIN PATEL
 */
public class UserEducationDtlDAOImpl implements UserEducationDtlDAO{

    @Override
    public void saveUserEducationDtls(UserEducationDtls userEducationDtl) throws Exception {
       Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("userEducationDtl.getUserEducationId....." + userEducationDtl.getUserEducationId());
            if (userEducationDtl.getUserEducationId() != null) {
                session.update(userEducationDtl);
            } else {
                session.save(userEducationDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<UserEducationDtls> getUserEducationDtls(Long lLngUserId) throws Exception {
       List<UserEducationDtls> lLstUserEducationDtls = new ArrayList<UserEducationDtls>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            //session.beginTransaction();
            String lStrHqlQuery = " from UserEducationDtls u where u.createdUserId=" + lLngUserId;
            System.out.println("Query======" + lStrHqlQuery);
            Query query = session.createQuery(lStrHqlQuery);
            
            lLstUserEducationDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstUserEducationDtls;
    }
    
    public void deleteUserEducationDtls(List<UserEducationDtls> lLstUserEducationDtls) throws Exception {
       Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            for(UserEducationDtls lObjUserEducationDtl : lLstUserEducationDtls)
            {
                session.delete(lObjUserEducationDtl);
            }
            
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
}
