/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GD.action;

import GD.model.ChatMsg;
import GD.model.ChatUserVote;
import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class GDVoteAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final Logger logger = Logger.getLogger(GDVoteAction.class);

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            logger.info("Inside Voting Action");
            logger.info("UserID is::" + request.getParameter("chatUserId"));
            logger.info("PadId is::" + request.getParameter("chatPadId"));
            int chatMsgId = Integer.valueOf(request.getParameter("chatMsgId"));
            int chatMsgVotes = Integer.valueOf(request.getParameter("chatPositionId"));


            updateMessage(chatMsgId, chatMsgVotes + 1);
        } catch (Exception e) {
            logger.error("Error in execute method : " + e, e);
        }
        return null;
    }

    private void updateMessage(int chatMsgId, int chatMsgVotes) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query q_chatVoteQuery = session.createQuery("from ChatMsg C where C.chatMsgId = " + chatMsgId);
            List<ChatMsg> chatMsgList = new ArrayList<ChatMsg>();
            chatMsgList = (ArrayList<ChatMsg>) q_chatVoteQuery.list();
            logger.info("List Size is:" + chatMsgList.size());
            logger.info("List Size is:" + chatMsgList.get(0).getChatMsgValue());
            logger.info("List Size is:" + chatMsgList.get(0).getChatMsgId());
            logger.info("Votes to be Inserted :" + chatMsgVotes);
            chatMsgList.get(0).setChatPositionId(chatMsgVotes);
            session.update(chatMsgList.get(0));
            int chatUserId = 1;
            ChatUserVote cuv = new ChatUserVote(chatUserId, chatMsgId, 1);
            session.save(cuv);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            logger.error("Error in updateMessage method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }

    }
}
