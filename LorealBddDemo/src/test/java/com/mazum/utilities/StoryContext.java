package com.mazum.utilities;

import java.util.HashMap;


public class StoryContext {

    private static HashMap<String,Object> variables ;
    private static StoryContext context;
    private StoryContext(){

    }

    public static  synchronized StoryContext getContext(){
        if(context==null){
            context = new StoryContext();
            context.variables= new HashMap<String, Object>();
        }
        return context;
    }

    public HashMap<String, Object> getMap(){
        return variables;
    }
}
