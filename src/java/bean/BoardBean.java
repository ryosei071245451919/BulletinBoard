/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.BulletinBoardFacade;
import ejb.ResponseFacade;
import entity.BulletinBoard;
import entity.Response;
import entity.ResponsePK;
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
    private BulletinBoard td;
    private String comment;
    private List<Response> resList;
    private String responsId;
    
    @EJB
    BulletinBoardFacade db;
    @EJB
    ResponseFacade rf;
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
    
    
    public String next2(){
        create2();
        return null;
    }
    
    public void create2(){
        Date d = new Date();
        Date d2 = new Date();
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         SimpleDateFormat d3 = new SimpleDateFormat("dHms");
        String postDate = d1.format(d);
        String postDate2 = d3.format(d);
        try {
            d = d1.parse(postDate);
            d2 = d3.parse(postDate2);
            System.out.println("d : "+d);
            System.out.println("d2 : "+d2);
        } catch (ParseException ex) {
            Logger.getLogger(BoardBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        UserData uData = new UserData();
        uData.setUserId(userId);
        Response res = new Response();
        ResponsePK resPK = new ResponsePK();
        resPK.setThreadId("thr"+d2);
        resPK.setResponseId("res"+d2);
        res.setResponsePK(resPK);
        res.setComment(comment);
        res.setPostDate(d);
        res.setUserId(uData);
        try{
            rf.create(res);
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
            comment = null;
        }
    
    
    public List<BulletinBoard> getAllBulletinBoard(){
        return db.findAll();
}

    public List<Response> getAllResponse(String threadId){
        return rf.findByThreadId(threadId);
}
    
    public String detail(BulletinBoard bb){
        td = db.finddetail(bb.getThreadId());
        resList = getAllResponse(bb.getThreadId());
        return "threaddetails.xhtml";
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

    public BulletinBoard getTd() {
        return td;
    }

    public void setTd(BulletinBoard td) {
        this.td = td;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Response> getResList() {
        return resList;
    }

    public void setResList(List<Response> resList) {
        this.resList = resList;
    }



    public String getResponsId() {
        return responsId;
    }

    public void setResponsId(String responsId) {
        this.responsId = responsId;
    }
    
    
    
    
}
