/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import placeComm.model.AppointmentCustomVO;
import placeComm.model.HstAppointmentDtls;
import placeComm.model.PcAppointmentDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class AppointmentDtlDAOImpl implements AppointmentDtlDAO {
    
    @Override
    public void saveAppointmentDtls(PcAppointmentDtls pcAppointmentDtl) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("pcAppointmentDtl.getAppntDtlId()....." + pcAppointmentDtl.getAppntDtlId());
            if (pcAppointmentDtl.getAppntDtlId() != null) {
                session.update(pcAppointmentDtl);
            } else {
                session.save(pcAppointmentDtl);
            }
            tx.commit();
            
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public PcAppointmentDtls getAppntDtlFromId(Long appntDtlId) throws Exception {
        List<PcAppointmentDtls> lLstPcAppointmentDtls = null;
        PcAppointmentDtls lObjPcAppointmentDtl = new PcAppointmentDtls();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = " from PcAppointmentDtls where appntDtlId=" + appntDtlId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstPcAppointmentDtls = query.list();
            if (lLstPcAppointmentDtls != null && !lLstPcAppointmentDtls.isEmpty()) {
                lObjPcAppointmentDtl = lLstPcAppointmentDtls.get(0);
            }
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            throw e;
        }
        return lObjPcAppointmentDtl;
    }
    
    @Override
    public List<AppointmentCustomVO> getAppointmentList(Long lLngLoggedInUserId) throws Exception {
        List lLstResult = new ArrayList();
        List<AppointmentCustomVO> lLstPcAppointmentDtls = new ArrayList<AppointmentCustomVO>();
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            //String lStrQuery = " from PcAppointmentDtls where createdUserId= :loggedInUserId or assignedTo= :loggedInUserId";

            
            String lStrQuery = "select pad.APPNT_DTL_ID,pad.APPNT_TITLE,pad.APPNT_PURPOSE,appnt_file_name,pad.APPNT_COMPANY,pcd.COMPANY_TITLE,"
                    + " pad.OWNER_ID,concat(cum.USER_FIRST_NAME, ' ', coalesce(cum.USER_MIDDLE_NAME, ''), ' ', coalesce(cum.USER_LAST_NAME, ' ')) as owner_name,pad.ASSIGNED_TO,"
                    + " concat(user.USER_FIRST_NAME, ' ', coalesce(user.USER_MIDDLE_NAME, ''), ' ', coalesce(user.USER_LAST_NAME, ' ')) as assigned_user_name,"
                    + " had1.STATUS,had1.message,pad.appnt_priority,had1.HST_APPNT_DTL_ID"
                    + " from"
                    + " pc_appointment_dtls pad JOIN hst_appointment_dtls had1 ON (pad.APPNT_DTL_ID = had1.APPNT_DTL_ID)"
                    + " LEFT OUTER JOIN hst_appointment_dtls had2 ON (pad.APPNT_DTL_ID = had2.APPNT_DTL_ID AND"
                    + " (had1.CREATED_DATE < had2.CREATED_DATE OR had1.CREATED_DATE = had2.CREATED_DATE AND had1.HST_APPNT_DTL_ID < had2.HST_APPNT_DTL_ID))"
                    + " join pc_company_dtls pcd on pad.APPNT_COMPANY = pcd.COMPANY_ID"
                    + " join cmn_user_mst cum on pad.OWNER_ID = cum.user_id"
                    + " join cmn_user_mst user on pad.ASSIGNED_TO = user.user_id"
                    + " where had2.HST_APPNT_DTL_ID IS NULL and (pad.created_User_Id = :loggedInUserId or pad.assigned_To= :loggedInUserId)";




//            String lStrQuery = "select new placeComm.model.AppointmentCustomVO(pad.appntDtlId,pad.appntTitle,pad.appntPurpose,appntFileName,pad.appntCompany,pcd.companyTitle,"
//                    + "(cum.userFirstName || ' '|| coalesce(cum.userMiddleName , '')|| ' '|| coalesce(cum.userLastName,'')) as ownerName,pad.assignedTo,"
//                    + "(user.userFirstName || ' '|| coalesce(user.userMiddleName , '')|| ' '|| coalesce(user.userLastName,'')) as assignedUserName,"
//                    + "had1.status,had1.message,pad.appntPriority,had1.hstAppntDtlId)"
//                    + " from"
//                    + " PcAppointmentDtls pad JOIN HstAppointmentDtls had1 as (pad.appntDtlId = had1.appntDtlId)"
//                    + " LEFT OUTER JOIN HstAppointmentDtls had2 as (pad.appntDtlId = had2.appntDtlId AND"
//                    + " (had1.createdDate < had2.createdDate OR had1.createdDate = had2.createdDate AND had1.hstAppntDtlId < had2.hstAppntDtlId))"
//                    + " join PcCompanyDtls pcd as pad.appntCompany = pcd.companyId"
//                    + " join CmnUserMst cum as pad.ownerId = cum.userId"
//                    + " join CmnUserMst user as pad.assignedTo = user.userId"
//                    + " where had2.hstAppntDtlId IS NULL and  pad.createdUserId= :loggedInUserId or pad.assignedTo= :loggedInUserId";

            System.out.println("Query======" + lStrQuery);
            Query query = session.createSQLQuery(lStrQuery);
            query.setParameter("loggedInUserId", lLngLoggedInUserId);
            lLstResult = query.list();
           
            if (lLstResult != null && !lLstResult.isEmpty()) {
                for (Object obj : lLstResult) {
                    Object[] objArr = (Object[]) obj;
                    AppointmentCustomVO lObjAppointmentCustomVO = new AppointmentCustomVO();
                    if (objArr[0] != null) {
                        lObjAppointmentCustomVO.setAppntDtlId(Long.parseLong(objArr[0].toString()));
                    }
                    if (objArr[1] != null) {
                        lObjAppointmentCustomVO.setAppntTitle(objArr[1].toString());
                    }
                    if (objArr[2] != null) {
                        lObjAppointmentCustomVO.setAppntPurpose(objArr[2].toString());
                    }
                    if (objArr[3] != null) {
                        lObjAppointmentCustomVO.setAppntFileName(objArr[3].toString());
                    }
                    if (objArr[4] != null) {
                        lObjAppointmentCustomVO.setAppntCompanyId(objArr[4].toString());
                    }
                    if (objArr[5] != null) {
                        lObjAppointmentCustomVO.setAppntCompanyName(objArr[5].toString());
                    }
                     if (objArr[6] != null) {
                        lObjAppointmentCustomVO.setOwnerId(objArr[6].toString());
                    }
                    
                     if (objArr[7] != null) {
                        lObjAppointmentCustomVO.setOwnerName(objArr[7].toString());
                    }
                      if (objArr[8] != null) {
                        lObjAppointmentCustomVO.setAssignedUserId(objArr[8].toString());
                    }
                    if (objArr[9] != null) {
                        lObjAppointmentCustomVO.setAssignedUserName(objArr[9].toString());
                    }
                    if (objArr[10] != null) {
                        lObjAppointmentCustomVO.setAppntStatus(objArr[10].toString());
                    }
                    if (objArr[11] != null) {
                        lObjAppointmentCustomVO.setLastUpdatedMsg(objArr[11].toString());
                    }
                    if (objArr[12] != null) {
                        lObjAppointmentCustomVO.setAppntPriority(objArr[12].toString());
                    }
                    if (objArr[13] != null) {
                        lObjAppointmentCustomVO.setHstAppntDtlId(Long.parseLong(objArr[13].toString()));
                    }
                    lLstPcAppointmentDtls.add(lObjAppointmentCustomVO);
                               
                }
            }
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw e;
        }
        return lLstPcAppointmentDtls;
    }
    
    @Override
    public int deleteAppntDtls(List<Long> lLstAppntDtlId) throws Exception {
        int result;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = "Delete from PcAppointmentDtls where appntDtlId in (:appntDtlIdList)";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameterList("appntDtlIdList", lLstAppntDtlId);
            result = query.executeUpdate();
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
    public void saveAppntHstDtls(HstAppointmentDtls hstAppointmentDtls) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("hstAppointmentDtls.getHstAppntDtlId()....." + hstAppointmentDtls.getHstAppntDtlId());
            if (hstAppointmentDtls.getHstAppntDtlId() != null) {
                session.update(hstAppointmentDtls);
            } else {
                session.save(hstAppointmentDtls);
            }
            tx.commit();
            
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public List<AppointmentCustomVO> getApptHstByAppntId(Long lLngAppntDtlId) throws Exception {
        List<AppointmentCustomVO> lLstAppointmentHst = new ArrayList<AppointmentCustomVO>();
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = "select new placeComm.model.AppointmentCustomVO(hpd.hstAppntDtlId,"
                    + " (cum.userFirstName || ' '|| coalesce(cum.userMiddleName , '')|| ' '|| coalesce(cum.userLastName,'')) as userName,hpd.message,hpd.status) "
                    + " from HstAppointmentDtls hpd, CmnUserMst cum "
                    + " where hpd.userId = cum.userId and hpd.appntDtlId= :appntDtlId order by hpd.hstAppntDtlId";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameter("appntDtlId", lLngAppntDtlId);
            
            lLstAppointmentHst = query.list();
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            throw e;
        }
        return lLstAppointmentHst;
    }
    
    @Override
    public HstAppointmentDtls getHstAppntDtlFromId(Long hstAppntDtlId) throws Exception {
        List<HstAppointmentDtls> lLstHstAppointmentDtls = null;
        HstAppointmentDtls lObjHstAppointmentDtls = new HstAppointmentDtls();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = " from HstAppointmentDtls where hstAppntDtlId= :hstAppntDtlId";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameter("hstAppntDtlId", hstAppntDtlId);
            lLstHstAppointmentDtls = query.list();
            if (lLstHstAppointmentDtls != null && !lLstHstAppointmentDtls.isEmpty()) {
                lObjHstAppointmentDtls = lLstHstAppointmentDtls.get(0);
            }
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            throw e;
        }
        return lObjHstAppointmentDtls;
    }

    @Override
    public int deleteAppntHistory(List<Long> lLstAppntDtlId) throws Exception {
        int result;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = "Delete from HstAppointmentDtls where appntDtlId in (:appntDtlIdList)";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameterList("appntDtlIdList", lLstAppntDtlId);
            result = query.executeUpdate();
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
