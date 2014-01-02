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
import user.model.UserOrganizationDtls;
import user.model.UserProjectDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserProjectDtlDAOImpl implements UserProjectDtlDAO{

    @Override
    public void saveUserProjectDtls(UserProjectDtls userProjectDtl) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("userProjectDtl.getProjDtlId....." + userProjectDtl.getProjDtlId());
            if (userProjectDtl.getProjDtlId() != null) {
                session.update(userProjectDtl);
            } else {
                session.save(userProjectDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<UserProjectDtls> getUserProjectDtls(Long lLngUserId) throws Exception {
        List<UserProjectDtls> lLstUserProjectDtls = new ArrayList<UserProjectDtls>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrHqlQuery = " from UserProjectDtls u where u.createdUserId=" + lLngUserId;
            System.out.println("Query======" + lStrHqlQuery);
            Query query = session.createQuery(lStrHqlQuery);
            
            lLstUserProjectDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstUserProjectDtls;
    }

    @Override
    public void deleteUserProjectDtls(List<UserProjectDtls> lLstUserProjectDtls) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            for(UserProjectDtls lObjUserProjectDtl : lLstUserProjectDtls)
            {
                session.delete(lObjUserProjectDtl);
            }
            
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
}
