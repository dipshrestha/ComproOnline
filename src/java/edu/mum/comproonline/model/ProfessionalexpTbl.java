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
@Table(name = "professionalexp_tbl")
@NamedQueries({
    @NamedQuery(name = "ProfessionalexpTbl.findAll", query = "SELECT p FROM ProfessionalexpTbl p"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExID", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExID = :pExID"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExCompanyName", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExCompanyName = :pExCompanyName"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExCountry", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExCountry = :pExCountry"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExCity", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExCity = :pExCity"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExState", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExState = :pExState"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExStartDate", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExStartDate = :pExStartDate"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExEndDate", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExEndDate = :pExEndDate"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExPosition", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExPosition = :pExPosition"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExEmploymentType", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExEmploymentType = :pExEmploymentType"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExProgrammingTime", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExProgrammingTime = :pExProgrammingTime"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExDataStructureTime", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExDataStructureTime = :pExDataStructureTime"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExNetworkingTime", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExNetworkingTime = :pExNetworkingTime"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExDbAdminTime", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExDbAdminTime = :pExDbAdminTime"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExTrainingTime", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExTrainingTime = :pExTrainingTime"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExManagementTime", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExManagementTime = :pExManagementTime"),
    @NamedQuery(name = "ProfessionalexpTbl.findByPExOtherTime", query = "SELECT p FROM ProfessionalexpTbl p WHERE p.pExOtherTime = :pExOtherTime")})
public class ProfessionalexpTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pExID")
    private Integer pExID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExCompanyName")
    private String pExCompanyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExCountry")
    private String pExCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExCity")
    private String pExCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExState")
    private String pExState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExStartDate")
    private String pExStartDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExEndDate")
    private String pExEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExPosition")
    private String pExPosition;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pExEmploymentType")
    private String pExEmploymentType;
    @Column(name = "pExProgrammingTime")
    private Integer pExProgrammingTime;
    @Column(name = "pExDataStructureTime")
    private Integer pExDataStructureTime;
    @Column(name = "pExNetworkingTime")
    private Integer pExNetworkingTime;
    @Column(name = "pExDbAdminTime")
    private Integer pExDbAdminTime;
    @Column(name = "pExTrainingTime")
    private Integer pExTrainingTime;
    @Column(name = "pExManagementTime")
    private Integer pExManagementTime;
    @Column(name = "pExOtherTime")
    private Integer pExOtherTime;
    @JoinColumn(name = "pExAppID", referencedColumnName = "appID")
    @ManyToOne(optional = false)
    private ApplicationTbl pExAppID;

    public ProfessionalexpTbl() {
    }

    public ProfessionalexpTbl(Integer pExID) {
        this.pExID = pExID;
    }

    public ProfessionalexpTbl(Integer pExID, String pExCompanyName, String pExCountry, String pExCity, String pExState, String pExStartDate, String pExEndDate, String pExPosition, String pExEmploymentType) {
        this.pExID = pExID;
        this.pExCompanyName = pExCompanyName;
        this.pExCountry = pExCountry;
        this.pExCity = pExCity;
        this.pExState = pExState;
        this.pExStartDate = pExStartDate;
        this.pExEndDate = pExEndDate;
        this.pExPosition = pExPosition;
        this.pExEmploymentType = pExEmploymentType;
    }

    public Integer getPExID() {
        return pExID;
    }

    public void setPExID(Integer pExID) {
        this.pExID = pExID;
    }

    public String getPExCompanyName() {
        return pExCompanyName;
    }

    public void setPExCompanyName(String pExCompanyName) {
        this.pExCompanyName = pExCompanyName;
    }

    public String getPExCountry() {
        return pExCountry;
    }

    public void setPExCountry(String pExCountry) {
        this.pExCountry = pExCountry;
    }

    public String getPExCity() {
        return pExCity;
    }

    public void setPExCity(String pExCity) {
        this.pExCity = pExCity;
    }

    public String getPExState() {
        return pExState;
    }

    public void setPExState(String pExState) {
        this.pExState = pExState;
    }

    public String getPExStartDate() {
        return pExStartDate;
    }

    public void setPExStartDate(String pExStartDate) {
        this.pExStartDate = pExStartDate;
    }

    public String getPExEndDate() {
        return pExEndDate;
    }

    public void setPExEndDate(String pExEndDate) {
        this.pExEndDate = pExEndDate;
    }

    public String getPExPosition() {
        return pExPosition;
    }

    public void setPExPosition(String pExPosition) {
        this.pExPosition = pExPosition;
    }

    public String getPExEmploymentType() {
        return pExEmploymentType;
    }

    public void setPExEmploymentType(String pExEmploymentType) {
        this.pExEmploymentType = pExEmploymentType;
    }

    public Integer getPExProgrammingTime() {
        return pExProgrammingTime;
    }

    public void setPExProgrammingTime(Integer pExProgrammingTime) {
        this.pExProgrammingTime = pExProgrammingTime;
    }

    public Integer getPExDataStructureTime() {
        return pExDataStructureTime;
    }

    public void setPExDataStructureTime(Integer pExDataStructureTime) {
        this.pExDataStructureTime = pExDataStructureTime;
    }

    public Integer getPExNetworkingTime() {
        return pExNetworkingTime;
    }

    public void setPExNetworkingTime(Integer pExNetworkingTime) {
        this.pExNetworkingTime = pExNetworkingTime;
    }

    public Integer getPExDbAdminTime() {
        return pExDbAdminTime;
    }

    public void setPExDbAdminTime(Integer pExDbAdminTime) {
        this.pExDbAdminTime = pExDbAdminTime;
    }

    public Integer getPExTrainingTime() {
        return pExTrainingTime;
    }

    public void setPExTrainingTime(Integer pExTrainingTime) {
        this.pExTrainingTime = pExTrainingTime;
    }

    public Integer getPExManagementTime() {
        return pExManagementTime;
    }

    public void setPExManagementTime(Integer pExManagementTime) {
        this.pExManagementTime = pExManagementTime;
    }

    public Integer getPExOtherTime() {
        return pExOtherTime;
    }

    public void setPExOtherTime(Integer pExOtherTime) {
        this.pExOtherTime = pExOtherTime;
    }

    public ApplicationTbl getPExAppID() {
        return pExAppID;
    }

    public void setPExAppID(ApplicationTbl pExAppID) {
        this.pExAppID = pExAppID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pExID != null ? pExID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessionalexpTbl)) {
            return false;
        }
        ProfessionalexpTbl other = (ProfessionalexpTbl) object;
        if ((this.pExID == null && other.pExID != null) || (this.pExID != null && !this.pExID.equals(other.pExID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.ProfessionalexpTbl[ pExID=" + pExID + " ]";
    }
    
}
