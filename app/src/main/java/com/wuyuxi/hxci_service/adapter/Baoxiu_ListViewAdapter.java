package com.wuyuxi.hxci_service.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wuyuxi.hxci_service.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Baoxiu_ListViewAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<HashMap<String,String>> list;
    public Baoxiu_ListViewAdapter(Context context, ArrayList<HashMap<String,String>> list){
        this.context=context;
        this.list=list;
    }
    //获取集合数量
    @Override
    public int getCount() {
        return list.size();
    }
    //获取集合的某一项
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    //获取集合的某一项的ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     *获取布局中的内容
     *
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TestViewHolder holder=null;
        View view;//创建一个View视图对象
        if(convertView==null){
            //指定View所对应的布局文件R.layout.users
            view=View.inflate(context, R.layout.baixiulist_item,null);
            //通过构造方法获取users布局的id
            holder=new TestViewHolder(view);
            //将Holder中的id信息存储Tag标志中，以用到下一次调用
            view.setTag(holder);
        }else{
            view=convertView;
            //通过getTag信息读取对应的ID值
            holder=(TestViewHolder) view.getTag();
        }
        //设置通知信息
        holder.baoxiu_date.setText(list.get(position).get("baoxiu_date"));
        //设置通知所对应的内容
        holder.baoxiu_pingjia.setText(list.get(position).get("baoxiu_pingjia"));
        //设置通知所对应的日期
        holder.baoxiu_neirong.setText(list.get(position).get("baoxiu_neirong"));
        holder.baoxiu_zhuangtai.setText(list.get(position).get("baoxiu_zhuangtai"));
        return view;
    }
    /*
     * 内部类主要用于获取listview中子布局的id
     *
     * */
    class TestViewHolder{
        public TextView baoxiu_date;
        public TextView baoxiu_neirong;
        public TextView baoxiu_zhuangtai;
        public TextView baoxiu_pingjia;
        public TestViewHolder(View view){
           baoxiu_date=view.findViewById(R.id.baoxiu_date);
           baoxiu_neirong=view.findViewById(R.id.baoxiu_neirong);
           baoxiu_pingjia=view.findViewById(R.id.baoxiu_pingjia);
           baoxiu_zhuangtai=view.findViewById(R.id.baoxiu_zhuangtai);
        }
    }
}
