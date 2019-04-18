package com.wuyuxi.hxci_service.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wuyuxi.hxci_service.R;

public class gongNengFragment extends Fragment {
    private TextView w_gongzuotai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.gn_gongren_layout, container, false);
        w_gongzuotai=view.findViewById(R.id.w_gongzuotai);

        return view;
    }
}
