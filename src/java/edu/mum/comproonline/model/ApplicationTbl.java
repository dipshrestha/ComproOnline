/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nazanin
 */
@Entity
@Table(name = "application_tbl")
@NamedQueries({
    @NamedQuery(name = "ApplicationTbl.findAll", query = "SELECT a FROM ApplicationTbl a"),
    @NamedQuery(name = "ApplicationTbl.findByAppID", query = "SELECT a FROM ApplicationTbl a WHERE a.appID = :appID"),
    @NamedQuery(name = "ApplicationTbl.findByAppStatus", query = "SELECT a FROM ApplicationTbl a WHERE a.appStatus = :appStatus"),
    @NamedQuery(name = "ApplicationTbl.findByAppScore", query = "SELECT a FROM ApplicationTbl a WHERE a.appScore = :appScore")})
public class ApplicationTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appID")
    private Integer appID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appStatus")
    private int appStatus;
    @Column(name = "appScore")
    private Integer appScore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pExAppID")
    private Collection<ProfessionalexpTbl> professionalexpTblCollection;
    @JoinColumn(name = "appUserID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private UserTbl appUserID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pDataAppID")
    private Collection<PersonaldataTbl> personaldataTblCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edAppID")
    private Collection<EducationaldataTbl> educationaldataTblCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enAppID")
    private Collection<EnglishproTbl> englishproTblCollection;

    public ApplicationTbl() {
    }

    public ApplicationTbl(Integer appID) {
        this.appID = appID;
    }

    public ApplicationTbl(Integer appID, int appStatus) {
        this.appID = appID;
        this.appStatus = appStatus;
    }

    public Integer getAppID() {
        return appID;
    }

    public void setAppID(Integer appID) {
        this.appID = appID;
    }

    public int getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }

    public Integer getAppScore() {
        return appScore;
    }

    public void setAppScore(Integer appScore) {
        this.appScore = appScore;
    }

    public Collection<ProfessionalexpTbl> getProfessionalexpTblCollection() {
        return professionalexpTblCollection;
    }

    public void setProfessionalexpTblCollection(Collection<ProfessionalexpTbl> professionalexpTblCollection) {
        this.professionalexpTblCollection = professionalexpTblCollection;
    }

    public UserTbl getAppUserID() {
        return appUserID;
    }

    public void setAppUserID(UserTbl appUserID) {
        this.appUserID = appUserID;
    }

    public Collection<PersonaldataTbl> getPersonaldataTblCollection() {
        return personaldataTblCollection;
    }

    public void setPersonaldataTblCollection(Collection<PersonaldataTbl> personaldataTblCollection) {
        this.personaldataTblCollection = personaldataTblCollection;
    }

    public Collection<EducationaldataTbl> getEducationaldataTblCollection() {
        return educationaldataTblCollection;
    }

    public void setEducationaldataTblCollection(Collection<EducationaldataTbl> educationaldataTblCollection) {
        this.educationaldataTblCollection = educationaldataTblCollection;
    }

    public Collection<EnglishproTbl> getEnglishproTblCollection() {
        return englishproTblCollection;
    }

    public void setEnglishproTblCollection(Collection<EnglishproTbl> englishproTblCollection) {
        this.englishproTblCollection = englishproTblCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appID != null ? appID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationTbl)) {
            return false;
        }
        ApplicationTbl other = (ApplicationTbl) object;
        if ((this.appID == null && other.appID != null) || (this.appID != null && !this.appID.equals(other.appID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.ApplicationTbl[ appID=" + appID + " ]";
    }
    
}
