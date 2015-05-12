package task5;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/8/15.
 */
public class ElementsRemover implements Runnable{
  TimeOutHashTable demo;
  private final int i;

  public ElementsRemover(TimeOutHashTable demo,int i) {
    this.demo = demo;
    this.i = i;
  }

  @Override
  public void run() {
    while(!Thread.currentThread().isInterrupted()){
 /*    for(Map.Entry<String,TimeOut> entry: demo.table.entrySet()){
        if((System.currentTimeMillis()-(entry.getValue()).lastUsed)>=i*1000){
          System.out.println(entry.getKey()+" is removed!");*/
          //arrayList.add(entry.getKey());
        //}
     //}
    /*  Iterator<String> iter=arrayList.iterator();
      while(iter.hasNext()){
        String s=iter.toString();
        demo.remove(s);
      }*/
       //demo.remove(entry.getKey());
       for(Enumeration<String> en=demo.table.keys();en.hasMoreElements();){
         if(en==null){
           break;
         }
        String key=en.nextElement();
         if((System.currentTimeMillis()-(demo.table.get(key)).lastUsed)>=i*1000){
           System.out.println(demo.table.get(key).value+" is removed!");
           demo.remove(key);
       }
     }/*
    /*      try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            System.out.println("This is interruption!");
            return;
          }*/

    }
    }
  }

