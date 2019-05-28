package com.wuyuxi.hxci_service.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.wuyuxi.hxci_service.R;

import com.wuyuxi.hxci_service.Xiugaimima;
import com.wuyuxi.hxci_service.login.LoginActivity;
public class woDeFragment extends Fragment {
    private TextView yonghu;
    private Button btntuichu;
    private TextView xiugainima;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.wode, container, false);
        yonghu=view.findViewById(R.id.yonghu);
        btntuichu=view.findViewById(R.id.btntuichu);
        xiugainima=view.findViewById(R.id.xiugai);
        xiugainima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Xiugaimima.class);
                startActivity(intent);
            }
        });
        btntuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }

}
