/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jvm
 */
@Entity
@Table(name = "security_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecurityGroup.findAll", query = "SELECT s FROM SecurityGroup s")
    , @NamedQuery(name = "SecurityGroup.findById", query = "SELECT s FROM SecurityGroup s WHERE s.id = :id")
    , @NamedQuery(name = "SecurityGroup.findByGroupName", query = "SELECT s FROM SecurityGroup s WHERE s.groupName = :groupName")})
public class SecurityGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "group_name")
    private String groupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "securityGroup")
    private Collection<UsersInSecurityGroup> usersInSecurityGroupCollection;

    public SecurityGroup() {
    }

    public SecurityGroup(Integer id) {
        this.id = id;
    }

    public SecurityGroup(Integer id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public Collection<UsersInSecurityGroup> getUsersInSecurityGroupCollection() {
        return usersInSecurityGroupCollection;
    }

    public void setUsersInSecurityGroupCollection(Collection<UsersInSecurityGroup> usersInSecurityGroupCollection) {
        this.usersInSecurityGroupCollection = usersInSecurityGroupCollection;
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
        if (!(object instanceof SecurityGroup)) {
            return false;
        }
        SecurityGroup other = (SecurityGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SecurityGroup[ id=" + id + " ]";
    }
    
}
