package com.wuyuxi.hxci_service.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.wuyuxi.hxci_service.R;
import com.wuyuxi.hxci_service.adapter.Tiaowen_ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class TiaowenActivity extends AppCompatActivity {
    private ListView listView_taiowen;
    private String[] tiaowen_date=new String[]{"高可心","吴雨奚","黄平"};
    private String[] tiaowen_neirong=new String[]{"2018-7-1","2018-7-1","2018-7-1"};
    private String[] tiaowen_zhuangtai=new String[]{"已完成","已完成","处理中"};
    private ArrayList<HashMap<String,String>> list;
    private Tiaowen_ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiaowen);
        listView_taiowen=findViewById(R.id.tiaowen_listview);
        getDate();
        listViewAdapter=new Tiaowen_ListViewAdapter(this,list);
        listView_taiowen.setAdapter(listViewAdapter);
    }
    public void getDate() {
        list = new ArrayList<>();
        for (int i = 0; i < tiaowen_date.length; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("tiaowen_date", tiaowen_date[i]);
            map.put("tiaowen_neirong", tiaowen_neirong[i]);
            map.put("tiaowen_zhuangtai", tiaowen_zhuangtai[i]);
            list.add(map);
        }
    }
}