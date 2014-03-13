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
import javax.validation.constraints.Size;

/**
 *
 * @author Nazanin
 */
@Entity
@Table(name = "institute_tbl")
@NamedQueries({
    @NamedQuery(name = "InstituteTbl.findAll", query = "SELECT i FROM InstituteTbl i"),
    @NamedQuery(name = "InstituteTbl.findByInstituteID", query = "SELECT i FROM InstituteTbl i WHERE i.instituteID = :instituteID"),
    @NamedQuery(name = "InstituteTbl.findByInstituteName", query = "SELECT i FROM InstituteTbl i WHERE i.instituteName = :instituteName"),
    @NamedQuery(name = "InstituteTbl.findByInstituteDegree", query = "SELECT i FROM InstituteTbl i WHERE i.instituteDegree = :instituteDegree"),
    @NamedQuery(name = "InstituteTbl.findByInstituteSubject", query = "SELECT i FROM InstituteTbl i WHERE i.instituteSubject = :instituteSubject"),
    @NamedQuery(name = "InstituteTbl.findByInstituteArea", query = "SELECT i FROM InstituteTbl i WHERE i.instituteArea = :instituteArea"),
    @NamedQuery(name = "InstituteTbl.findByInstituteCounty", query = "SELECT i FROM InstituteTbl i WHERE i.instituteCounty = :instituteCounty"),
    @NamedQuery(name = "InstituteTbl.findByInstituteCity", query = "SELECT i FROM InstituteTbl i WHERE i.instituteCity = :instituteCity"),
    @NamedQuery(name = "InstituteTbl.findByInstituteStartDate", query = "SELECT i FROM InstituteTbl i WHERE i.instituteStartDate = :instituteStartDate"),
    @NamedQuery(name = "InstituteTbl.findByInstituteEndDate", query = "SELECT i FROM InstituteTbl i WHERE i.instituteEndDate = :instituteEndDate"),
    @NamedQuery(name = "InstituteTbl.findByInstituteGradingScale", query = "SELECT i FROM InstituteTbl i WHERE i.instituteGradingScale = :instituteGradingScale"),
    @NamedQuery(name = "InstituteTbl.findByInstituteFinalGPA", query = "SELECT i FROM InstituteTbl i WHERE i.instituteFinalGPA = :instituteFinalGPA"),
    @NamedQuery(name = "InstituteTbl.findByInstituteDegreeStatus", query = "SELECT i FROM InstituteTbl i WHERE i.instituteDegreeStatus = :instituteDegreeStatus")})
public class InstituteTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "instituteID")
    private Integer instituteID;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "instituteName")
    private String instituteName;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 100)
    @Column(name = "instituteDegree")
    private String instituteDegree;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 100)
    @Column(name = "instituteSubject")
    private String instituteSubject;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "instituteArea")
    private String instituteArea;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "instituteCounty")
    private String instituteCounty;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "instituteCity")
    private String instituteCity;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 20)
    @Column(name = "instituteStartDate")
    private String instituteStartDate;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 20)
    @Column(name = "instituteEndDate")
    private String instituteEndDate;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 20)
    @Column(name = "instituteGradingScale")
    private String instituteGradingScale;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 20)
    @Column(name = "instituteFinalGPA")
    private String instituteFinalGPA;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 100)
    @Column(name = "instituteDegreeStatus")
    private String instituteDegreeStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseInsID")
    private Collection<CoursesTbl> coursesTblCollection;      
    @JoinColumn(name = "instituteEdID", referencedColumnName = "edID")
    @ManyToOne(optional = false)
    private EducationaldataTbl instituteEdID;

    public InstituteTbl() {
    }

    public InstituteTbl(Integer instituteID) {
        this.instituteID = instituteID;
    }

    public InstituteTbl(Integer instituteID, String instituteName, String instituteDegree, String instituteSubject, String instituteArea, String instituteCounty, String instituteCity, String instituteStartDate, String instituteEndDate, String instituteGradingScale, String instituteFinalGPA, String instituteDegreeStatus) {
        this.instituteID = instituteID;
        this.instituteName = instituteName;
        this.instituteDegree = instituteDegree;
        this.instituteSubject = instituteSubject;
        this.instituteArea = instituteArea;
        this.instituteCounty = instituteCounty;
        this.instituteCity = instituteCity;
        this.instituteStartDate = instituteStartDate;
        this.instituteEndDate = instituteEndDate;
        this.instituteGradingScale = instituteGradingScale;
        this.instituteFinalGPA = instituteFinalGPA;
        this.instituteDegreeStatus = instituteDegreeStatus;
    }

    public Integer getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(Integer instituteID) {
        this.instituteID = instituteID;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteDegree() {
        return instituteDegree;
    }

    public void setInstituteDegree(String instituteDegree) {
        this.instituteDegree = instituteDegree;
    }

    public String getInstituteSubject() {
        return instituteSubject;
    }

    public void setInstituteSubject(String instituteSubject) {
        this.instituteSubject = instituteSubject;
    }

    public String getInstituteArea() {
        return instituteArea;
    }

    public void setInstituteArea(String instituteArea) {
        this.instituteArea = instituteArea;
    }

    public String getInstituteCounty() {
        return instituteCounty;
    }

    public void setInstituteCounty(String instituteCounty) {
        this.instituteCounty = instituteCounty;
    }

    public String getInstituteCity() {
        return instituteCity;
    }

    public void setInstituteCity(String instituteCity) {
        this.instituteCity = instituteCity;
    }

    public String getInstituteStartDate() {
        return instituteStartDate;
    }

    public void setInstituteStartDate(String instituteStartDate) {
        this.instituteStartDate = instituteStartDate;
    }

    public String getInstituteEndDate() {
        return instituteEndDate;
    }

    public void setInstituteEndDate(String instituteEndDate) {
        this.instituteEndDate = instituteEndDate;
    }

    public String getInstituteGradingScale() {
        return instituteGradingScale;
    }

    public void setInstituteGradingScale(String instituteGradingScale) {
        this.instituteGradingScale = instituteGradingScale;
    }

    public String getInstituteFinalGPA() {
        return instituteFinalGPA;
    }

    public void setInstituteFinalGPA(String instituteFinalGPA) {
        this.instituteFinalGPA = instituteFinalGPA;
    }

    public String getInstituteDegreeStatus() {
        return instituteDegreeStatus;
    }

    public void setInstituteDegreeStatus(String instituteDegreeStatus) {
        this.instituteDegreeStatus = instituteDegreeStatus;
    }

    public Collection<CoursesTbl> getCoursesTblCollection() {
        return coursesTblCollection;
    }

    public void setCoursesTblCollection(Collection<CoursesTbl> coursesTblCollection) {
        this.coursesTblCollection = coursesTblCollection;
    }

    public EducationaldataTbl getInstituteEdID() {
        return instituteEdID;
    }

    public void setInstituteEdID(EducationaldataTbl instituteEdID) {
        this.instituteEdID = instituteEdID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instituteID != null ? instituteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstituteTbl)) {
            return false;
        }
        InstituteTbl other = (InstituteTbl) object;
        if ((this.instituteID == null && other.instituteID != null) || (this.instituteID != null && !this.instituteID.equals(other.instituteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.InstituteTbl[ instituteID=" + instituteID + " ]";
    }
    
}
