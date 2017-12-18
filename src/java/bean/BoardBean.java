/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.BulletinBoardFacade;
import entity.BulletinBoard;
import entity.User;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author st20153208
 */
@Named(value = "bb")
@RequestScoped
public class BoardBean {

    private String threadId;
    private String title;
    private String deleteKey;
    private Date postDate;
    private User userId;
    private List<BulletinBoard> list;
    
    @EJB
    BulletinBoardFacade db;
//    transient Logger log;
    public String next(){
        create();
        return null;
    }
    
    public String getBorad(){
    list = db.BoardList();
    return "boardlist.xhtml";
}
    
    public void create(){
        BulletinBoard bubo = new BulletinBoard(threadId,title,deleteKey,postDate,userId);
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
            postDate = null;
            userId = null;
        }
    
    public String findAll(){
        list = db.findAll();
        return "boardlist.xhtml";
    }
    
    public String threadcreate(){
        return "threadcreate.xhtml";
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<BulletinBoard> getList() {
        return list;
    }

    public void setList(List<BulletinBoard> list) {
        this.list = list;
    }
}
