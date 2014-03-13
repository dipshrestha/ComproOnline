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
@Table(name = "englishpro_tbl")
@NamedQueries({
    @NamedQuery(name = "EnglishproTbl.findAll", query = "SELECT e FROM EnglishproTbl e"),
    @NamedQuery(name = "EnglishproTbl.findByEnID", query = "SELECT e FROM EnglishproTbl e WHERE e.enID = :enID"),
    @NamedQuery(name = "EnglishproTbl.findByEnReadingWritingAbility", query = "SELECT e FROM EnglishproTbl e WHERE e.enReadingWritingAbility = :enReadingWritingAbility"),
    @NamedQuery(name = "EnglishproTbl.findByEnSpeakingAbility", query = "SELECT e FROM EnglishproTbl e WHERE e.enSpeakingAbility = :enSpeakingAbility"),
    @NamedQuery(name = "EnglishproTbl.findByEnListeningAbility", query = "SELECT e FROM EnglishproTbl e WHERE e.enListeningAbility = :enListeningAbility")})
public class EnglishproTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enID")
    private Integer enID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enReadingWritingAbility")
    private int enReadingWritingAbility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enSpeakingAbility")
    private int enSpeakingAbility;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enListeningAbility")
    private int enListeningAbility;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tEnglishID")
    private Collection<ToeflTbl> toeflTblCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iEnglishID")
    private Collection<IeltsTbl> ieltsTblCollection;
    @JoinColumn(name = "enAppID", referencedColumnName = "appID")
    @ManyToOne(optional = false)
    private ApplicationTbl enAppID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gEnglishID")
    private Collection<GreTbl> greTblCollection;

    public EnglishproTbl() {
    }

    public EnglishproTbl(Integer enID) {
        this.enID = enID;
    }

    public EnglishproTbl(Integer enID, int enReadingWritingAbility, int enSpeakingAbility, int enListeningAbility) {
        this.enID = enID;
        this.enReadingWritingAbility = enReadingWritingAbility;
        this.enSpeakingAbility = enSpeakingAbility;
        this.enListeningAbility = enListeningAbility;
    }

    public Integer getEnID() {
        return enID;
    }

    public void setEnID(Integer enID) {
        this.enID = enID;
    }

    public int getEnReadingWritingAbility() {
        return enReadingWritingAbility;
    }

    public void setEnReadingWritingAbility(int enReadingWritingAbility) {
        this.enReadingWritingAbility = enReadingWritingAbility;
    }

    public int getEnSpeakingAbility() {
        return enSpeakingAbility;
    }

    public void setEnSpeakingAbility(int enSpeakingAbility) {
        this.enSpeakingAbility = enSpeakingAbility;
    }

    public int getEnListeningAbility() {
        return enListeningAbility;
    }

    public void setEnListeningAbility(int enListeningAbility) {
        this.enListeningAbility = enListeningAbility;
    }

    public Collection<ToeflTbl> getToeflTblCollection() {
        return toeflTblCollection;
    }

    public void setToeflTblCollection(Collection<ToeflTbl> toeflTblCollection) {
        this.toeflTblCollection = toeflTblCollection;
    }

    public Collection<IeltsTbl> getIeltsTblCollection() {
        return ieltsTblCollection;
    }

    public void setIeltsTblCollection(Collection<IeltsTbl> ieltsTblCollection) {
        this.ieltsTblCollection = ieltsTblCollection;
    }

    public ApplicationTbl getEnAppID() {
        return enAppID;
    }

    public void setEnAppID(ApplicationTbl enAppID) {
        this.enAppID = enAppID;
    }

    public Collection<GreTbl> getGreTblCollection() {
        return greTblCollection;
    }

    public void setGreTblCollection(Collection<GreTbl> greTblCollection) {
        this.greTblCollection = greTblCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enID != null ? enID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnglishproTbl)) {
            return false;
        }
        EnglishproTbl other = (EnglishproTbl) object;
        if ((this.enID == null && other.enID != null) || (this.enID != null && !this.enID.equals(other.enID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.comproonline.model.EnglishproTbl[ enID=" + enID + " ]";
    }
    
}
