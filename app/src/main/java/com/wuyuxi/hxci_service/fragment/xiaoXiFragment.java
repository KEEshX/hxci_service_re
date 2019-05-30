package com.wuyuxi.hxci_service.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wuyuxi.hxci_service.MainActivity;
import com.wuyuxi.hxci_service.R;
import com.wuyuxi.hxci_service.adapter.Shouye_ListViewAdapter;
import com.wuyuxi.hxci_service.adapter.Xiaoxi_ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class xiaoXiFragment extends Fragment {
    private TextView more;
    private ListView listView;
    Xiaoxi_ListViewAdapter listViewAdapter;
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.xiaoxi, container, false);
       more=view.findViewById(R.id.more);
       listView=view.findViewById(R.id.xiaoxi_listView);
       more.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(),"more添加了监听",Toast.LENGTH_LONG).show();
           }
       });
       getDate();
        listViewAdapter=new Xiaoxi_ListViewAdapter(getContext(),list);
        listView.setAdapter(listViewAdapter);
        return  view;
    }
    public void getDate(){
        list=new ArrayList<>();
        for(int i=0;i<tongzhi.length;i++){
            HashMap<String,String> map=new HashMap<String,String>();
            map.put("tongzhi",tongzhi[i]);
            map.put("content",content[i]);
            map.put("date",date[i]);
            list.add(map);
        }
    }
    public void back(View view){
        Intent intent=new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }
}
