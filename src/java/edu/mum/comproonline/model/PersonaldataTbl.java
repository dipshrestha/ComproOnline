/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nazanin
 */
@Entity
@Table(name = "personaldata_tbl")
@NamedQueries({
    @NamedQuery(name = "PersonaldataTbl.findAll", query = "SELECT p FROM PersonaldataTbl p"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataID", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataID = :pDataID"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataFirstName", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataFirstName = :pDataFirstName"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataLastName", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataLastName = :pDataLastName"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataMiddleName", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataMiddleName = :pDataMiddleName"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataGender", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataGender = :pDataGender"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataCountry", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataCountry = :pDataCountry"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataHomeCountry", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataHomeCountry = :pDataHomeCountry"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataCity", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataCity = :pDataCity"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataState", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataState = :pDataState"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataAddressLine1", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataAddressLine1 = :pDataAddressLine1"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataAddressLine2", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataAddressLine2 = :pDataAddressLine2"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataZipCode", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataZipCode = :pDataZipCode"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataHomePhone", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataHomePhone = :pDataHomePhone"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataMobilePhone", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataMobilePhone = :pDataMobilePhone"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataSkypeID", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataSkypeID = :pDataSkypeID"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataEmail", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataEmail = :pDataEmail"),
    @NamedQuery(name = "PersonaldataTbl.findByPDataVisaStatus", query = "SELECT p FROM PersonaldataTbl p WHERE p.pDataVisaStatus = :pDataVisaStatus")})
public class PersonaldataTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pDataID")
    private Integer pDataID;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataFirstName")
    private String pDataFirstName;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataLastName")
    private String pDataLastName;
    
    @Size(max = 50)
    @Column(name = "pDataMiddleName")
    private String pDataMiddleName;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pDataGender")
    private String pDataGender;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataCountry")
    private String pDataCountry;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataHomeCountry")
    private String pDataHomeCountry;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataCity")
    private String pDataCity;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataState")
    private String pDataState;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pDataAddressLine1")
    private String pDataAddressLine1;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 200)
    @Column(name = "pDataAddressLine2")
    private String pDataAddressLine2;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 20)
    @Column(name = "pDataZipCode")
    private String pDataZipCode;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataHomePhone")
    private String pDataHomePhone;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "pDataMobilePhone")
    private String pDataMobilePhone;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "pDataSkypeID")
    private String pDataSkypeID;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pDataEmail")
    private String pDataEmail;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pDataVisaStatus")
    private String pDataVisaStatus;
    
//    @JoinColumn(name = "PDataAppID", referencedColumnName = "appID")
//    @ManyToOne(optional = false)
//    private ApplicationTbl pDataAppID;

    public PersonaldataTbl() {
    }

    public PersonaldataTbl(Integer pDataID) {
        this.pDataID = pDataID;
    }

    public PersonaldataTbl(Integer pDataID, String pDataFirstName, String pDataLastName, String pDataGender, String pDataCountry, String pDataHomeCountry, String pDataCity, String pDataState, String pDataAddressLine1, String pDataAddressLine2, String pDataZipCode, String pDataHomePhone, String pDataMobilePhone, String pDataSkypeID, String pDataEmail, String pDataVisaStatus) {
        this.pDataID = pDataID;
        this.pDataFirstName = pDataFirstName;
        this.pDataLastName = pDataLastName;
        this.pDataGender = pDataGender;
        this.pDataCountry = pDataCountry;
        this.pDataHomeCountry = pDataHomeCountry;
        this.pDataCity = pDataCity;
        this.pDataState = pDataState;
        this.pDataAddressLine1 = pDataAddressLine1;
        this.pDataAddressLine2 = pDataAddressLine2;
        this.pDataZipCode = pDataZipCode;
        this.pDataHomePhone = pDataHomePhone;
        this.pDataMobilePhone = pDataMobilePhone;
        this.pDataSkypeID = pDataSkypeID;
        this.pDataEmail = pDataEmail;
        this.pDataVisaStatus = pDataVisaStatus;
    }

    public Integer getPDataID() {
        return pDataID;
    }

    public void setPDataID(Integer pDataID) {
        this.pDataID = pDataID;
    }

    public String getPDataFirstName() {
        return pDataFirstName;
    }

    public void setPDataFirstName(String pDataFirstName) {
        this.pDataFirstName = pDataFirstName;
    }

    public String getPDataLastName() {
        return pDataLastName;
    }

    public void setPDataLastName(String pDataLastName) {
        this.pDataLastName = pDataLastName;
    }

    public String getPDataMiddleName() {
        return pDataMiddleName;
    }

    public void setPDataMiddleName(String pDataMiddleName) {
        this.pDataMiddleName = pDataMiddleName;
    }

    public String getPDataGender() {
        return pDataGender;
    }

    public void setPDataGender(String pDataGender) {
        this.pDataGender = pDataGender;
    }

    public String getPDataCountry() {
        return pDataCountry;
    }

    public void setPDataCountry(String pDataCountry) {
        this.pDataCountry = pDataCountry;
    }

    public String getPDataHomeCountry() {
        return pDataHomeCountry;
    }

    public void setPDataHomeCountry(String pDataHomeCountry) {
        this.pDataHomeCountry = pDataHomeCountry;
    }

    public String getPDataCity() {
        return pDataCity;
    }

    public void setPDataCity(String pDataCity) {
        this.pDataCity = pDataCity;
    }

    public String getPDataState() {
        return pDataState;
    }

    public void setPDataState(String pDataState) {
        this.pDataState = pDataState;
    }

    public String getPDataAddressLine1() {
        return pDataAddressLine1;
    }

    public void setPDataAddressLine1(String pDataAddressLine1) {
        this.pDataAddressLine1 = pDataAddressLine1;
    }

    public String getPDataAddressLine2() {
        return pDataAddressLine2;
    }

    public void setPDataAddressLine2(String pDataAddressLine2) {
        this.pDataAddressLine2 = pDataAddressLine2;
    }

    public String getPDataZipCode() {
        return pDataZipCode;
    }

    public void setPDataZipCode(String pDataZipCode) {
        this.pDataZipCode = pDataZipCode;
    }

    public String getPDataHomePhone() {
        return pDataHomePhone;
    }

    public void setPDataHomePhone(String pDataHomePhone) {
        this.pDataHomePhone = pDataHomePhone;
    }

    public String getPDataMobilePhone() {
        return pDataMobilePhone;
    }

    public void setPDataMobilePhone(String pDataMobilePhone) {
        this.pDataMobilePhone = pDataMobilePhone;
    }

    public String getPDataSkypeID() {
        return pDataSkypeID;
    }

    public void setPDataSkypeID(String pDataSkypeID) {
        this.pDataSkypeID = pDataSkypeID;
    }

    public String getPDataEmail() {
        return pDataEmail;
    }

    public void setPDataEmail(String pDataEmail) {
        this.pDataEmail = pDataEmail;
    }

    public String getPDataVisaStatus() {
        return pDataVisaStatus;
    }

    public void setPDataVisaStatus(String pDataVisaStatus) {
        this.pDataVisaStatus = pDataVisaStatus;
    }

//    public ApplicationTbl getPDataAppID() {
//        return pDataAppID;
//    }
//
//    public void setPDataAppID(ApplicationTbl pDataAppID) {
//        this.pDataAppID = pDataAppID;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pDataID != null ? pDataID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaldataTbl)) {
            return false;
        }
        PersonaldataTbl other = (PersonaldataTbl) object;
        if ((this.pDataID == null && other.pDataID != null) || (this.pDataID != null && !this.pDataID.equals(other.pDataID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.PersonaldataTbl[ pDataID=" + pDataID + " ]";
    }
    
}
