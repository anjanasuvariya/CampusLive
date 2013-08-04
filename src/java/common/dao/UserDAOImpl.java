/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dao;

import common.helper.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import common.model.CmnRoleActivationMpg;
import common.model.CmnUserMst;
import common.model.CmnUserRoleRlt;

/**
 *
 * @author ANJANA PATEL
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void createUser(CmnUserMst cmnUserMst) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(cmnUserMst);
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }

    }

    @Override
    public List<CmnRoleActivationMpg> validateActivationCode(String lStrActivationCode) throws Exception {
        List<CmnRoleActivationMpg> lLstCmnRoleActivationMpg = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = " from CmnRoleActivationMpg u where u.activationCode=:activationCode";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setString("activationCode", lStrActivationCode);

            lLstCmnRoleActivationMpg =  query.list();

            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return lLstCmnRoleActivationMpg;
    }

    @Override
    public void insertUserRoleMpgDtl(CmnUserRoleRlt cmnUserRoleRlt) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(cmnUserRoleRlt);
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<CmnUserMst> validateUserName(String lStrUserName) throws Exception {
       List<CmnUserMst> lLstCmnUserMst = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = " from CmnUserMst u where u.userName=:userName";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setString("userName", lStrUserName);

            lLstCmnUserMst =  query.list();

            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return lLstCmnUserMst;
    }
}
