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

/**
 *
 * @author Nazanin
 */
@Entity
@Table(name = "educationaldata_tbl")
@NamedQueries({
    @NamedQuery(name = "EducationaldataTbl.findAll", query = "SELECT e FROM EducationaldataTbl e"),
    @NamedQuery(name = "EducationaldataTbl.findByEdID", query = "SELECT e FROM EducationaldataTbl e WHERE e.edID = :edID")})
public class EducationaldataTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "edID")
    private Integer edID;
    
    //@OneToMany(cascade = CascadeType.ALL)    
    //@JoinColumn(name = "edInstituteID", referencedColumnName = "instituteID") 
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "instituteEdID")    
    @OneToMany(cascade = CascadeType.ALL)    
    @JoinColumn(name = "edInstituteID", referencedColumnName = "edID") 
    private Collection<InstituteTbl> instituteTblCollection;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instituteEdID")
//    private Collection<InstituteTbl> instituteTblCollection;
//    @JoinColumn(name = "edAppID", referencedColumnName = "appID")
//    @ManyToOne(optional = false)
//    private ApplicationTbl edAppID;

    public EducationaldataTbl() {
    }

    public EducationaldataTbl(Integer edID) {
        this.edID = edID;
    }

    public Integer getEdID() {
        return edID;
    }

    public void setEdID(Integer edID) {
        this.edID = edID;
    }

    public Collection<InstituteTbl> getInstituteTblCollection() {
        return instituteTblCollection;
    }

    public void setInstituteTblCollection(Collection<InstituteTbl> instituteTblCollection) {
        this.instituteTblCollection = instituteTblCollection;
    }
//
//    public ApplicationTbl getEdAppID() {
//        return edAppID;
//    }
//
//    public void setEdAppID(ApplicationTbl edAppID) {
//        this.edAppID = edAppID;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edID != null ? edID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationaldataTbl)) {
            return false;
        }
        EducationaldataTbl other = (EducationaldataTbl) object;
        if ((this.edID == null && other.edID != null) || (this.edID != null && !this.edID.equals(other.edID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.EducationaldataTbl[ edID=" + edID + " ]";
    }
    
}
