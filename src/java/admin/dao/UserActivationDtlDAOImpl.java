/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.model.TmpUserExcelData;
import common.helper.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SACHIN PATEL
 */
public class UserActivationDtlDAOImpl implements UserActivationDtlDAO{

    @Override
    public List<TmpUserExcelData> getUserActivationDtls(Long lLngUniversityId) throws Exception {
        List<TmpUserExcelData> lLstResult = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = " from TmpUserExcelData where universityId = :universityId";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setLong("universityId", lLngUniversityId);
            
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
    public List<TmpUserExcelData> getUserActivationDtlsByIds(Long lLngUniversityId,List<Long> lLstActIds) throws Exception {
        List<TmpUserExcelData> lLstResult = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = " from TmpUserExcelData where id in (:actIdList) and universityId = :universityId";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setParameterList("actIdList", lLstActIds);
            query.setLong("universityId", lLngUniversityId);
            
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
    public void updateUserIdInUserExcelData(TmpUserExcelData lObjTmpUserExcelData) throws Exception {
       Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
          
            session.update(lObjTmpUserExcelData);
          
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

   
}
