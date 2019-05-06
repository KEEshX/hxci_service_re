package com.wuyuxi.hxci_service.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wuyuxi.hxci_service.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Tiaowen_ListViewAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<HashMap<String,String>> list;
    public Tiaowen_ListViewAdapter(Context context, ArrayList<HashMap<String,String>> list){
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
            view=View.inflate(context, R.layout.taiowenlist_item,null);
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
        holder.tiaowen_date.setText(list.get(position).get("tiaowen_date"));
        //设置通知所对应的日期
        holder.tiaowen_neirong.setText(list.get(position).get("tiaowen_neirong"));
        holder.tiaowen_zhuangtai.setText(list.get(position).get("tiaowen_zhuangtai"));
        return view;
    }
    /*
     * 内部类主要用于获取listview中子布局的id
     *
     * */
    class TestViewHolder{
        public TextView tiaowen_date;
        public TextView tiaowen_neirong;
        public TextView tiaowen_zhuangtai;
        public TestViewHolder(View view){
            tiaowen_date=view.findViewById(R.id.tiaowen_date);
            tiaowen_neirong=view.findViewById(R.id.tiaowen_neirong);
            tiaowen_zhuangtai=view.findViewById(R.id.tiaowen_zhuangtai);
        }
    }
}
