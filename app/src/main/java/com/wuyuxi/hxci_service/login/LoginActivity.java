package com.wuyuxi.hxci_service.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wuyuxi.hxci_service.MainActivity;
import com.wuyuxi.hxci_service.R;
import com.wuyuxi.hxci_service.fragment.ForgetActivity;
import com.wuyuxi.hxci_service.huanYingYeActivity;

public class LoginActivity extends AppCompatActivity {
    private TextView username,password,back;
    private Button btn_login,forget;
    SharedInfo sharedInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btn_login=findViewById(R.id.btn_login);
        back=findViewById(R.id.back);
        forget=findViewById(R.id.forget);
        sharedInfo=new SharedInfo(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(back.isClickable()){
                    Intent intent=new Intent(LoginActivity.this,huanYingYeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(forget.isClickable()){
                    Intent intent=new Intent(LoginActivity.this,ForgetActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=username.getText().toString();
                String userPassword=password.getText().toString();
                if("admin".equals(userName)&&"000000".equals(userPassword)){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    AlertDialog dialog=new AlertDialog.Builder(LoginActivity.this).create();
                    dialog.setMessage("用户名或密码错误");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent=new Intent(LoginActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    dialog.show();
                }
            }
        });
    }

}
