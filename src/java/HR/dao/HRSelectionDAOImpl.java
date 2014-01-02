/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HR.dao;

import admin.model.TmpUserExcelData;
import common.helper.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import placeComm.model.PcInterestInvitesDtls;
import user.model.UserEducationDtls;
import user.model.UserOrganizationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class HRSelectionDAOImpl implements HRSelectionDAO{

    @Override
    public int updateStudentSelectionDtl(List lLstStudInvtDtlId,String lStrHrSelectionFlag,Long lLngUserId,Date lDtUpdatedDate) throws Exception {
        Session session = null;
        int lIntResult=0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = "update PcStudentInterestInviteDtls  set updatedUserId = :updatedUserId,  updatedDate= :updatedDate,"
                    + " hrSelectionFlag = :hrSelectionFlag where studInvtDtlId in (:studInvtDtlIdList)";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setLong("updatedUserId", lLngUserId);
            query.setDate("updatedDate", lDtUpdatedDate);
            query.setString("hrSelectionFlag", lStrHrSelectionFlag);
            query.setParameterList("studInvtDtlIdList", lLstStudInvtDtlId);
            lIntResult = query.executeUpdate();

            tx.commit();
            //session.close();

        } catch (Exception e) {
             //session.close();
            throw e;
        }
        finally{
             //session.close();
        }

        return lIntResult;
    }

    @Override
    public List<PcInterestInvitesDtls> getHrWorkList(Long lLngLoggerInUserId,Long lLngUniversityId) throws Exception {
         List<PcInterestInvitesDtls> lLstResult = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = "select pid from PcInterestInvitesDtls pid, PcHrDtls phd"
                    + " where pid.companyId = phd.companyId and phd.hrUserId = :userId and phd.universityId = :universityId";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setLong("userId", lLngLoggerInUserId);
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
    public List getUserPersonalDtls(Long lLngInvtDtlId) throws Exception {
        List lLstResult = null;
        Session session =null;
    
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = "select new user.model.UserPersonalDtls(cum.userId,cum.userFirstName,cum.userMiddleName,userLastName,"
                    + " upd.gender,upd.facebookLink,upd.twitterLink,upd.linkedInLink)"
                    + " from PcStudentInterestInviteDtls psd, CmnUserMst cum, UserPersonalDtls upd"
                    + " where psd.studUserId=cum.userId and cum.userId = upd.createdUserId and psd.invtDtlId = :invtDtlId";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setLong("invtDtlId", lLngInvtDtlId);
                        
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
    public List<UserEducationDtls> getUserEducationDtls(List<Long> lLstUserId) throws Exception {
        List<UserEducationDtls> lLstResult = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = "from UserEducationDtls where createdUserId in (:userList)";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setParameterList("userList", lLstUserId);
            
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
    public List<UserOrganizationDtls> getUserWorkExDtls(List<Long> lLstUserId) throws Exception {
         List<UserOrganizationDtls> lLstResult = null;
        Session session =null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            String lStrHqlQuery = "from UserOrganizationDtls where createdUserId in (:userList)";
            
            Query query = session.createQuery(lStrHqlQuery);
            query.setParameterList("userList", lLstUserId);
            
            lLstResult = query.list();

            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return lLstResult;
    }
    
}
