/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GD.action;

import assignment.form.AssignmentForm;
import GD.form.GDActionForm;
import assignment.model.AssgGroupMst;
import assignment.model.AssgGroupUser;
import GD.model.ChatMsg;
import GD.model.ChatPad;
import GD.model.ChatUser;
import common.helper.HibernateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class ManageGroupStudentAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String EDIT = "edit";
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
    
    public ActionForward insertGroup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        request.getSession().setAttribute("userName", "Jyot");
        request.getSession().setAttribute("userId", new Integer(1));
        System.out.println("INSIDE execute method Of Manage Group Action...");
        System.out.println(request.getParameter("groupName"));
        System.out.println(request.getParameter("groupDesc"));
        System.out.println(request.getSession().getAttribute("userName"));
        System.out.println(request.getSession().getAttribute("userId"));
        AssignmentForm assignmentForm = (AssignmentForm) form;
    
        String groupName=request.getParameter("groupName");
        String groupDesc=request.getParameter("groupDesc");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        int success_id=insertGroupHandler(new AssgGroupMst(userId, groupName, groupDesc, userId,0));
        System.out.println("ID generated is...+++"+success_id);
        assignmentForm.setGroupList(getGroupListHandler(request)); // get groups again....
        assignmentForm.setGroupOtherList(getOtherGroupListHandler(request));
        return mapping.findForward(SUCCESS);
        
        
    }
    
    
     private int insertGroupHandler(AssgGroupMst agm) {
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        
        Transaction tx=null;
    
        try{
        tx=session.beginTransaction();
        //session.save(pad);
        //session.save(user);
        session.save(agm);
        System.out.println("PAD ID is +++ "+agm.getAssgGroupId());
        tx.commit();
        session.close();
        return agm.getAssgGroupId();
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        return -1;
        }
    }
    
    
    
    public ActionForward getGroupList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      System.out.println("Inside GetGroupList Method of ManageGroupStudentAction");
     // Getting Groups from Database...   
      AssignmentForm assgForm = (AssignmentForm) form;
        
      assgForm.setGroupList(getGroupListHandler(request));  
      assgForm.setGroupOtherList(getOtherGroupListHandler(request));
      //System.out.println("Group Sixze is :::: "+assgForm.getGroupList().size());
      return mapping.findForward(SUCCESS);
        
        
    }
    
    
    public ActionForward deleteGroup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      System.out.println("Inside Delete Group Method of ManageGroupStudentAction");
     
      AssignmentForm assgForm = (AssignmentForm) form;
      deleteGroupsById(Integer.valueOf(request.getParameter("groupId")));  
      assgForm.setGroupList(getGroupListHandler(request));  
      assgForm.setGroupOtherList(getOtherGroupListHandler(request));
      System.out.println("Group Sixze is :::: "+assgForm.getGroupList().size());
      
      return mapping.findForward(SUCCESS);
    }
    
    public boolean deleteGroupsById (int groupId) {
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        
        Transaction tx=null;
    
        try{
        tx=session.beginTransaction();
        //session.save(pad);
        //session.save(user);
         
        AssgGroupMst agm = (AssgGroupMst) session.load(AssgGroupMst.class,groupId);
        agm.setAssgGroupIdHide(1);
        session.save(agm);
        System.out.println("HIDE FLAG is +++ "+agm.getAssgGroupIdHide());
        tx.commit();
        session.close();
        return true;
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        return false;
        }
        
    } 
    
    
    
        private List<AssgGroupMst> getGroupListHandler(HttpServletRequest request) {
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        
        Transaction tx=null;
    // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try{
        tx=session.beginTransaction();
        request.getSession().setAttribute("userId", "1");
        String userId = (String)request.getSession().getAttribute("userId");
        Query q_groupList=session.createQuery("from AssgGroupMst C where C.assgGroupIdHide = 0 and C.assgGroupOwnerId = "+userId);
        List<AssgGroupMst> groupList =new ArrayList<AssgGroupMst>(); 
        groupList=(ArrayList<AssgGroupMst>) q_groupList.list();
       
        tx.commit();
        session.close();
        return groupList;
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        
        }
        return null;
        
    }
        
    private List<AssgGroupMst> getOtherGroupListHandler(HttpServletRequest request) {
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        
        Transaction tx=null;
    // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try{
        tx=session.beginTransaction();
        StringBuilder query = new StringBuilder();
        int userId=1; // HardCode for Now...
        query.append(" select * from assg_group_mst ");
        query.append(" where assg_group_id in ( ");
        query.append(" select distinct assg_group_id from assg_group_user U where assg_user_id= "+ userId );
        query.append("  ) and assg_group_owner_id != "+ userId);
        SQLQuery q_otherGroupList=session.createSQLQuery(query.toString());
        System.out.println("Query for getting groups OTHERs is  : "+query.toString()); // Print Query on Console
        List<AssgGroupMst> assgGroupList =new ArrayList<AssgGroupMst>();  // will store the messages
        q_otherGroupList.addEntity(AssgGroupMst.class);
        assgGroupList=(ArrayList<AssgGroupMst>) q_otherGroupList.list();
        tx.commit();
        session.close();
        return assgGroupList;
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        
        }
        return null;
        
    }    
        
        
    // Below method is always used for Editing the Particular Group with input ID and Name available to method as request params.
        
    public ActionForward editGroup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        request.getSession().setAttribute("userName", "Jyot");
        request.getSession().setAttribute("userId", new Integer(1));
        System.out.println("INSIDE Edit GROUP method Of Manage Group Action...");
        System.out.println(request.getParameter("groupId"));
        System.out.println(request.getParameter("groupName"));
        System.out.println("Username :"+request.getSession().getAttribute("userName"));
        System.out.println("UserID   :"+request.getSession().getAttribute("userId"));
        AssignmentForm assignmentForm = (AssignmentForm) form;
        
        String groupName=request.getParameter("groupName");
        String groupId=request.getParameter("groupId");
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        assignmentForm.setGroupId(Integer.valueOf(groupId));
        assignmentForm.setGroupName(groupName);
        
        List <AssgGroupUser> userList = new ArrayList<AssgGroupUser>();
    
        
        assignmentForm.setUserList(getOutsideUserList(request));
        assignmentForm.setRemoveUserList(getInsideUserList(request));
        
        assignmentForm.setGroupName(request.getParameter("groupName"));
        
        return mapping.findForward(EDIT);
        
        
    }        
        
     private List<ChatUser> getOutsideUserList( HttpServletRequest request) {
    
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        
        Transaction tx=null;
    // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try{
        tx=session.beginTransaction();
        StringBuilder query = new StringBuilder();
        query.append("SELECT CU.* FROM  chat_user CU where CU.chat_User_Id not in ");
        query.append(" (SELECT distinct assg_user_id FROM assg_group_user agu  ");
        query.append(" where agu.assg_group_id = "+request.getParameter("groupId") +")");
        System.out.println(query.toString());
        SQLQuery q_userList=session.createSQLQuery(query.toString());
        q_userList.addEntity(ChatUser.class);
        
        List<ChatUser> userList = new ArrayList<ChatUser>();
        userList=(ArrayList<ChatUser>) q_userList.list();
        
        System.out.println("UserList Size is : "+ userList.size());
        tx.commit();
        session.close();
        return userList;
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        
        }
        return null;
        
    }
     
     private List<ChatUser> getInsideUserList( HttpServletRequest request) {
    
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        
        Transaction tx=null;
    // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try{
        tx=session.beginTransaction();
        StringBuilder query = new StringBuilder();
        query.append("SELECT AGU.assg_usergroup_id chat_user_id,CU.chat_user_name,CU.chat_user_desc,CU.chat_user_image,CU.chat_user_votes ");
        query.append("FROM  chat_user CU,assg_group_user AGU ");
        query.append("where AGU.assg_user_id=CU.chat_user_id and AGU.assg_group_id="+request.getParameter("groupId") +" and CU.chat_User_Id in ");
        query.append("(SELECT distinct assg_user_id FROM assg_group_user where assg_group_id="+request.getParameter("groupId")+")");
        System.out.println(query.toString());
        SQLQuery q_userList=session.createSQLQuery(query.toString());
        q_userList.addEntity(ChatUser.class);
        
        List<ChatUser> userList = new ArrayList<ChatUser>();
        userList=(ArrayList<ChatUser>) q_userList.list();
        
        System.out.println("UserList Size is : "+ userList.size());
        tx.commit();
        session.close();
        return userList;
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        
        }
        return null;
        
    }

     
     
     
     public ActionForward editUserList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        System.out.println("INSIDE Edit USERLIST method Of Manage Group Action...");
        
        AssignmentForm assignmentForm = (AssignmentForm) form;
        
//        System.out.println("Class Of Checkboxxxs.."+request.getParameterValues("selectedUsers").getClass().getName());
//        System.out.println(Arrays.toString(request.getParameterValues("selectedUsers")));
        String[] selectedUserIds = request.getParameterValues("selectedUsers");
        String[] deselectedUserIds = request.getParameterValues("deselectedUsers");
        int groupId = Integer.valueOf(request.getParameter("groupId"));
        System.out.println("Group ID retrieved is : "+groupId);
        
        if(selectedUserIds != null){
        updateUserList(groupId,selectedUserIds);
        }
        if(deselectedUserIds != null){
        updateDeUserList(groupId,deselectedUserIds);
        }
     
        assignmentForm.setUserList(getOutsideUserList(request));
        assignmentForm.setRemoveUserList(getInsideUserList(request));

        return mapping.findForward(EDIT);
        
    }    
     
    void updateUserList(int groupId, String[] selectedUserIds) {
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        
        Transaction tx=null;
    // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try{
        tx=session.beginTransaction();
        //session.save(pad);
        //session.save(user);
        for(String s:selectedUserIds)
        {
            session.saveOrUpdate(new AssgGroupUser(groupId, Integer.valueOf(s)));
        }
        tx.commit();
        session.close();
        
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        
        }
        
    }
     
     void updateDeUserList(int groupId, String[] deselectedUserIds) {
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session=factory.openSession();    
        System.out.println("Indise update DeUSER List method...");
        Transaction tx=null;
    // Insert message with Pad ID 1 and User Id Generated by JavaScript ex.1
        try{
        tx=session.beginTransaction();
        //session.save(pad);
        //session.save(user);
        for(String s:deselectedUserIds)
        {
        AssgGroupUser a = new AssgGroupUser();
        a.setAssgUsergroupId(Integer.valueOf(s));
        session.delete(a);
        }
        
        
        tx.commit();
        session.close();
        
        }catch(Exception ex){
        tx.rollback();
        session.close();
        ex.printStackTrace();
        
        }
        
    }
}
