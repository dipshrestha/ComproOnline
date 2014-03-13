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
@Table(name = "ielts_tbl")
@NamedQueries({
    @NamedQuery(name = "IeltsTbl.findAll", query = "SELECT i FROM IeltsTbl i"),
    @NamedQuery(name = "IeltsTbl.findByIID", query = "SELECT i FROM IeltsTbl i WHERE i.iID = :iID"),
    @NamedQuery(name = "IeltsTbl.findByISpeakingScore", query = "SELECT i FROM IeltsTbl i WHERE i.iSpeakingScore = :iSpeakingScore"),
    @NamedQuery(name = "IeltsTbl.findByIReadingScore", query = "SELECT i FROM IeltsTbl i WHERE i.iReadingScore = :iReadingScore"),
    @NamedQuery(name = "IeltsTbl.findByIWritingScore", query = "SELECT i FROM IeltsTbl i WHERE i.iWritingScore = :iWritingScore"),
    @NamedQuery(name = "IeltsTbl.findByIListeningScore", query = "SELECT i FROM IeltsTbl i WHERE i.iListeningScore = :iListeningScore"),
    @NamedQuery(name = "IeltsTbl.findByIYearTaken", query = "SELECT i FROM IeltsTbl i WHERE i.iYearTaken = :iYearTaken"),
    @NamedQuery(name = "IeltsTbl.findByIOveralScore", query = "SELECT i FROM IeltsTbl i WHERE i.iOveralScore = :iOveralScore")})
public class IeltsTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iID")
    private Integer iID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iSpeakingScore")
    private double iSpeakingScore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iReadingScore")
    private double iReadingScore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iWritingScore")
    private double iWritingScore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iListeningScore")
    private double iListeningScore;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "iYearTaken")
    private String iYearTaken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iOveralScore")
    private double iOveralScore;
    @JoinColumn(name = "iEnglishID", referencedColumnName = "enID")
    @ManyToOne(optional = false)
    private EnglishproTbl iEnglishID;

    public IeltsTbl() {
    }

    public IeltsTbl(Integer iID) {
        this.iID = iID;
    }

    public IeltsTbl(Integer iID, double iSpeakingScore, double iReadingScore, double iWritingScore, double iListeningScore, String iYearTaken, double iOveralScore) {
        this.iID = iID;
        this.iSpeakingScore = iSpeakingScore;
        this.iReadingScore = iReadingScore;
        this.iWritingScore = iWritingScore;
        this.iListeningScore = iListeningScore;
        this.iYearTaken = iYearTaken;
        this.iOveralScore = iOveralScore;
    }

    public Integer getIID() {
        return iID;
    }

    public void setIID(Integer iID) {
        this.iID = iID;
    }

    public double getISpeakingScore() {
        return iSpeakingScore;
    }

    public void setISpeakingScore(double iSpeakingScore) {
        this.iSpeakingScore = iSpeakingScore;
    }

    public double getIReadingScore() {
        return iReadingScore;
    }

    public void setIReadingScore(double iReadingScore) {
        this.iReadingScore = iReadingScore;
    }

    public double getIWritingScore() {
        return iWritingScore;
    }

    public void setIWritingScore(double iWritingScore) {
        this.iWritingScore = iWritingScore;
    }

    public double getIListeningScore() {
        return iListeningScore;
    }

    public void setIListeningScore(double iListeningScore) {
        this.iListeningScore = iListeningScore;
    }

    public String getIYearTaken() {
        return iYearTaken;
    }

    public void setIYearTaken(String iYearTaken) {
        this.iYearTaken = iYearTaken;
    }

    public double getIOveralScore() {
        return iOveralScore;
    }

    public void setIOveralScore(double iOveralScore) {
        this.iOveralScore = iOveralScore;
    }

    public EnglishproTbl getIEnglishID() {
        return iEnglishID;
    }

    public void setIEnglishID(EnglishproTbl iEnglishID) {
        this.iEnglishID = iEnglishID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iID != null ? iID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IeltsTbl)) {
            return false;
        }
        IeltsTbl other = (IeltsTbl) object;
        if ((this.iID == null && other.iID != null) || (this.iID != null && !this.iID.equals(other.iID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.IeltsTbl[ iID=" + iID + " ]";
    }
    
}
