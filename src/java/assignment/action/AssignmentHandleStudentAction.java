/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.action;

import assignment.form.CreateAssgForm;
import assignment.model.AssgDtl;
import assignment.model.AssgGroupMst;
import assignment.model.AssgGroupUser;
import assignment.model.AssgMst;
import assignment.model.AssgSubmitMst;
import GD.model.ChatMsg;
import GD.model.ChatUser;
import common.helper.HibernateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class AssignmentHandleStudentAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String EDIT = "edit";
    private static final Logger logger = Logger.getLogger(AssignmentHandleStudentAction.class);

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
    public ActionForward loadPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            CreateAssgForm assgForm = (CreateAssgForm) form;
//        
//        System.out.println("Group Size is :"+getGroupListHandler(request).size());
//        if(assgForm != null){
//            System.out.println("Form is Not Null");
//        }
//      assgForm.setGroupList(getGroupListHandler(request));  
//      
//      System.out.println("Group Sixze is :::: "+assgForm.getGroupList().size());

            assgForm.setAssgMstList(loadAssgMst(request));
            assgForm.setAssgMstSubmittedList(loadAssgMstSubmitted(request));
        } catch (Exception e) {
            logger.error("Error in loadPage method : " + e, e);
        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward download(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CreateAssgForm assgForm = (CreateAssgForm) form;
//        
        System.out.println("INSIDE download Method of Manage Assignment Action...");

        String url = request.getParameter("assgFileUrl");
        System.out.println("URL is:+" + url);

        String fileName = url.substring(url.lastIndexOf('\\') + 1, url.length());
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        try {
            //Get it from file system
            FileInputStream in = new FileInputStream(new File(url));

            //Get it from web path
            //jndi:/localhost/StrutsExample/upload/superfish.zip
            //URL url = getServlet().getServletContext()
            //               .getResource("upload/superfish.zip");
            //InputStream in = url.openStream();

            //Get it from bytes array
            //byte[] bytes = new byte[4096];
            //InputStream in = new ByteArrayInputStream(bytes);

            ServletOutputStream out = response.getOutputStream();

            byte[] outputByte = new byte[4096];
            //copy binary content to output stream
            while (in.read(outputByte, 0, 4096) != -1) {
                out.write(outputByte, 0, 4096);
            }
            in.close();
            out.flush();
            out.close();

            assgForm.setAssgMstList(loadAssgMst(request));
        } catch (Exception e) {
            logger.error("Error in download method : " + e, e);
        }
        return mapping.findForward(SUCCESS);
    }

    private List<AssgGroupMst> getGroupListHandler(HttpServletRequest request) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;
        // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try {
            tx = session.beginTransaction();
            Query q_groupList = session.createQuery("from AssgGroupMst C");
            List<AssgGroupMst> groupList = new ArrayList<AssgGroupMst>();
            groupList = (ArrayList<AssgGroupMst>) q_groupList.list();
            // request.setAttribute("chatRoomList", chatRoomList);         ------------------++++
            System.out.println("Group List Size is:: " + groupList.size());
            tx.commit();
            session.close();
            return groupList;
        } catch (Exception ex) {
            logger.error("Error in getGroupListHandler method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();

        }
        return null;

    }

    private String uploadFile(HttpServletRequest request, FormFile file) throws FileNotFoundException, IOException {

        try {
            request.getSession().setAttribute("userId", 1);
            String filePath = getServlet().getServletContext().getRealPath("/") + "resources\\files\\users\\" + request.getSession().getAttribute("userId") + "\\assignments";

            File folder = new File(filePath);
            if (!folder.exists()) {
                System.out.println("Creating:" + filePath);
                folder.mkdir();
            }
            String fileName = file.getFileName();
            if (!("").equals(fileName)) {

                System.out.println("Server path:" + filePath);
                File newFile = new File(filePath, fileName);

                if (!newFile.exists()) {
                    FileOutputStream fos = new FileOutputStream(newFile);
                    System.out.println("Now writing");
                    fos.write(file.getFileData());
                    fos.flush();
                    fos.close();
                    return newFile.getAbsolutePath();
                }
            }
        } catch (Exception e) {
            logger.error("Error in uploadFile method : " + e, e);
        }
        return "";
    }

    private List<AssgMst> loadAssgMst(HttpServletRequest request) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            int userId = 1;
            StringBuilder query = new StringBuilder();
            query.append(" select * from assg_mst am ");
            query.append(" where am.assg_id not in  ");
            query.append(" ( select asm.assg_id from assg_submit_mst asm ");
            query.append(" where asm.assg_user_id= " + userId + " ) ");

            System.out.println(query.toString());
            SQLQuery q_assgMstList = session.createSQLQuery(query.toString());
            q_assgMstList.addEntity(AssgMst.class);

            List<AssgMst> assgMstList = new ArrayList<AssgMst>();
            assgMstList = (ArrayList<AssgMst>) q_assgMstList.list();



            tx.commit();
            session.close();
            return assgMstList;
        } catch (Exception ex) {
            logger.error("Error in loadAssgMst method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
            return null;
        }
    }

    private List<AssgMst> loadAssgMstSubmitted(HttpServletRequest request) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            int userId = 1;
            StringBuilder query = new StringBuilder();
            query.append(" select * from assg_mst am ");
            query.append(" where am.assg_id in  ");
            query.append(" ( select asm.assg_id from assg_submit_mst asm ");
            query.append(" where asm.assg_user_id= " + userId + " ) ");

            logger.info(query.toString());
            SQLQuery q_assgMstList = session.createSQLQuery(query.toString());
            q_assgMstList.addEntity(AssgMst.class);

            List<AssgMst> assgMstList = new ArrayList<AssgMst>();
            assgMstList = (ArrayList<AssgMst>) q_assgMstList.list();

            tx.commit();
            session.close();
            return assgMstList;
        } catch (Exception ex) {
            logger.error("Error in loadAssgMstSubmitted method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    //-------------------------------POST ASSIGNMENT ACTION CODE------------------------------//
    ////////////////////////////////////////////////////////////////////////////////////////////

    public ActionForward ViewAssignment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            CreateAssgForm createAssgForm = (CreateAssgForm) form;
            //createAssgForm.setRejectUserList(getInsideUserList(request));
            //createAssgForm.setUserList(getOutsideUserList(request));

            //createAssgForm.setRejectGroupList(getInsideGroupList(request));
            //createAssgForm.setGroupList(getOutsideGroupList(request));
            createAssgForm.setAssgId(Integer.parseInt(request.getParameter("assgId")));
            createAssgForm.setAssgTitle(request.getParameter("assgTitle"));
            createAssgForm.setAssgDetails(request.getParameter("assgDetails"));
            createAssgForm.setAssgSubject(request.getParameter("assgSubject"));
            createAssgForm.setAssgSubmissionDetails(request.getParameter("assgSubmissionDetails"));
            createAssgForm.setAssgSubmitType(Integer.parseInt(request.getParameter("assgSubmitType")));

        } catch (Exception ex) {
            logger.error("Error in ViewAssignment method : " + ex, ex);

        }

        return mapping.findForward(EDIT);

    }

    public ActionForward SubmitAssignment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            CreateAssgForm createAssgForm = (CreateAssgForm) form;
            logger.info("INSIDE submitting Assignments");
            String submissionType = request.getParameter("assgSubmitType");
            logger.info("The Submission type is :" + submissionType);

            if (submissionType.equals("0")) {
                logger.info("Calling Text Editor Method");
                insertAssignmentWithTextEditor(mapping, form, request, response);
            } else if (submissionType.equals("1")) {
                logger.info("Calling File Upload Method");
                insertAssignmentWithFile(mapping, form, request, response);
            } else {
                logger.info("Submission Type is Different or not available...Please Debug");
                return mapping.findForward(EDIT);
            }
        } catch (Exception ex) {
            logger.error("Error in SubmitAssignment method : " + ex, ex);

        }
        return mapping.findForward(EDIT);




    }

    public ActionForward insertAssignmentWithFile(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Transaction tx = null;
        Session session = null;
        try {
            CreateAssgForm createAssgForm = (CreateAssgForm) form;
            logger.info("inside insertAssignmentWithFile...");
            FormFile file = createAssgForm.getFile();
            logger.info("File name is:" + file.getFileName());

            String assgId = request.getParameter("assgId");
            String assgSubmitType = request.getParameter("assgSubmitType");
            String fileURL = null;
            request.getSession().setAttribute("userId", 1);
            int userId = 1;
            logger.info("File Details:" + file.getFileName() + "Size:" + file.getFileSize());

            if (file != null) {
                fileURL = uploadFile(request, file);
            }

            //******************************Now INSERTING RECORD(FILE UPLOAD SUCCESSFUL)***************
            if (fileURL != "") {
                // Insert Record...
                logger.info("Now INSERTing the RECORD...");
                AssgSubmitMst assgSubmitMst = new AssgSubmitMst();
                assgSubmitMst.setAssgId(Integer.valueOf(assgId));
                assgSubmitMst.setAssgSubmitType(Integer.valueOf(assgSubmitType));
                assgSubmitMst.setAssgFileUrl(fileURL);
                assgSubmitMst.setAssgUserId(userId);
                assgSubmitMst.setAssgResponseText("");

                SessionFactory factory = HibernateUtil.getSessionFactory();
                session = factory.openSession();

                tx = session.beginTransaction();
                session.save(assgSubmitMst);
                tx.commit();
                session.close();


            }
        } catch (Exception ex) {
            logger.error("Error in insertAssignmentWithFile method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        //******************************INSERTING RECORD SUCCESSFUL********************************
        //  createAssgForm.setAssgMstList(loadAssgMst(request));

        return mapping.findForward(SUCCESS);

    }

    public ActionForward insertAssignmentWithTextEditor(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Transaction tx = null;
        Session session = null;
        try {
            CreateAssgForm createAssgForm = (CreateAssgForm) form;

            String assgId = request.getParameter("assgId");
            String assgSubmitType = request.getParameter("assgSubmitType");

            request.getSession().setAttribute("userId", 1);
            int userId = 1;

            //******************************Now INSERTING RECORD(FILE UPLOAD SUCCESSFUL)***************

            // Insert Record...
            logger.info("Now INSERTing the RECORD...");
            AssgSubmitMst assgSubmitMst = new AssgSubmitMst();
            assgSubmitMst.setAssgId(Integer.valueOf(assgId));
            assgSubmitMst.setAssgSubmitType(Integer.valueOf(assgSubmitType));
            assgSubmitMst.setAssgFileUrl("");
            assgSubmitMst.setAssgUserId(userId);
            assgSubmitMst.setAssgResponseText(request.getParameter("textarea"));

            SessionFactory factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();


            tx = session.beginTransaction();
            session.save(assgSubmitMst);
            tx.commit();
            session.close();

            //******************************INSERTING RECORD SUCCESSFUL********************************
            createAssgForm.setAssgMstList(loadAssgMst(request));
        } catch (Exception ex) {
            logger.error("Error in insertAssignmentWithTextEditor method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        return mapping.findForward(SUCCESS);

    }

    //GETS ALL USERS THAT ARE ALREADY PART OF THIS ASSIGNMENT CALLED INSIDERS
    private List<ChatUser> getInsideUserList(HttpServletRequest request) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;
        // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try {
            tx = session.beginTransaction();
            StringBuilder query = new StringBuilder();
            query.append(" select AD.assg_dtl_id chat_user_id,CU.chat_user_name,CU.chat_user_desc,CU.chat_user_image,CU.chat_user_votes ");
            query.append(" from assg_dtl AD, chat_user CU ");
            query.append(" where AD.assg_group_flag=0 and AD.assg_mst_id=" + request.getParameter("assgId") + " and AD.assg_user_id=CU.chat_user_id ");
            query.append(" and CU.chat_user_id IN (SELECT distinct ADL.assg_user_id FROM assg_dtl ADL where ADL.assg_mst_id=" + request.getParameter("assgId")
                    + " and ADL.assg_group_flag=0)");
            // Group Flag 0 Means We are Dealing with Users
            // AssgId is passed as a Paramaeter while calling...


            System.out.println(query.toString());
            SQLQuery q_userList = session.createSQLQuery(query.toString());
            q_userList.addEntity(ChatUser.class);

            List<ChatUser> userList = new ArrayList<ChatUser>();
            userList = (ArrayList<ChatUser>) q_userList.list();

            System.out.println("UserList Size is : " + userList.size());
            tx.commit();
            session.close();
            return userList;
        } catch (Exception ex) {
            logger.error("Error in getInsideUserList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        return null;

    }

    //GETS ALL USERS THAT ARE NOT PART OF THIS ASSIGNMENT CALLED OUTSIDE
    private List<ChatUser> getOutsideUserList(HttpServletRequest request) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;
        // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try {
            tx = session.beginTransaction();
            StringBuilder query = new StringBuilder();
            query.append(" select CU.chat_user_id,CU.chat_user_name,CU.chat_user_desc,CU.chat_user_image,CU.chat_user_votes ");
            query.append(" from chat_user CU ");
            query.append(" where CU.chat_user_id NOT IN (SELECT distinct ADL.assg_user_id FROM assg_dtl ADL where ADL.assg_mst_id=" + request.getParameter("assgId")
                    + " and ADL.assg_group_flag=0)");
            // Group Flag 0 Means We are Dealing with Users
            // AssgId is passed as a Paramaeter while calling...


            System.out.println(query.toString());
            SQLQuery q_userList = session.createSQLQuery(query.toString());
            q_userList.addEntity(ChatUser.class);

            List<ChatUser> userList = new ArrayList<ChatUser>();
            userList = (ArrayList<ChatUser>) q_userList.list();

            logger.info("UserList Size is : " + userList.size());
            tx.commit();
            session.close();
            return userList;
        } catch (Exception ex) {
            logger.error("Error in getOutsideUserList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        return null;

    }
    // USER EDITING OPERATIONS ARE HANDLED BY BELOW METHOD

    public ActionForward editUserList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        try {
            logger.info("INSIDE Edit USERLIST method Of Manage Assignment Action...");

            CreateAssgForm assignmentForm = (CreateAssgForm) form;

            String[] selectedUserIds = request.getParameterValues("selectedUsers");
            String[] deselectedUserIds = request.getParameterValues("deselectedUsers");
            int assgId = Integer.valueOf(request.getParameter("assgId"));
            System.out.println("Assg ID retrieved is : " + assgId);

            if (selectedUserIds != null) {
                updateUserList(assgId, selectedUserIds);
            }
            if (deselectedUserIds != null) {
                updateDeUserList(assgId, deselectedUserIds);
            }

            assignmentForm.setRejectUserList(getInsideUserList(request));
            assignmentForm.setUserList(getOutsideUserList(request));
            assignmentForm.setGroupList(getOutsideGroupList(request));
            assignmentForm.setRejectGroupList(getInsideGroupList(request));
        } catch (Exception e) {
            logger.error("Error in editUserList method : " + e, e);
        }
        return mapping.findForward(EDIT);

    }

    // ADDS USER
    void updateUserList(int assgId, String[] selectedUserIds) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;
        // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try {
            tx = session.beginTransaction();
            //session.save(pad);
            //session.save(user);
            for (String s : selectedUserIds) {
                session.saveOrUpdate(new AssgDtl(assgId, 0, Integer.valueOf(s)));
            }
            tx.commit();
            session.close();

        } catch (Exception ex) {
            logger.error("Error in updateUserList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();

        }

    }

    // REMOVES ALREADY EXISTING USER
    void updateDeUserList(int assgId, String[] deselectedUserIds) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        System.out.println("Inside update DeUSER List method...");
        Transaction tx = null;
        // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try {
            tx = session.beginTransaction();
            //session.save(pad);
            //session.save(user);
            for (String s : deselectedUserIds) {
                AssgDtl a = new AssgDtl();
                a.setAssgDtlId(Integer.valueOf(s));
                session.delete(a);
            }


            tx.commit();
            session.close();

        } catch (Exception ex) {
            logger.error("Error in updateDeUserList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();

        }


        //=========================================POST ASSIGNMENT ACTION CODE--------------------//



    }

///////////////// HERE ONWARDS GROUP EDITING CODE IS DEVELOPED AT 1 AM////////////////////
//////////////////////////////////////////////////////////////////////////////////////////     
//GETS ALL USERS THAT ARE ALREADY PART OF THIS ASSIGNMENT CALLED INSIDERS
    private List<AssgGroupMst> getInsideGroupList(HttpServletRequest request) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;
        // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try {
            tx = session.beginTransaction();
            StringBuilder query = new StringBuilder();
            query.append(" SELECT AD.assg_dtl_id assg_group_id ,AGM.assg_group_dtl_id,AGM.assg_group_name,AGM.assg_group_desc,AGM.assg_group_owner_id ");
            query.append(" FROM assg_dtl AD, assg_group_mst AGM ");
            query.append(" WHERE AD.assg_group_flag=1 AND AD.assg_mst_id= " + request.getParameter("assgId") + " AND AD.assg_user_id=AGM.assg_group_id AND AGM.assg_group_id IN ( ");
            query.append(" SELECT distinct ADL.assg_user_id FROM assg_dtl ADL where ADL.assg_mst_id=" + request.getParameter("assgId"));
            query.append(" AND ADL.assg_group_flag = 1) ");
            // Group Flag 1 Means We are Dealing with Grouops
            // AssgId is passed as a Paramaeter while calling...


            System.out.println(query.toString());
            SQLQuery q_userList = session.createSQLQuery(query.toString());
            q_userList.addEntity(AssgGroupMst.class);

            List<AssgGroupMst> groupList = new ArrayList<AssgGroupMst>();
            groupList = (ArrayList<AssgGroupMst>) q_userList.list();

            System.out.println("InsideGroupList Size is : " + groupList.size());
            tx.commit();
            session.close();
            return groupList;
        } catch (Exception ex) {
            logger.error("Error in getInsideGroupList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        return null;

    }

    //GETS ALL USERS THAT ARE NOT PART OF THIS ASSIGNMENT CALLED OUTSIDE
    private List<AssgGroupMst> getOutsideGroupList(HttpServletRequest request) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        request.getSession().setAttribute("userId", 1);

        Transaction tx = null;
        // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try {
            tx = session.beginTransaction();
            StringBuilder query = new StringBuilder();
            query.append(" SELECT * FROM assg_group_mst AGM ");
            query.append(" WHERE AGM.assg_group_owner_id=" + request.getSession().getAttribute("userId") + " AND AGM.assg_group_id NOT IN ( ");
            query.append(" SELECT DISTINCT AD.assg_user_id FROM assg_dtl AD ");
            query.append(" WHERE AD.assg_group_flag=1");
            query.append(" AND AD.assg_mst_id=" + request.getParameter("assgId") + ") ");


            // Group Flag 1 Means We are Dealing with Groups
            // AssgId is passed as a Paramaeter while calling...


            System.out.println(query.toString());
            SQLQuery q_userList = session.createSQLQuery(query.toString());
            q_userList.addEntity(AssgGroupMst.class);

            List<AssgGroupMst> groupList = new ArrayList<AssgGroupMst>();
            groupList = (ArrayList<AssgGroupMst>) q_userList.list();

            System.out.println("Outside GroupList Size is : " + groupList.size());
            tx.commit();
            session.close();
            return groupList;
        } catch (Exception ex) {
            logger.error("Error in getOutsideGroupList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();
        }
        return null;

    }
    // USER EDITING OPERATIONS ARE HANDLED BY BELOW METHOD

    public ActionForward editGroupList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {

            logger.info("INSIDE Edit groupLIST method Of Manage Assignment Action...");

            CreateAssgForm assignmentForm = (CreateAssgForm) form;

            String[] selectedGroupIds = request.getParameterValues("selectedGroups");
            String[] deselectedGroupIds = request.getParameterValues("deSelectedGroups");
            int assgId = Integer.valueOf(request.getParameter("assgId"));
            logger.info("Assg ID retrieved is : " + assgId);

            if (selectedGroupIds != null) {
                updateGroupList(assgId, selectedGroupIds);
            }
            if (deselectedGroupIds != null) {
                updateDeGroupList(assgId, deselectedGroupIds);
            }

            assignmentForm.setRejectUserList(getInsideUserList(request));
            assignmentForm.setUserList(getOutsideUserList(request));
            assignmentForm.setGroupList(getOutsideGroupList(request));
            assignmentForm.setRejectGroupList(getInsideGroupList(request));
        } catch (Exception e) {
            logger.error("Error in editGroupList method : " + e, e);
        }
        return mapping.findForward(EDIT);

    }

    // ADDS GROUP
    void updateGroupList(int assgId, String[] selectedGroupIds) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            for (String s : selectedGroupIds) {
                session.saveOrUpdate(new AssgDtl(assgId, 1, Integer.valueOf(s)));
                System.out.println("Saving/Updating ID from AssgDtl with group flag 1 : " + s);
            }
            tx.commit();
            session.close();

        } catch (Exception ex) {
            logger.error("Error in updateGroupList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();

        }

    }

    // REMOVES ALREADY EXISTING GROUP
    void updateDeGroupList(int assgId, String[] deselectedGroupIds) {


        Transaction tx = null;
        Session session = null;
        // Insert message with Pad ID 1 and GROUP Id Generated by JavaScript ex.1
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            logger.info("Inside update DeGROUP List method...");
            tx = session.beginTransaction();
            for (String s : deselectedGroupIds) {
                AssgDtl a = new AssgDtl();
                a.setAssgDtlId(Integer.valueOf(s));
                logger.info("Deleteing id from AssgDtl: " + s);
                session.delete(a);
            }


            tx.commit();
            session.close();

        } catch (Exception ex) {
            logger.error("Error in updateDeGroupList method : " + ex, ex);
            tx.rollback();
            session.close();
            ex.printStackTrace();

        }


        //=========================================POST ASSIGNMENT GROUP ACTION CODE--------------------//

    }
///////////////// HERE ONWARDS GROUP EDITING CODE IS DEVELOPED AT 1 AM////////////////////
}