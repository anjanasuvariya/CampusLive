/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GD.form;

import GD.model.ChatMsg;
import GD.model.ChatPad;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author admin
 */
public class GDActionForm extends org.apache.struts.action.ActionForm {
    
    private ChatPad chatPad;
    private List<ChatPad> chatRoomList;
    private List<ChatMsg> chatMsgList;
    
    
    
    public List<ChatPad> getChatRoomList() {
        return chatRoomList;
    }

    public List<ChatMsg> getChatMsgList() {
        return chatMsgList;
    }

    public ChatPad getChatPad() {
        return chatPad;
    }

    public void setChatPad(ChatPad chatPad) {
        this.chatPad = chatPad;
    }

    public void setChatMsgList(List<ChatMsg> chatMsgList) {
        this.chatMsgList = chatMsgList;
    }

    public void setChatRoomList(List<ChatPad> chatRoomList) {
        this.chatRoomList = chatRoomList;
    }
    
    

    /**
     *
     */
    public GDActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
    /*    if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
    */  
       errors.clear();
        return errors;
    }
}
