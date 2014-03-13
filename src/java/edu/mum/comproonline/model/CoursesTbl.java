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
@Table(name = "courses_tbl")
@NamedQueries({
    @NamedQuery(name = "CoursesTbl.findAll", query = "SELECT c FROM CoursesTbl c"),
    @NamedQuery(name = "CoursesTbl.findByCourseID", query = "SELECT c FROM CoursesTbl c WHERE c.courseID = :courseID"),
    @NamedQuery(name = "CoursesTbl.findByCourseType", query = "SELECT c FROM CoursesTbl c WHERE c.courseType = :courseType"),
    @NamedQuery(name = "CoursesTbl.findByCourseTitle", query = "SELECT c FROM CoursesTbl c WHERE c.courseTitle = :courseTitle"),
    @NamedQuery(name = "CoursesTbl.findByCourseGrade", query = "SELECT c FROM CoursesTbl c WHERE c.courseGrade = :courseGrade")})
public class CoursesTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseID")
    private Integer courseID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "courseType")
    private String courseType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "courseTitle")
    private String courseTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "courseGrade")
    private String courseGrade;
    @JoinColumn(name = "courseInsID", referencedColumnName = "instituteID")
    @ManyToOne(optional = false)
    private InstituteTbl courseInsID;

    public CoursesTbl() {
    }

    public CoursesTbl(Integer courseID) {
        this.courseID = courseID;
    }

    public CoursesTbl(Integer courseID, String courseType, String courseTitle, String courseGrade) {
        this.courseID = courseID;
        this.courseType = courseType;
        this.courseTitle = courseTitle;
        this.courseGrade = courseGrade;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public InstituteTbl getCourseInsID() {
        return courseInsID;
    }

    public void setCourseInsID(InstituteTbl courseInsID) {
        this.courseInsID = courseInsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursesTbl)) {
            return false;
        }
        CoursesTbl other = (CoursesTbl) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.CoursesTbl[ courseID=" + courseID + " ]";
    }
    
}
