/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.BulletinBoardFacade;
import entity.BulletinBoard;
import entity.UserData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.*;


/**
 *
 * @author st20153208
 */
@Named(value = "bb")
//@SessionScoped
// implements Serializable
@RequestScoped
public class BoardBean{
    
    private String threadId;
    private String title;
    private String deleteKey;
    private UserData ud;
    private String userId;
    private List<BulletinBoard> list;
    private BulletinBoard resList;
    
    @EJB
    BulletinBoardFacade db;
    public String next(){
        create();
        return null;
    }
    
    public void create(){
        Date d = new Date();
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String postDate = d1.format(d);
        try {
            d = d1.parse(postDate);
        } catch (ParseException ex) {
            Logger.getLogger(BoardBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        UserData uData = new UserData();
        uData.setUserId(userId);
        BulletinBoard bubo = new BulletinBoard(threadId,title,deleteKey,d,uData);
        try{
            db.create(bubo);
            clear();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public void clear(){
            threadId = null;
            title = null;
            deleteKey = null;
            userId = null;
        }
    
    
    public List<BulletinBoard> getAllBulletinBoard(){
    return db.findAll();
}
    
    public String detail(BulletinBoard bb){
        resList = db.finddetail(bb.getThreadId());
        return "threadcreate_1.xhtml";
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

    public List<BulletinBoard> getList() {
        return list;
    }

    public void setList(List<BulletinBoard> list) {
        this.list = list;
    }

    public UserData getUd() {
        return ud;
    }

    public void setUd(UserData ud) {
        this.ud=ud;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
