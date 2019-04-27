package com.wuyuxi.hxci_service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.wuyuxi.hxci_service.adapter.Shouye_ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class xinXiFaBuActivity extends AppCompatActivity {
    private Shouye_ListViewAdapter listViewAdapter;
    private ListView listView;
    private ArrayList<HashMap<String,String>> list;
    private String[] tongzhi=new String[]{"通        知","问卷调查","投        诉","投        诉","建        议","通        知","投        诉","投        诉","建        议","通        知"};
    private String[] content=new String[]{"关于教学楼开放时间调整的通知",
            "饮食中心商品质量与价格调整调整问题（有奖）",
            "2号学生公寓211寝室温度低",
            "2号学生公寓323寝室温度低",
            "教学楼投影","关于水箱清理的通知",
            "2号学生公寓211寝室温度低",
            "2号学生公寓323寝室温度低",
            "教学楼投影","关于水箱清理的通知"};
    private String[] date=new String[]{"3-13","3-14","3-14","3-15","3-15","3-16","3-14","3-15","3-15","3-16"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xin_xi_fa_bu);
        listView=findViewById(R.id.xinxifabu_listview);
        list=new ArrayList<>();
        for(int i=0;i<tongzhi.length;i++){
            HashMap<String,String> map=new HashMap<String,String>();
            map.put("tongzhi",tongzhi[i]);
            map.put("content",content[i]);
            map.put("date",date[i]);
            list.add(map);
        }
        listViewAdapter=new Shouye_ListViewAdapter(xinXiFaBuActivity.this,list);
        listView.setAdapter(listViewAdapter);
    }
}
