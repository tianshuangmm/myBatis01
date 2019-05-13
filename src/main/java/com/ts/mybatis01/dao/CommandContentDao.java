package com.ts.mybatis01.dao;

import com.ts.mybatis01.bean.CommandContent;
import com.ts.mybatis01.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CommandContentDao {
    public List<CommandContent> getCommandContent(){
        DBAccess dbAccess =new DBAccess();
        SqlSession sqlSession = null;
        List<CommandContent> objects =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            objects = sqlSession.selectList("CommandContent.queryCommandContent");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return objects;
    }
    public static void main(String[] args) {
        CommandContentDao commandContentDao = new CommandContentDao();
        List<CommandContent> commandContent = commandContentDao.getCommandContent();
        if(commandContent!=null&&commandContent.size()>0){
            for (int i = 0; i < commandContent.size(); i++) {
                System.out.println(commandContent.get(i));
            }
        }
    }
}
