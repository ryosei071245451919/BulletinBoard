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
@Table(name = "bulletin_board")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BulletinBoard.findAll", query = "SELECT b FROM BulletinBoard b")
    , @NamedQuery(name = "BulletinBoard.findByThreadId", query = "SELECT b FROM BulletinBoard b WHERE b.threadId = :threadId")
    , @NamedQuery(name = "BulletinBoard.findByTitle", query = "SELECT b FROM BulletinBoard b WHERE b.title = :title")
    , @NamedQuery(name = "BulletinBoard.findByDeleteKey", query = "SELECT b FROM BulletinBoard b WHERE b.deleteKey = :deleteKey")
    , @NamedQuery(name = "BulletinBoard.findByPostDate", query = "SELECT b FROM BulletinBoard b WHERE b.postDate = :postDate")})
public class BulletinBoard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "thread_id")
    private String threadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "delete_key")
    private String deleteKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bulletinBoard")
    private Collection<Response> responseCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserData userId;

    public BulletinBoard() {
    }

    public BulletinBoard(String threadId) {
        this.threadId = threadId;
    }

    public BulletinBoard(String threadId, String title, String deleteKey, Date postDate, Collection<Response> responseCollection, UserData userId) {
        this.threadId = threadId;
        this.title = title;
        this.deleteKey = deleteKey;
        this.postDate = postDate;
        this.responseCollection = responseCollection;
        this.userId = userId;
    }

    public BulletinBoard(String threadId, String title, String deleteKey, Date postDate, UserData userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeleteKey() {
        return deleteKey;
    }

    public void setDeleteKey(String deleteKey) {
        this.deleteKey = deleteKey;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @XmlTransient
    public Collection<Response> getResponseCollection() {
        return responseCollection;
    }

    public void setResponseCollection(Collection<Response> responseCollection) {
        this.responseCollection = responseCollection;
    }

    public UserData getUserId() {
        return userId;
    }

    public void setUserId(UserData userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (threadId != null ? threadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BulletinBoard)) {
            return false;
        }
        BulletinBoard other = (BulletinBoard) object;
        if ((this.threadId == null && other.threadId != null) || (this.threadId != null && !this.threadId.equals(other.threadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BulletinBoard[ threadId=" + threadId + " ]";
    }
    
}
