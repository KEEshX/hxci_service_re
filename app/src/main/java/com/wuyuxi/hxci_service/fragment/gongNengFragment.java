package com.wuyuxi.hxci_service.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wuyuxi.hxci_service.MainActivity;
import com.wuyuxi.hxci_service.R;
import com.wuyuxi.hxci_service.activity.studentTouSuActivity;

public class gongNengFragment extends Fragment {
    private ImageView back;
    private TextView  gongzuotai, baoxiu, tiaowen, gonggao, xinxi, tousu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gn_gongren_layout, container, false);
        back = view.findViewById(R.id.back);
        gongzuotai = view.findViewById(R.id.gongzuotai);
        baoxiu = view.findViewById(R.id.baoxiu);
        tiaowen = view.findViewById(R.id.tiaowen);
        gonggao = view.findViewById(R.id.gonggao);
        xinxi = view.findViewById(R.id.xinxi);
        tousu = view.findViewById(R.id.tousu);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        back.setOnClickListener(new ClickListener());
        gongzuotai.setOnClickListener(new ClickListener());
        baoxiu.setOnClickListener(new ClickListener());
        tiaowen.setOnClickListener(new ClickListener());
        gonggao.setOnClickListener(new ClickListener());
        xinxi.setOnClickListener(new ClickListener());
        tousu.setOnClickListener(new ClickListener());
    }

    private class ClickListener implements View.OnClickListener {
        Intent intent=null;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back:
                    intent=new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    break;
//                    Toast.makeText(getActivity(),"1",Toast.LENGTH_SHORT).show();
                case R.id.gongzuotai:
                    Toast.makeText(getActivity(),"2",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.baoxiu:
                    Toast.makeText(getActivity(),"3",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tiaowen:
                    Toast.makeText(getActivity(),"4",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.gonggao:
                    Toast.makeText(getActivity(),"5",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.xinxi:
                    Toast.makeText(getActivity(),"6",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tousu:
                    Intent intent = new Intent(getActivity(),studentTouSuActivity.class);
                    Toast.makeText(getActivity(),"7",Toast.LENGTH_SHORT).show();
                    break;

            }

        }
    }
}