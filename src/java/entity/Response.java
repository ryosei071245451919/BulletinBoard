/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author st20153208
 */
@Entity
@Table(name = "response")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Response.findAll", query = "SELECT r FROM Response r")
    , @NamedQuery(name = "Response.findByThreadId", query = "SELECT r FROM Response r WHERE r.responsePK.threadId = :threadId")
    , @NamedQuery(name = "Response.findByResponseId", query = "SELECT r FROM Response r WHERE r.responsePK.responseId = :responseId")
    , @NamedQuery(name = "Response.findByComment", query = "SELECT r FROM Response r WHERE r.comment = :comment")
    , @NamedQuery(name = "Response.findByPostDate", query = "SELECT r FROM Response r WHERE r.postDate = :postDate")})
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResponsePK responsePK;
    @Size(max = 800)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;

    public Response() {
    }

    public Response(ResponsePK responsePK) {
        this.responsePK = responsePK;
    }

    public Response(ResponsePK responsePK, Date postDate) {
        this.responsePK = responsePK;
        this.postDate = postDate;
    }

    public Response(String threadId, String responseId) {
        this.responsePK = new ResponsePK(threadId, responseId);
    }

    public Response(String comment, Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResponsePK getResponsePK() {
        return responsePK;
    }

    public void setResponsePK(ResponsePK responsePK) {
        this.responsePK = responsePK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsePK != null ? responsePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Response)) {
            return false;
        }
        Response other = (Response) object;
        if ((this.responsePK == null && other.responsePK != null) || (this.responsePK != null && !this.responsePK.equals(other.responsePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Response[ responsePK=" + responsePK + " ]";
    }
    
}
