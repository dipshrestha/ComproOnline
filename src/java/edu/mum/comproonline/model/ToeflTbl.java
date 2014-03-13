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
@Table(name = "toefl_tbl")
@NamedQueries({
    @NamedQuery(name = "ToeflTbl.findAll", query = "SELECT t FROM ToeflTbl t"),
    @NamedQuery(name = "ToeflTbl.findByTID", query = "SELECT t FROM ToeflTbl t WHERE t.tID = :tID"),
    @NamedQuery(name = "ToeflTbl.findByTYearTaken", query = "SELECT t FROM ToeflTbl t WHERE t.tYearTaken = :tYearTaken"),
    @NamedQuery(name = "ToeflTbl.findByTScore", query = "SELECT t FROM ToeflTbl t WHERE t.tScore = :tScore")})
public class ToeflTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tID")
    private Integer tID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tYearTaken")
    private String tYearTaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tScore")
    private double tScore;
//    @JoinColumn(name = "tEnglishID", referencedColumnName = "enID")
//    @ManyToOne(optional = false)
//    private EnglishproTbl tEnglishID;

    public ToeflTbl() {
    }

    public ToeflTbl(Integer tID) {
        this.tID = tID;
    }

    public ToeflTbl(Integer tID, String tYearTaken, double tScore) {
        this.tID = tID;
        this.tYearTaken = tYearTaken;
        this.tScore = tScore;
    }

    public Integer getTID() {
        return tID;
    }

    public void setTID(Integer tID) {
        this.tID = tID;
    }

    public String getTYearTaken() {
        return tYearTaken;
    }

    public void setTYearTaken(String tYearTaken) {
        this.tYearTaken = tYearTaken;
    }

    public double getTScore() {
        return tScore;
    }

    public void setTScore(double tScore) {
        this.tScore = tScore;
    }

//    public EnglishproTbl getTEnglishID() {
//        return tEnglishID;
//    }
//
//    public void setTEnglishID(EnglishproTbl tEnglishID) {
//        this.tEnglishID = tEnglishID;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tID != null ? tID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToeflTbl)) {
            return false;
        }
        ToeflTbl other = (ToeflTbl) object;
        if ((this.tID == null && other.tID != null) || (this.tID != null && !this.tID.equals(other.tID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.ToeflTbl[ tID=" + tID + " ]";
    }
    
}
