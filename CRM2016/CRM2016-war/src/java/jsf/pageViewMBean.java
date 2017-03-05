/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Foxlight
 */
@Named(value = "pageViewMBean")
@ViewScoped
public class pageViewMBean implements Serializable {

    public pageViewMBean() {
    }
    private String page = "index";
    public void setActivePage(String page){
        System.out.println(page);
        this.page = page;
        //return "?faces-redirect=true";
    }
    public String activePage(){
        return this.page;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
