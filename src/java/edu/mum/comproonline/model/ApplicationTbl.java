/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author Nazanin
 */
@Entity
@Table(name = "application_tbl")
@NamedQueries({
    @NamedQuery(name = "ApplicationTbl.findAll", query = "SELECT a FROM ApplicationTbl a"),
    @NamedQuery(name = "ApplicationTbl.findByAppID", query = "SELECT a FROM ApplicationTbl a WHERE a.appID = :appID"),
    @NamedQuery(name = "ApplicationTbl.findByAppSubmitStatus", query = "SELECT a FROM ApplicationTbl a WHERE a.appSubmitStatus = :appSubmitStatus"),
    @NamedQuery(name = "ApplicationTbl.findByAppEvalStatus", query = "SELECT a FROM ApplicationTbl a WHERE a.appEvalStatus = :appEvalStatus"),
    @NamedQuery(name = "ApplicationTbl.findByAppScore", query = "SELECT a FROM ApplicationTbl a WHERE a.appEvalScore = :appEvalScore")})
public class ApplicationTbl implements Serializable {
    @Column(name = "appSubmitStatus")
    private Integer appSubmitStatus;
    @Column(name = "appEvalStatus")
    private Integer appEvalStatus;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appID")
    private Integer appID;
    @Column(name = "appEvalScore")
    private Integer appEvalScore;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "pExAppID")
    //private Collection<ProfessionalexpTbl> professionalexpTblCollection;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appPExID", referencedColumnName = "pExID")
    private ProfessionalexpTbl professionalexpTbl;
    
    @JoinColumn(name = "appUserID", referencedColumnName = "userID")
    //@ManyToOne(optional = false)
    @OneToOne(optional = false)
    private UserTbl appUserID;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pDataAppID")
//    private Collection<PersonaldataTbl> personaldataTblCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edAppID")
//    private Collection<EducationaldataTbl> educationaldataTblCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enAppID")
//    private Collection<EnglishproTbl> englishproTblCollection;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appPDataID", referencedColumnName = "pDataID")
    private PersonaldataTbl personaldataTbl;
            
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appEdID", referencedColumnName = "edId")            
    private EducationaldataTbl educationaldataTbl;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appEnID", referencedColumnName = "enID")
    private EnglishproTbl englishproTbl;
    
    public ApplicationTbl() {
    }

    public ApplicationTbl(Integer appID) {
        this.appID = appID;
    }

    public ApplicationTbl(Integer appID, int appStatus) {
        this.appID = appID;
        this.appSubmitStatus = appStatus;
    }

    public Integer getAppID() {
        return appID;
    }

    public void setAppID(Integer appID) {
        this.appID = appID;
    }

    public Integer getAppEvalScore() {
        return appEvalScore;
    }

    public void setAppEvalScore(Integer appEvalScore) {
        this.appEvalScore = appEvalScore;
    }

//    public Collection<ProfessionalexpTbl> getProfessionalexpTblCollection() {
//        return professionalexpTblCollection;
//    }
//
//    public void setProfessionalexpTblCollection(Collection<ProfessionalexpTbl> professionalexpTblCollection) {
//        this.professionalexpTblCollection = professionalexpTblCollection;
//    }
    
    public ProfessionalexpTbl getProfessionalexpTbl() {
        return professionalexpTbl;
    }

    public void setProfessionalexpTbl(ProfessionalexpTbl professionalexpTbl) {
        this.professionalexpTbl = professionalexpTbl;
    }

    public UserTbl getAppUserID() {
        return appUserID;
    }

    public void setAppUserID(UserTbl appUserID) {
        this.appUserID = appUserID;
    }

    public PersonaldataTbl getPersonaldataTbl() {
        return personaldataTbl;
    }

    public void setPersonaldataTbl(PersonaldataTbl personaldataTbl) {
        this.personaldataTbl = personaldataTbl;
    }

    public EducationaldataTbl getEducationaldataTbl() {
        return educationaldataTbl;
    }

    public void setEducationaldataTbl(EducationaldataTbl educationaldataTbl) {
        this.educationaldataTbl = educationaldataTbl;
    }

    public EnglishproTbl getEnglishproTbl() {
        return englishproTbl;
    }

    public void setEnglishproTbl(EnglishproTbl englishproTbl) {
        this.englishproTbl = englishproTbl;
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

    public Integer getAppSubmitStatus() {
        return appSubmitStatus;
    }

    public void setAppSubmitStatus(Integer appStatus) {
        this.appSubmitStatus = appStatus;
    }

    public Integer getAppEvalStatus() {
        return appEvalStatus;
    }

    public void setAppEvalStatus(Integer appEvalStatus) {
        this.appEvalStatus = appEvalStatus;
    }
    
}
