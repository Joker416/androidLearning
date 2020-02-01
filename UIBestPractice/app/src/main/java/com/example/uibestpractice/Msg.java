package com.example.uibestpractice;

public class Msg {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;

    private String content;

    private int type;

    public Msg(int type, String content){
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getContent(){
        return content;
    }
}
