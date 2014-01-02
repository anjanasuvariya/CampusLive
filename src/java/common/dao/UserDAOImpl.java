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
import placeComm.model.PcHrDtls;
import admin.model.TmpUserExcelData;

/**
 *
 * @author ANJANA PATEL
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void saveUser(CmnUserMst cmnUserMst) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            if (cmnUserMst.getUserId() != null) {
                session.update(cmnUserMst);
            } else {
                session.save(cmnUserMst);
            }
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
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
    public List<PcHrDtls> validateActivationCodeForHR(String lStrActivationCode) throws Exception {
        List<PcHrDtls> lLstPcHrDtls = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = " from PcHrDtls where activationCode=:activationCode";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setString("activationCode", lStrActivationCode);

            lLstPcHrDtls =  query.list();

            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return lLstPcHrDtls;
    }

    @Override
    public void insertUserRoleMpgDtl(CmnUserRoleRlt cmnUserRoleRlt) throws Exception {
        Session session = null;
        try {
             session = HibernateUtil.getSessionFactory().openSession();
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
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
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

    @Override
    public List validateActnCodeForStudOrAlumniOfFaculty(String lStrUserType, String lStrActivationCode) throws Exception {
        List lLstResult = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = " from TmpUserExcelData where userType = :userType and activationCode=:activationCode";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setString("activationCode", lStrActivationCode);
            query.setString("userType", lStrUserType);

            lLstResult =  query.list();

            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return lLstResult;
    }

    @Override
    public List validateActivationCodeWithExistingCode(String lStrActivationCode) throws Exception {
         List lLstResult = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = " from CmnUserMst where userActivationCode=:activationCode";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setString("activationCode", lStrActivationCode);
            
            lLstResult =  query.list();

            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return lLstResult;
    }

   
}
