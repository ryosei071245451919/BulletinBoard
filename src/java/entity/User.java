/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author st20153208
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByEntranceYear", query = "SELECT u FROM User u WHERE u.entranceYear = :entranceYear")
    , @NamedQuery(name = "User.findByGuraduationYear", query = "SELECT u FROM User u WHERE u.guraduationYear = :guraduationYear")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findByNickname", query = "SELECT u FROM User u WHERE u.nickname = :nickname")
    , @NamedQuery(name = "User.findByUsertype", query = "SELECT u FROM User u WHERE u.usertype = :usertype")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByQanswer", query = "SELECT u FROM User u WHERE u.qanswer = :qanswer")
    , @NamedQuery(name = "User.findByQanswer2", query = "SELECT u FROM User u WHERE u.qanswer2 = :qanswer2")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrance_year")
    @Temporal(TemporalType.DATE)
    private Date entranceYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guraduation_year")
    @Temporal(TemporalType.DATE)
    private Date guraduationYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 40)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usertype")
    private String usertype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "qanswer")
    private String qanswer;
    @Size(max = 100)
    @Column(name = "qanswer2")
    private String qanswer2;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private Department departmentId;
    @JoinColumn(name = "question_id2", referencedColumnName = "question_id")
    @ManyToOne
    private SecretQuestion questionId2;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    @ManyToOne
    private SecretQuestion questionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<BulletinBoard> bulletinBoardCollection;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, Date entranceYear, Date guraduationYear, String name, String usertype, String password) {
        this.userId = userId;
        this.entranceYear = entranceYear;
        this.guraduationYear = guraduationYear;
        this.name = name;
        this.usertype = usertype;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(Date entranceYear) {
        this.entranceYear = entranceYear;
    }

    public Date getGuraduationYear() {
        return guraduationYear;
    }

    public void setGuraduationYear(Date guraduationYear) {
        this.guraduationYear = guraduationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQanswer() {
        return qanswer;
    }

    public void setQanswer(String qanswer) {
        this.qanswer = qanswer;
    }

    public String getQanswer2() {
        return qanswer2;
    }

    public void setQanswer2(String qanswer2) {
        this.qanswer2 = qanswer2;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public SecretQuestion getQuestionId2() {
        return questionId2;
    }

    public void setQuestionId2(SecretQuestion questionId2) {
        this.questionId2 = questionId2;
    }

    public SecretQuestion getQuestionId() {
        return questionId;
    }

    public void setQuestionId(SecretQuestion questionId) {
        this.questionId = questionId;
    }

    @XmlTransient
    public Collection<BulletinBoard> getBulletinBoardCollection() {
        return bulletinBoardCollection;
    }

    public void setBulletinBoardCollection(Collection<BulletinBoard> bulletinBoardCollection) {
        this.bulletinBoardCollection = bulletinBoardCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    
    public String toString() {
        return userId;
    }
    
}
