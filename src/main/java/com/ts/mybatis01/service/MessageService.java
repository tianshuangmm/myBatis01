package com.ts.mybatis01.service;

import com.ts.mybatis01.bean.Message;
import com.ts.mybatis01.dao.MessageDAO;

import java.util.List;

public class MessageService {

    public List<Message> queryMessageList(Message message) {
        //调用数据访问层方法并处理业务逻辑
        MessageDAO messageDAO = new MessageDAO();
        List<Message>  messageList = messageDAO.queryMessageList(message);
        return messageList;
    }
}
