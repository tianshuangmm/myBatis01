package com.ts.mybatis01.dao;

import com.ts.mybatis01.bean.Message;
import com.ts.mybatis01.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MessageDAO {
    public List<Message> queryMessageList(Message message) {
        DBAccess dBaccess = new DBAccess();
        SqlSession sqlSession = dBaccess.getSqlSession();
        //第一个参数，"Message.queryMessageList"为MessageMapper.xml中sql语句的namespa.id
        List<Message> messageList = sqlSession.selectList("Message.queryMessageList", message);
        return messageList;
    }
    public static void main(String[] args) {
        MessageDAO messageDAO = new MessageDAO();
        Message message = new Message();
        List<Message> messageList =messageDAO.queryMessageList(message);
        if(messageList!=null&&messageList.size()>0){
            for (int i = 0; i <messageList.size() ; i++) {
                System.out.println(messageList.get(i));
            }
        }

    }
}
