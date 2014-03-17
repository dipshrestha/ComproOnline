/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Nazanin
 */
@Entity
@Table(name = "gre_tbl")
@NamedQueries({
    @NamedQuery(name = "GreTbl.findAll", query = "SELECT g FROM GreTbl g"),
    @NamedQuery(name = "GreTbl.findByGID", query = "SELECT g FROM GreTbl g WHERE g.gID = :gID"),
    @NamedQuery(name = "GreTbl.findByGVerbalScore", query = "SELECT g FROM GreTbl g WHERE g.gVerbalScore = :gVerbalScore"),
    @NamedQuery(name = "GreTbl.findByGVerbalPercentile", query = "SELECT g FROM GreTbl g WHERE g.gVerbalPercentile = :gVerbalPercentile"),
    @NamedQuery(name = "GreTbl.findByGQuantitativeScore", query = "SELECT g FROM GreTbl g WHERE g.gQuantitativeScore = :gQuantitativeScore"),
    @NamedQuery(name = "GreTbl.findByGQuantitativePercentile", query = "SELECT g FROM GreTbl g WHERE g.gQuantitativePercentile = :gQuantitativePercentile"),
    @NamedQuery(name = "GreTbl.findByGAnalyticalScore", query = "SELECT g FROM GreTbl g WHERE g.gAnalyticalScore = :gAnalyticalScore"),
    @NamedQuery(name = "GreTbl.findByGAnalyticalPercentile", query = "SELECT g FROM GreTbl g WHERE g.gAnalyticalPercentile = :gAnalyticalPercentile"),
    @NamedQuery(name = "GreTbl.findByGYearTaken", query = "SELECT g FROM GreTbl g WHERE g.gYearTaken = :gYearTaken")})
public class GreTbl implements Serializable {
    @Column(name = "gAnalyticalPercentile")
    private Integer gAnalyticalPercentile;
    @Column(name = "gAnalyticalScore")
    private Integer gAnalyticalScore;
    @Column(name = "gQuantitativePercentile")
    //@NotNull
    private Integer gQuantitativePercentile;
    @Column(name = "gQuantitativeScore")
    //@NotNull
    private Integer gQuantitativeScore;
    @Column(name = "gVerbalPercentile")
    //@NotNull
    private Integer gVerbalPercentile;
    @Column(name = "gVerbalScore")
    //@NotNull
    private Integer gVerbalScore;
  /*  @OneToMany(mappedBy = "appGID")
    //@NotNull
    private Collection<EnglishproTbl> englishproTblCollection;
    private static final long serialVersionUID = 1L;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gID")
    private Integer gID;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 10)
    @Column(name = "gYearTaken")
    private String gYearTaken;
//    @JoinColumn(name = "gEnglishID", referencedColumnName = "enID")
//    @ManyToOne(optional = false)
//    private EnglishproTbl gEnglishID;

    public GreTbl() {
    }

    public GreTbl(Integer gID) {
        this.gID = gID;
    }

    public GreTbl(Integer gID, int gVerbalScore, int gVerbalPercentile, int gQuantitativeScore, int gQuantitativePercentile, int gAnalyticalScore, int gAnalyticalPercentile, String gYearTaken) {
        this.gID = gID;
        this.gVerbalScore = gVerbalScore;
        this.gVerbalPercentile = gVerbalPercentile;
        this.gQuantitativeScore = gQuantitativeScore;
        this.gQuantitativePercentile = gQuantitativePercentile;
        this.gAnalyticalScore = gAnalyticalScore;
        this.gAnalyticalPercentile = gAnalyticalPercentile;
        this.gYearTaken = gYearTaken;
    }

    public Integer getGID() {
        return gID;
    }

    public void setGID(Integer gID) {
        this.gID = gID;
    }

    public String getGYearTaken() {
        return gYearTaken;
    }

    public void setGYearTaken(String gYearTaken) {
        this.gYearTaken = gYearTaken;
    }
//
//    public EnglishproTbl getGEnglishID() {
//        return gEnglishID;
//    }
//
//    public void setGEnglishID(EnglishproTbl gEnglishID) {
//        this.gEnglishID = gEnglishID;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gID != null ? gID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GreTbl)) {
            return false;
        }
        GreTbl other = (GreTbl) object;
        if ((this.gID == null && other.gID != null) || (this.gID != null && !this.gID.equals(other.gID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.GreTbl[ gID=" + gID + " ]";
    }

    public Integer getGAnalyticalPercentile() {
        return gAnalyticalPercentile;
    }

    public void setGAnalyticalPercentile(Integer gAnalyticalPercentile) {
        this.gAnalyticalPercentile = gAnalyticalPercentile;
    }

    public Integer getGAnalyticalScore() {
        return gAnalyticalScore;
    }

    public void setGAnalyticalScore(Integer gAnalyticalScore) {
        this.gAnalyticalScore = gAnalyticalScore;
    }

    public Integer getGQuantitativePercentile() {
        return gQuantitativePercentile;
    }

    public void setGQuantitativePercentile(Integer gQuantitativePercentile) {
        this.gQuantitativePercentile = gQuantitativePercentile;
    }

    public Integer getGQuantitativeScore() {
        return gQuantitativeScore;
    }

    public void setGQuantitativeScore(Integer gQuantitativeScore) {
        this.gQuantitativeScore = gQuantitativeScore;
    }

    public Integer getGVerbalPercentile() {
        return gVerbalPercentile;
    }

    public void setGVerbalPercentile(Integer gVerbalPercentile) {
        this.gVerbalPercentile = gVerbalPercentile;
    }

    public Integer getGVerbalScore() {
        return gVerbalScore;
    }

    public void setGVerbalScore(Integer gVerbalScore) {
        this.gVerbalScore = gVerbalScore;
    }

   /* public Collection<EnglishproTbl> getEnglishproTblCollection() {
        return englishproTblCollection;
    }

    public void setEnglishproTblCollection(Collection<EnglishproTbl> englishproTblCollection) {
        this.englishproTblCollection = englishproTblCollection;
    }*/
    
}
