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
import placeComm.model.PcCompanyDtls;


/**
 *
 * @author SACHIN PATEL
 */
public class CompanyDtlDAOImpl implements CompanyDtlDAO{

    @Override
    public void saveCompanyDtls(PcCompanyDtls pcCompanyDtls) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("pcCompanyDtls.getCompanyId()....." + pcCompanyDtls.getCompanyId());
            if (pcCompanyDtls.getCompanyId() != null) {
                session.update(pcCompanyDtls);
            } else {
                session.save(pcCompanyDtls);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public PcCompanyDtls getCompanyDtlFromId(Long companyId) throws Exception {
       List<PcCompanyDtls> lLstPcCompanyDtls = new ArrayList<PcCompanyDtls>();
       PcCompanyDtls lObjPcCompanyDtl = new PcCompanyDtls();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = " from PcCompanyDtls where companyId=" + companyId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstPcCompanyDtls = query.list();
            if(lLstPcCompanyDtls != null && !lLstPcCompanyDtls.isEmpty())
            {
                lObjPcCompanyDtl = lLstPcCompanyDtls.get(0);
            }
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lObjPcCompanyDtl;
    }

    @Override
    public List<PcCompanyDtls> getCompanyList(Long lLngLoggedInUserId) throws Exception {
        List<PcCompanyDtls> lLstPcCompanyDtls = new ArrayList<PcCompanyDtls>();
       
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = " from PcCompanyDtls where createdUserId=" + lLngLoggedInUserId;
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            
            lLstPcCompanyDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstPcCompanyDtls;
    }

    @Override
    public int deleteCompanyDtls(List<Long> lLstCompanyId) throws Exception {
       int result;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            String lStrQuery = "Delete from PcCompanyDtls where companyId in (:companyIdList)";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setParameterList("companyIdList", lLstCompanyId);
            result = query.executeUpdate();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }
    
}
