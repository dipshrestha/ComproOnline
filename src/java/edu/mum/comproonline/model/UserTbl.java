/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nazanin
 */
@Entity
@Table(name = "user_tbl")
@NamedQueries({
    @NamedQuery(name = "UserTbl.findAll", query = "SELECT u FROM UserTbl u"),
    @NamedQuery(name = "UserTbl.findByUserID", query = "SELECT u FROM UserTbl u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserTbl.findByUserEmail", query = "SELECT u FROM UserTbl u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "UserTbl.findByUserFirstName", query = "SELECT u FROM UserTbl u WHERE u.userFirstName = :userFirstName"),
    @NamedQuery(name = "UserTbl.findByUserMiddleName", query = "SELECT u FROM UserTbl u WHERE u.userMiddleName = :userMiddleName"),
    @NamedQuery(name = "UserTbl.findByUserLastName", query = "SELECT u FROM UserTbl u WHERE u.userLastName = :userLastName"),
    @NamedQuery(name = "UserTbl.findByUserPassword", query = "SELECT u FROM UserTbl u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "UserTbl.findByUserLastLoginDate", query = "SELECT u FROM UserTbl u WHERE u.userLastLoginDate = :userLastLoginDate"),
    @NamedQuery(name = "UserTbl.findByUserCreationDate", query = "SELECT u FROM UserTbl u WHERE u.userCreationDate = :userCreationDate"),
    @NamedQuery(name = "UserTbl.findByUserRole", query = "SELECT u FROM UserTbl u WHERE u.userRole = :userRole"),
    @NamedQuery(name = "UserTbl.findByUserStatus", query = "SELECT u FROM UserTbl u WHERE u.userStatus = :userStatus")})
public class UserTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "userEmail")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userFirstName")
    private String userFirstName;
    @Size(max = 50)
    @Column(name = "userMiddleName")
    private String userMiddleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userLastName")
    private String userLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "userLastLoginDate")
    @Temporal(TemporalType.DATE)
    private Date userLastLoginDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userCreationDate")
    @Temporal(TemporalType.DATE)
    private Date userCreationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userRole")
    private int userRole;
    @Column(name = "userStatus")
    private Integer userStatus;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUserID")
//    private Collection<ApplicationTbl> applicationTblCollection;

    public UserTbl() {
    }

    public UserTbl(Integer userID) {
        this.userID = userID;
    }

    public UserTbl(Integer userID, String userEmail, String userFirstName, String userLastName, String userPassword, Date userCreationDate, int userRole) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userCreationDate = userCreationDate;
        this.userRole = userRole;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserLastLoginDate() {
        return userLastLoginDate;
    }

    public void setUserLastLoginDate(Date userLastLoginDate) {
        this.userLastLoginDate = userLastLoginDate;
    }

    public Date getUserCreationDate() {
        return userCreationDate;
    }

    public void setUserCreationDate(Date userCreationDate) {
        this.userCreationDate = userCreationDate;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

//    public Collection<ApplicationTbl> getApplicationTblCollection() {
//        return applicationTblCollection;
//    }
//
//    public void setApplicationTblCollection(Collection<ApplicationTbl> applicationTblCollection) {
//        this.applicationTblCollection = applicationTblCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTbl)) {
            return false;
        }
        UserTbl other = (UserTbl) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.UserTbl[ userID=" + userID + " ]";
    }
    
}
