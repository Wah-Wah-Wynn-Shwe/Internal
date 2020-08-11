package com.example.internal;

public class Contact {
    public String name;
    public String phone;

    public Contact(String n,String p){
        super();
        name=n;
        phone=p;

    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPhone(){
        return phone;

    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String toString(){
        return name+"\n"+phone;

    }
}
