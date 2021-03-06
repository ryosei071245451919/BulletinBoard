/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.BulletinBoard;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author st20153208
 */
@Stateless
public class BulletinBoardFacade extends AbstractFacade<BulletinBoard> {

    @PersistenceContext(unitName = "board2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BulletinBoardFacade() {
        super(BulletinBoard.class);
    }
    
    public BulletinBoard finddetail(String threadId){
        TypedQuery<BulletinBoard> query = em.createNamedQuery("BulletinBoard.findByThreadId",BulletinBoard.class).setParameter("threadId", threadId);
        return query.getSingleResult();
    }
    
}
