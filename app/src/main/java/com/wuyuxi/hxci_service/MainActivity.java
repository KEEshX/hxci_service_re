package com.wuyuxi.hxci_service;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wuyuxi.hxci_service.fragment.gongNengFragment;
import com.wuyuxi.hxci_service.fragment.shouYeFragment;
import com.wuyuxi.hxci_service.fragment.woDeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mshouYe;
    private TextView mgongNeng;
    private TextView mxiaoXi;
    private TextView mwoDe;

    private Fragment shouYeFragment;
    private Fragment gongNengFragment;
    private Fragment xiaoXiFragment;
    private Fragment woDeFragment;

    private int fragmentId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (savedInstanceState == null) {
            setFragment(0);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("fragment_id", fragmentId);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        shouYeFragment = fragmentManager.findFragmentByTag("shouYeFragment");
        gongNengFragment = fragmentManager.findFragmentByTag("gongNengFragment");
        xiaoXiFragment = fragmentManager.findFragmentByTag("xiaoXiFragment");
        woDeFragment = fragmentManager.findFragmentByTag("woDeFragment");

        setFragment(savedInstanceState.getInt("fragment_id"));

    }

    private void setFragment(int i) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);

        switch (i) {
            case 0:
                mshouYe.setTextColor(getResources()
                        .getColor(R.color.colorPrimary));
                mshouYe.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.drawable.ic_shouye_pressed, 0, 0);

                if (shouYeFragment == null) {
                    shouYeFragment = new shouYeFragment();
                    transaction.add(R.id.container, shouYeFragment,
                            "shouYeFragment");
                } else {
                    transaction.show(shouYeFragment);
                }
                break;
            case 1:
                mgongNeng.setTextColor(getResources()
                        .getColor(R.color.colorPrimary));
                mgongNeng.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.drawable.ic_gongneng_pressed, 0, 0);
                if (gongNengFragment == null) {
                    gongNengFragment = new gongNengFragment();
                    transaction.add(R.id.container, gongNengFragment,
                            "gongNengFragment");
                } else {
                    transaction.show(gongNengFragment);
                }
                break;
            case 2:
                mxiaoXi.setTextColor(getResources()
                        .getColor(R.color.colorPrimary));
                mxiaoXi.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.drawable.ic_xiaoxi_pressed, 0, 0);

                if (xiaoXiFragment == null) {
                    xiaoXiFragment = new shouYeFragment();
                    transaction.add(R.id.container, xiaoXiFragment,
                            "xiaoXiFragment");
                } else {
                    transaction.show(xiaoXiFragment);
                }
                break;
            case 3:
                mwoDe.setTextColor(getResources()
                        .getColor(R.color.colorPrimary));
                mwoDe.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.drawable.ic_wode_pressed, 0, 0);
                if (woDeFragment == null) {
                    woDeFragment = new woDeFragment();
                    transaction.add(R.id.container, woDeFragment,
                            "woDeFragment");
                } else {
                    transaction.show(woDeFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (shouYeFragment != null) {
            transaction.hide(shouYeFragment);
            mshouYe.setTextColor(getResources()
                    .getColor(R.color.textPrimary));
            mshouYe.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.drawable.ic_shouye, 0, 0);
        }
        if (gongNengFragment != null) {
            transaction.hide(gongNengFragment);
            mgongNeng.setTextColor(getResources()
                    .getColor(R.color.textPrimary));
            mgongNeng.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.drawable.ic_gongneng, 0, 0);
        }
        if (xiaoXiFragment != null) {
            transaction.hide(xiaoXiFragment);
            mxiaoXi.setTextColor(getResources()
                    .getColor(R.color.textPrimary));
            mxiaoXi.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.drawable.ic_xiaoxi, 0, 0);
        }
        if (woDeFragment != null) {
            transaction.hide(woDeFragment);
            mwoDe.setTextColor(getResources()
                    .getColor(R.color.textPrimary));
            mwoDe.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.drawable.ic_wode, 0, 0);
        }

    }


    private void init() {
        mshouYe = findViewById(R.id.shouYe);
        mgongNeng = findViewById(R.id.gongNeng);
        mxiaoXi = findViewById(R.id.xiaoXi);
        mwoDe = findViewById(R.id.woDe);

        mshouYe.setOnClickListener(this);
        mgongNeng.setOnClickListener(this);
        mxiaoXi.setOnClickListener(this);
        mwoDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouYe:
                setFragment(0);
                break;
            case R.id.gongNeng:
                setFragment(1);
                break;
            case R.id.xiaoXi:
                setFragment(2);
                break;
            case R.id.woDe:
                setFragment(3);
                break;
            default:
                break;
        }
    }
}
