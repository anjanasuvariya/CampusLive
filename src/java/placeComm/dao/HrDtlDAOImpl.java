/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package placeComm.dao;

import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import placeComm.model.PcHrDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class HrDtlDAOImpl implements HrDtlDAO {

    @Override
    public void saveHrDtls(PcHrDtls pcHrDtls) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("pcHrDtls.getHrDtlId()....." + pcHrDtls.getHrDtlId());
            if (pcHrDtls.getHrDtlId() != null) {
                session.update(pcHrDtls);
            } else {
                session.save(pcHrDtls);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public PcHrDtls getHrDtlFromId(Long hrDtlId) throws Exception {
        List<PcHrDtls> lLstPcHrDtls = new ArrayList<PcHrDtls>();
        PcHrDtls lObjPcHrDtl = new PcHrDtls();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = " from PcHrDtls where hrDtlId=" + hrDtlId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstPcHrDtls = query.list();
            if(lLstPcHrDtls != null && !lLstPcHrDtls.isEmpty())
            {
                lObjPcHrDtl = lLstPcHrDtls.get(0);
            }
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lObjPcHrDtl;
    }

    @Override
    public List<PcHrDtls> getHrList(Long lLngLoggedInUserId) throws Exception {
        List<PcHrDtls> lLstPcHrDtls = new ArrayList<PcHrDtls>();
       
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
             String lStrQuery = "select new placeComm.model.PcHrDtls(phd.hrDtlId, phd.hrName, phd.companyId, phd.designation, "
                     + "phd.hrTeleNo, phd.hrMobileNo, phd.hrEmailId, phd.faxId, phd.address, phd.otherDtls, "
                     + "phd.facebookLink, phd.twitterLink, "
                     + "phd.linkedinLink, phd.universityId, pcd.companyTitle)"
                     + "from PcHrDtls phd, PcCompanyDtls pcd where phd.companyId = pcd.companyId "
                     + "and phd.createdUserId=" + lLngLoggedInUserId;
           
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstPcHrDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstPcHrDtls;
    }

    @Override
    public int deleteHrDtls(List<Long> lLstHrDtlId) throws Exception {
         int result;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = "Delete from PcHrDtls where hrDtlId in (:hrDtlIdList)";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameterList("hrDtlIdList", lLstHrDtlId);
            result = query.executeUpdate();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
}
