/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.form;

import assignment.model.AssgGroupMst;
import assignment.model.AssgGroupUser;
import GD.model.ChatUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author admin
 */
public class AssignmentForm extends org.apache.struts.action.ActionForm {
    
    private List<AssgGroupMst> groupList;
    private List<AssgGroupMst> groupOtherList;
    private int groupId;
    private String groupName;
    private String groupDesc;
    private List<ChatUser> userList;
    private List<ChatUser> removeUserList;

    public List<AssgGroupMst> getGroupOtherList() {
        return groupOtherList;
    }

    public void setGroupOtherList(List<AssgGroupMst> groupOtherList) {
        this.groupOtherList = groupOtherList;
    }

    
    
    
    public List<ChatUser> getRemoveUserList() {
        return removeUserList;
    }

    public void setRemoveUserList(List<ChatUser> removeUserList) {
        this.removeUserList = removeUserList;
    }
    
    
    public List<ChatUser> getUserList() {
        return userList;
    }

    public void setUserList(List<ChatUser> userList) {
        this.userList = userList;
    }

    
    
    
    public List<AssgGroupMst> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<AssgGroupMst> groupList) {
        this.groupList = groupList;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     * @return
     */
        /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        String key=request.getParameter("callmethod");
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        
        return null;
    }
}
