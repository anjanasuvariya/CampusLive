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
import user.model.UserOrganizationDtls;

/**
 *
 * @author SACHIN PATEL
 */
public class UserOrganizationDtlDAOImpl implements UserOrganizationDtlDAO {

    @Override
    public void saveUserOrganizationDtls(UserOrganizationDtls userOrganizationDtl) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            System.out.println("userOrganizationDtl.getOrgDtlId....." + userOrganizationDtl.getOrgDtlId());
            if (userOrganizationDtl.getOrgDtlId() != null) {
                session.update(userOrganizationDtl);
            } else {
                session.save(userOrganizationDtl);
            }
            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<UserOrganizationDtls> getUserOrganizationDtls(Long lLngUserId) throws Exception {
        List<UserOrganizationDtls> lLstUserOrganizationDtls = new ArrayList<UserOrganizationDtls>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String lStrHqlQuery = " from UserOrganizationDtls u where u.createdUserId=" + lLngUserId;
            System.out.println("Query======" + lStrHqlQuery);
            Query query = session.createQuery(lStrHqlQuery);

            lLstUserOrganizationDtls = query.list();
            tx.commit();
            session.close();

        } catch (Exception e) {
            throw e;
        }
        return lLstUserOrganizationDtls;
    }

    @Override
    public void deleteUserOrganizationDtls(List<UserOrganizationDtls> lLstUserOrganizationDtls) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            for (UserOrganizationDtls lObjUserOrganizationDtl : lLstUserOrganizationDtls) {
                session.delete(lObjUserOrganizationDtl);
            }

            tx.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
