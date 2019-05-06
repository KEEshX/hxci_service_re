package com.wuyuxi.hxci_service;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.wuyuxi.hxci_service.adapter.Baoxiu_ListViewAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Student_Baoxiu_Activity extends AppCompatActivity {
    private ListView baoxiu_listview;
    private String[] baoxiu_date=new String[]{"2018-7-1","2018-7-1","2018-7-1"};
    private String[] baoxiu_neirong=new String[]{"灯管不亮","门锁坏","下水管堵塞"};
    private String[] baoxiu_zhuangtai=new String[]{"已完成","已完成","处理中"};
    private String[] baoxiu_pingjia=new String[]{"8.8","6.6"," "};
    private ArrayList<HashMap<String,String>> list;
    private Baoxiu_ListViewAdapter listViewAdapter;
    private ImageView img1,img2,img3,img4;
    private static final int  REQUEST_SYSTEM_PIC = 1;
    private static final int TAKE_PHOTO=2;
    private Uri imageUri;
    private static int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__baoxiu);
        baoxiu_listview=findViewById(R.id.baoxiu_listview);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img1.setOnClickListener(new ButtonListener());
        img2.setOnClickListener(new ButtonListener());
        img3.setOnClickListener(new ButtonListener());
        img4.setOnClickListener(new ButtonListener());
        getDate();
       listViewAdapter=new Baoxiu_ListViewAdapter(this,list);
       baoxiu_listview.setAdapter(listViewAdapter);
    }
    public void getDate() {
        list = new ArrayList<>();
        for (int i = 0; i < baoxiu_date.length; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("baoxiu_date", baoxiu_date[i]);
            map.put("baoxiu_neirong", baoxiu_neirong[i]);
            map.put("baoxiu_zhuangtai", baoxiu_zhuangtai[i]);
            map.put("baoxiu_pingjia", baoxiu_pingjia[i]);
            list.add(map);
        }
    }
    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img1:
                    a=1;
                    takePhoto(v);
                    break;
                case R.id.img2:
                    a=2;
                    takePhoto(v);break;
                case R.id.img3:
                    a=3;
                    takePhoto(v);break;
                case R.id.img4:
                    a=4;
                    takePhoto(v);break;

        }
    }
    private void takePhoto(View v){
        PopupMenu popupMenu = new PopupMenu(Student_Baoxiu_Activity.this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.take_photo:
                        File outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                        try {
                            if (outputImage.exists()) {
                                outputImage.delete();
                            }
                            outputImage.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //判断版本号
                        if (Build.VERSION.SDK_INT < 24) {
                            imageUri = Uri.fromFile(outputImage);
                        } else {
                            imageUri = FileProvider.getUriForFile(Student_Baoxiu_Activity.this, "com.wuyuxi.hxci_service.fileprovider", outputImage);
                        }
                        // 启动相机程序
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        startActivityForResult(intent, TAKE_PHOTO);
                        break;
                    case R.id.choose_photo:
                        if (ContextCompat.checkSelfPermission(Student_Baoxiu_Activity.this,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(Student_Baoxiu_Activity.this, new
                                    String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                        } else {
                            //打开系统相册
                            openAlbum();
                        }
                        break;
                }
                return true;
            }
        });
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.takephoto_menu, popupMenu.getMenu());
        popupMenu.show();

    }
    }
    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_SYSTEM_PIC);//打开系统相册

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_SYSTEM_PIC && resultCode == RESULT_OK && null != data) {
            if (Build.VERSION.SDK_INT >= 19) {
                handleImageOnKitkat(data);
            } else {
                handleImageBeforeKitkat(data);
            }
        }
        if(requestCode==TAKE_PHOTO){
            try {// 将拍摄的照片显示出来
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                //picture.setImageBitmap(bitmap);
                switch (a){
                    case 1:
                        img1.setImageBitmap(bitmap);
                        break;
                    case 2:
                        img2.setImageBitmap(bitmap);
                        break;
                    case 3:
                        img3.setImageBitmap(bitmap);
                        break;
                    case 4:
                        img4.setImageBitmap(bitmap);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnKitkat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            //如果是document类型的uri，则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content:" +
                        "//downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            //如果是content类型的uri，则使用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            //如果是File类型的uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath);//根据图片路径显示图片

    }
    private void handleImageBeforeKitkat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);

    }
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            //picture.setImageBitmap(bitmap);
                switch (a) {
                    case 1:
                        img1.setImageBitmap(bitmap);
                        break;
                    case 2:
                        img2.setImageBitmap(bitmap);
                        break;
                    case 3:
                        img3.setImageBitmap(bitmap);
                        break;
                    case 4:
                        img4.setImageBitmap(bitmap);
                        break;
                }
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }
}
