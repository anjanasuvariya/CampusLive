/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.dao;

import common.helper.HibernateUtil;
import common.model.ComboValueVO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SACHIN PATEL
 */
public class CommonDAOImpl implements CommonDAO {

    @Override
    public List<ComboValueVO> getCompanyList() throws Exception {
        List<ComboValueVO> lLstCompanyDtls = new ArrayList<ComboValueVO>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = "select new common.model.ComboValueVO(companyId,companyTitle) from PcCompanyDtls order by companyTitle";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);

            lLstCompanyDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstCompanyDtls;
    }

    @Override
    public List<ComboValueVO> getPlaceCommMemberList(Long lLngUnivesityId, Long lLngRoleId) throws Exception {
        List<ComboValueVO> lLstPlaceCommMem = new ArrayList<ComboValueVO>();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = " select new common.model.ComboValueVO(cum.userId,cum.userFirstName || ' '|| coalesce(cum.userMiddleName , '')|| ' '|| coalesce(cum.userLastName,'')) "
                    + " from CmnUserMst cum ,CmnUserRoleRlt cur"
                    + " where cum.userId = cur.userId  and cum.universityId = :universityId and cur.roleId = :roleId";

            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);
            query.setLong("roleId", lLngRoleId);
            query.setLong("universityId", lLngUnivesityId);

            lLstPlaceCommMem = query.list();
            tx.commit();
            session.close();


        } catch (Exception e) {
            throw e;
        }
        return lLstPlaceCommMem;
    }

    @Override
    public List<ComboValueVO> getEducationList() throws Exception {
        List<ComboValueVO> lLstEducationDtls = new ArrayList<ComboValueVO>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrQuery = "select new common.model.ComboValueVO(educationId,educationTitle) from CmnEducationMst";
            System.out.println("Query======" + lStrQuery);
            Query query = session.createQuery(lStrQuery);

            lLstEducationDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstEducationDtls;
    }
}
