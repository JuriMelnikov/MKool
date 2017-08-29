/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jvm
 */
@Entity
@Table(name = "child")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Child.findAll", query = "SELECT c FROM Child c")
    , @NamedQuery(name = "Child.findById", query = "SELECT c FROM Child c WHERE c.id = :id")
    , @NamedQuery(name = "Child.findByChildGroup", query = "SELECT c FROM Child c WHERE c.childGroup = :childGroup")})
public class Child implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "child_group")
    private int childGroup;
    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person person;

    public Child() {
    }

    public Child(Integer id) {
        this.id = id;
    }

    public Child(Integer id, int childGroup) {
        this.id = id;
        this.childGroup = childGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getChildGroup() {
        return childGroup;
    }

    public void setChildGroup(int childGroup) {
        this.childGroup = childGroup;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Child)) {
            return false;
        }
        Child other = (Child) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Child[ id=" + id + " ]";
    }
    
}
