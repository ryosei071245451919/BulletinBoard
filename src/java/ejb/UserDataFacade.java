/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.UserData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author st20153208
 */
@Stateless
public class UserDataFacade extends AbstractFacade<UserData> {

    @PersistenceContext(unitName = "board2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDataFacade() {
        super(UserData.class);
    }
    
}
