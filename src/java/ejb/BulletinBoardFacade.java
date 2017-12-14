/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.BulletinBoard;
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
    
    public List<BulletinBoard> BoardList(){
    TypedQuery<BulletinBoard> query = em.createNamedQuery("BulletinBoard.findByPostData", BulletinBoard.class);
    query.setFirstResult(0);
    query.setMaxResults(100);
    return query.getResultList();
}

    public void create(Thread thre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
