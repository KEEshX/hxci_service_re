package com.wuyuxi.hxci_service.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wuyuxi.hxci_service.R;
import com.wuyuxi.hxci_service.activity.Student_Baoxiu_Activity;
import com.wuyuxi.hxci_service.adapter.Shouye_ListViewAdapter;
import com.wuyuxi.hxci_service.adapter.ViewPageAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class shouYeFragment extends Fragment {
    private ViewPager viewPager;
    private ViewPageAdapter adapter;
    private Shouye_ListViewAdapter listViewAdapter;
    private ListView listView;
    private ImageView imageView;
    private TextView student_baoxiu;
    private TextView student_tiaowen;
    private TextView student_gonggao;
    private TextView student_gengduo;
    private int a=1;
    private Handler handler = new Handler();
    private int[] images = {
            R.drawable.shouye_top01, R.drawable.shouye_top02, R.drawable.shouye_top03
    };
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
    private int index;
    private MyRunnable myRunnable = new MyRunnable();
    private TextView baoxiu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=null;
        if(a==1) {
            view = inflater.inflate(R.layout.studentshouye_fragment, container, false);
            imageView=view.findViewById(R.id.img);
            listView=view.findViewById(R.id.shouye_listview);
            student_baoxiu=view.findViewById(R.id.student_baoxiu);
            student_tiaowen=view.findViewById(R.id.student_tiaowen);
            student_gonggao=view.findViewById(R.id.student_gonggao);
            student_gengduo=view.findViewById(R.id.student_gengduo);
            student_baoxiu.setOnClickListener(new TextViewListener());
            student_tiaowen.setOnClickListener(new TextViewListener());
            student_gonggao.setOnClickListener(new TextViewListener());
            student_gengduo.setOnClickListener(new TextViewListener());
            handler.post(myRunnable);
            getDate();
            listViewAdapter=new Shouye_ListViewAdapter(getContext(),list);
            listView.setAdapter(listViewAdapter);
        }
        if(a==2){
            view = inflater.inflate(R.layout.teachershouye_fragment, container, false);
            imageView=view.findViewById(R.id.img);
            listView=view.findViewById(R.id.shouye_listview);
            handler.post(myRunnable);
            getDate();
            listViewAdapter=new Shouye_ListViewAdapter(getContext(),list);
            listView.setAdapter(listViewAdapter);
        }
        if(a==3){
            view = inflater.inflate(R.layout.weixiushouye_fragment, container, false);
            imageView=view.findViewById(R.id.img);
            listView=view.findViewById(R.id.shouye_listview);
            handler.post(myRunnable);
            getDate();
            listViewAdapter=new Shouye_ListViewAdapter(getContext(),list);
            listView.setAdapter(listViewAdapter);
        }
        return view;
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
    //实现图片轮播
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            index++;
            index = index % 3;
            imageView.setImageResource(images[index]);
            handler.postDelayed(myRunnable, 2 * 2000);
        }
    }
    class TextViewListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.student_baoxiu:
                    Intent intent=new Intent(getContext(),Student_Baoxiu_Activity.class);
                    startActivity(intent);
                    break;
                case R.id.student_tiaowen:
                    Toast.makeText(getContext(),"调温添加了监听",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.student_gonggao:
                    Toast.makeText(getContext(),"公告添加了监听",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.student_gengduo:
                    Toast.makeText(getContext(),"更多添加了监听",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }
}
