package com.ts.mybatis01.dao;

import com.ts.mybatis01.bean.Message;
import com.ts.mybatis01.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class MessageDAO {
    DBAccess dBaccess = new DBAccess();

    public List<Message> queryMessageList(Message message) {
        SqlSession sqlSession = null;
        List<Message> messageList =null;
        try {
            sqlSession = dBaccess.getSqlSession();
            //第一个参数，"Message.queryMessageList"为MessageMapper.xml中sql语句的namespa.id
            messageList = sqlSession.selectList("Message.queryMessageList", message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return messageList;
    }
    //测试
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

    public void deleteById(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dBaccess.getSqlSession();
            sqlSession.delete("Message.delete",id);
            sqlSession.commit();//提交  添加修改删除需要提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }
    public void deleteByListId(List list) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dBaccess.getSqlSession();
            sqlSession.delete("Message.deleteBatch",list);
            sqlSession.commit();//提交  添加修改删除需要提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }
}
