package com.wuyuxi.hxci_service.login;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedInfo {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Context context;
    private static final String name="SP";

    public SharedInfo(Context context) {
        this.context = context;
        //
        sp=context.getSharedPreferences(name,0);
        editor=sp.edit();
    }
    //是否是第一次
    public void first(boolean isFirstTime){
        editor.putBoolean("one",isFirstTime);
        editor.commit();
    }
    //是第几次进入
    public boolean isFirst(){
        return sp.getBoolean("one",true);
    }
}