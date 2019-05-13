package com.ts.mybatis01.bean;

public class CommandContent {
     private Integer id;
     private Integer command_id;
     private String content;
     private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Integer command_id) {
        this.command_id = command_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommandContent{" +
                "id=" + id +
                ", command_id=" + command_id +
                ", content='" + content + '\'' +
                ", command=" + command +
                '}';
    }
}
