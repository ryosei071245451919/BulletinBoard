/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.BulletinBoard;
import entity.Response;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author st20153208
 */
@Stateless
public class ResponseFacade extends AbstractFacade<Response> {

    @PersistenceContext(unitName = "board2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponseFacade() {
        super(Response.class);
    }
    
    public List<Response> findByThreadId(String threadId){
        TypedQuery<Response> query = em.createNamedQuery("Response.findByThreadId",Response.class).setParameter("threadId", threadId);
        query.setFirstResult(0);
        query.setMaxResults(100);
        return query.getResultList();
    }
    
}
