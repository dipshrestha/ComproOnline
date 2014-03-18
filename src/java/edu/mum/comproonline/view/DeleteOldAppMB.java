package edu.mum.comproonline.view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.mum.comproonline.model.UserDAO;
import edu.mum.comproonline.model.UserTbl;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class DeleteOldAppMB {

    private String lastname, firstname, email;
    @EJB
    private UserDAO  userdao;
    private UserTbl dataItem;
    private HtmlDataTable dataTable;

    @ManagedProperty("#{param.deleteId}")
    private Integer deleteId;

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }
    
    public UserTbl getDataItem() {
        return dataItem;
    }

    public void setDataItem(UserTbl dataItem) {
        this.dataItem = dataItem;
    }
    

    

   
    

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserTbl> getExpiredAcc()
    {
        return userdao.getExpiredUserTbl();
        //return null;
    
    }
    
    public void delAcc()
    {
        
             
    }
    
    
    
    
    public void editDataItem(String userEmail) {
        System.out.println("testID:-"+userEmail);
        //System.out.println("testtt"+this.deleteId);
        dataItem=userdao.getUserTblStatus(userEmail);
        dataItem.setUserStatus(0);
        userdao.edit(dataItem);
    }
    
    

}
