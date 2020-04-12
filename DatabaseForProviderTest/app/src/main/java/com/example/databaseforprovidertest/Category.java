package com.example.databaseforprovidertest;

import org.litepal.crud.LitePalSupport;

public class Category extends LitePalSupport {
    private int id;

    private String name;

    private int categoryCode;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCategoryCode(int categoryCode){
        this.categoryCode = categoryCode;
    }

    public int getCategoryCode(){
        return categoryCode;
    }
}
