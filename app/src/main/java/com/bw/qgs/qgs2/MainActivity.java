package com.bw.qgs.qgs2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.updataname.UpdataActivity;
import com.bw.qgs.qgs2.updataname.UpdatePwdActivity;
import com.bw.qgs.qgs2.url.LogUtil;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.bw.qgs.qgs2.zz.MainPresenter;
import com.bw.qgs.qgs2.zz.MainUser;
import com.bw.qgs.qgs2.zz.MainView;
import com.bw.qgs.qgs2.zz.imageUtil;
import com.google.gson.Gson;

import java.io.File;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final int TAKE_PICTURE = 0;
    private static final int CHOOSE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    private TextView nic, mima, nicheng;
    private ImageView touxiang;
    private PopupWindow pop;
    private Uri tempUri;
    private Bitmap mBitmap;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nic = findViewById(R.id.nicheng);
        mima = findViewById(R.id.mima);
        touxiang = findViewById(R.id.touxiang);
        nicheng = findViewById(R.id.nicheng);
        mMainPresenter = new MainPresenter(this);
        Intent intent = getIntent();
        String sistem = intent.getStringExtra("sistem");
        nic.setText(sistem);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String pwd = sp.getString("pwd", "");
        String headPic = sp.getString("headPic", "");
        Uri uri = Uri.parse(headPic);
        touxiang.setImageURI(uri);
        String nickName = sp.getString("nickName", "");
        nicheng.setText(nickName);
        mima.setText(pwd);
        nicheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdataActivity.class);
                intent.getStringExtra("name");
                startActivity(intent);
                finish();
            }
        });
        mima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdatePwdActivity.class);
                startActivity(intent);
                finish();
            }
        });
        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*View popView = View.inflate(MainActivity.this, R.layout.pop_tou, null);
                pop = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                pop.showAsDropDown(v, 0, 200);*/
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("添加图片");
                String[] items = {"选择本地照片", "拍照"};
                builder.setNegativeButton("取消", null);
                builder.setItems(items, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case TAKE_PICTURE: //  选择本地照片
                                Intent openAlbumIntent = new Intent(
                                        Intent.ACTION_GET_CONTENT);
                                openAlbumIntent.setType("image/*");
                                startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                                //setImageToView(openAlbumIntent);
                                break;
                            /*case CHOOSE_PICTURE:
                                *//*Intent openCameraIntent = new Intent(
                                        MediaStore.ACTION_IMAGE_CAPTURE);
                                tempUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "temp_image.jpg"));
                                openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                                startActivityForResult(openCameraIntent, TAKE_PICTURE);
                                setImageToView(openCameraIntent);*//*
                                break;*/
                        }
                    }
                });
                builder.show();
            }
        });
    }

    float x1, x2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            x2 = event.getX();
            if (x2 - x1 > 200) {
                finish();
            }
        }
        /*if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            if (x2 - x1 > 100) {
                finish();
            }
        }*/
        return super.onTouchEvent(event);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE:
                    //cutImage(tempUri);
                    break;
                case CHOOSE_PICTURE:
                    setImageToView(data);
                    if (data != null) {
                        Uri uri = data.getData();
                        touxiang.setImageURI(uri);
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                        touxiang.setImageBitmap(bitmap);
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            mBitmap = extras.getParcelable("data");
            touxiang.setImageBitmap(mBitmap);
            uploadPic(mBitmap);
        }
    }

    private void uploadPic(Bitmap bitmap) {
        String imagePath = imageUtil.savePhoto(bitmap, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath + "");
        if (imagePath != null) {
            File file = new File(imagePath);
            mMainPresenter.gettou(UrlUtil.HEAD, file);//这里是P层把图片上传到服务器。
        }
    }

    @Override
    public void onTouSuccess(String result) {
        Gson gson = new Gson();
        MainUser mainUser = gson.fromJson(result, MainUser.class);
        String message = mainUser.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        LogUtil.e("111"+message);
    }

    @Override
    public void onTouFailer(String msg) {

    }
}
