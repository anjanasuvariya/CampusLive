/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.model;

/**
 *
 * @author SACHIN PATEL
 */
public class ComboValueVO {
    
    private Long id;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public ComboValueVO(){}

    public ComboValueVO(Long id, String value) {
        this.id = id;
        this.value = value;
    }
    
    
}
