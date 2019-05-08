package com.ts.mybatis01.dao;

import com.ts.mybatis01.bean.Command;
import com.ts.mybatis01.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CommandDAO {
    DBAccess dbAccess = new DBAccess();
    public List<Command> queryCommandList(){
        SqlSession sqlSession = null;
        List<Command> commandList = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            commandList = sqlSession.selectList("Command.queryCommandList");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return commandList;
    }
    public static void main(String[] args) {
        CommandDAO commandDAO = new CommandDAO();
        List<Command> commandList = commandDAO.queryCommandList();
        for (int i = 0; i < commandList.size(); i++) {
            System.out.println(commandList.get(i));
           /* System.out.println(commandList.get(i).getContents());*/

        }

    }
}
