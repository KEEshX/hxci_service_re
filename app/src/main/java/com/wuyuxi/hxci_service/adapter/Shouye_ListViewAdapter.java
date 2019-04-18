package com.wuyuxi.hxci_service.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wuyuxi.hxci_service.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Shouye_ListViewAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<HashMap<String,String>> list;
    public Shouye_ListViewAdapter(Context context, ArrayList<HashMap<String,String>> list){
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
            view=View.inflate(context, R.layout.shouyelist_item,null);
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
        holder.item_tongzhi.setText(list.get(position).get("tongzhi"));
        //设置通知所对应的内容
        holder.item_content.setText(list.get(position).get("content"));
        //设置通知所对应的日期
        holder.item_date.setText(list.get(position).get("date"));
        return view;
    }
    /*
     * 内部类主要用于获取listview中子布局的id
     *
     * */
    class TestViewHolder{
        public TextView item_tongzhi;
        public TextView item_content;
        public TextView item_date;
        public TestViewHolder(View view){
            item_tongzhi=view.findViewById(R.id.item_tongzhi);
            item_content=view.findViewById(R.id.item_content);
            item_date=view.findViewById(R.id.item_date);
        }
    }
}
