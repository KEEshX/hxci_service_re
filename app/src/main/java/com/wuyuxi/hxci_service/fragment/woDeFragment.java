package com.wuyuxi.hxci_service.fragment;

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
public class woDeFragment extends Fragment {
    private TextView yonghu;
    private Button btntuichu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.wode, container, false);
        yonghu=view.findViewById(R.id.yonghu);
        btntuichu=view.findViewById(R.id.btntuichu);
        return view;
    }
}
