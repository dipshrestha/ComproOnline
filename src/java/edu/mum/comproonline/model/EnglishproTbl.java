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
import javax.persistence.OneToOne;
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
    @Column(name = "enListeningAbility")
    private Integer enListeningAbility;
    @Column(name = "enReadingWritingAbility")
    private Integer enReadingWritingAbility;
    @Column(name = "enSpeakingAbility")
    private Integer enSpeakingAbility;
    @Column(name = "enAppID")
    private Integer enAppID;
   /* @OneToMany(mappedBy = "appEnID")
    private Collection<ApplicationTbl> applicationTblCollection;
    private static final long serialVersionUID = 1L;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enID")
    private Integer enID;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enTID", referencedColumnName = "tId")
    private ToeflTbl toeflTbl;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appIID", referencedColumnName = "iID")
    private IeltsTbl ieltsTbl;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appGID", referencedColumnName = "gID")
    private GreTbl greTbl;
    
//    @JoinColumn(name = "enAppID", referencedColumnName = "appID")
//    @ManyToOne(optional = false)
//    private ApplicationTbl enAppID;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tEnglishID")
//    private Collection<ToeflTbl> toeflTblCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iEnglishID")
//    private Collection<IeltsTbl> ieltsTblCollection;
//    @JoinColumn(name = "enAppID", referencedColumnName = "appID")
//    @ManyToOne(optional = false)
//    private ApplicationTbl enAppID;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gEnglishID")
//    private Collection<GreTbl> greTblCollection;

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

    public ToeflTbl getToeflTbl() {
        return toeflTbl;
    }

    public void setToeflTbl(ToeflTbl toeflTbl) {
        this.toeflTbl = toeflTbl;
    }

    public IeltsTbl getIeltsTbl() {
        return ieltsTbl;
    }

    public void setIeltsTbl(IeltsTbl ieltsTbl) {
        this.ieltsTbl = ieltsTbl;
    }

//    public ApplicationTbl getEnAppID() {
//        return enAppID;
//    }
//
//    public void setEnAppID(ApplicationTbl enAppID) {
//        this.enAppID = enAppID;
//    }
//
    public GreTbl getGreTbl() {
        return greTbl;
    }

    public void setGreTbl(GreTbl greTbl) {
        this.greTbl = greTbl;
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

    public Integer getEnListeningAbility() {
        return enListeningAbility;
    }

    public void setEnListeningAbility(Integer enListeningAbility) {
        this.enListeningAbility = enListeningAbility;
    }

    public Integer getEnReadingWritingAbility() {
        return enReadingWritingAbility;
    }

    public void setEnReadingWritingAbility(Integer enReadingWritingAbility) {
        this.enReadingWritingAbility = enReadingWritingAbility;
    }

    public Integer getEnSpeakingAbility() {
        return enSpeakingAbility;
    }

    public void setEnSpeakingAbility(Integer enSpeakingAbility) {
        this.enSpeakingAbility = enSpeakingAbility;
    }

    public Integer getEnAppID() {
        return enAppID;
    }

    public void setEnAppID(Integer enAppID) {
        this.enAppID = enAppID;
    }

   /* public Collection<ApplicationTbl> getApplicationTblCollection() {
        return applicationTblCollection;
    }

    public void setApplicationTblCollection(Collection<ApplicationTbl> applicationTblCollection) {
        this.applicationTblCollection = applicationTblCollection;
    }*/
    
}
