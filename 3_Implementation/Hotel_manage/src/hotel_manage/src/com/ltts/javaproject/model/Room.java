package com.ltts.javaproject.model;


public class Room {

    private String mainName;

    public Room() {
        mainName = "e";
    }

 
    public void setName(String aName) {
        mainName = aName;
    }

  
    public String getName() {
        return mainName;
    }
    final void run(){System.out.println("Quiting.............");}

    
}
