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
 * @author st20153208
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findByDepartmentId", query = "SELECT d FROM Department d WHERE d.departmentId = :departmentId")
    , @NamedQuery(name = "Department.findByDepartmentName", query = "SELECT d FROM Department d WHERE d.departmentName = :departmentName")
    , @NamedQuery(name = "Department.findByDepartmentCode", query = "SELECT d FROM Department d WHERE d.departmentCode = :departmentCode")
    , @NamedQuery(name = "Department.findByClass1", query = "SELECT d FROM Department d WHERE d.class1 = :class1")
    , @NamedQuery(name = "Department.findByYears", query = "SELECT d FROM Department d WHERE d.years = :years")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "department_id")
    private String departmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "department_name")
    private String departmentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "department_code")
    private Character departmentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "class")
    private String class1;
    @Column(name = "years")
    private Integer years;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private Collection<User> userCollection;

    public Department() {
    }

    public Department(String departmentId) {
        this.departmentId = departmentId;
    }

    public Department(String departmentId, String departmentName, Character departmentCode, String class1) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.class1 = class1;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Character getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Character departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Department[ departmentId=" + departmentId + " ]";
    }
    
}
