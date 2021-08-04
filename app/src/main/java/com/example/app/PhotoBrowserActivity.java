package com.example.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoBrowserActivity extends Activity {
    private ImageView xstp;
    private EditText xdz;
    private Button liulan;
    public static final int SHOWIMAGE=1;
    public static final int SHOWFAIL=0;
    private Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case SHOWIMAGE:
                    Bitmap bitmap=(Bitmap) msg.obj;
                    xstp.setImageBitmap(bitmap);
                    break;


                case SHOWFAIL:
//                    xstp.setImageResource(R.drawable.button_bg);
                    Toast.makeText(PhotoBrowserActivity.this, "显示图片失败", Toast.LENGTH_LONG).show();
                    break;


                default:
                    break;
            }
        };
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        xstp=(ImageView) findViewById(R.id.ivImage);
//        xdz=(EditText) findViewById(R.id.etdizhi);
//        xstp.setImageResource(R.drawable.button_bg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void star(View view){
        final String imageUrl=xdz.getText().toString();
        if(TextUtils.isEmpty(imageUrl)){
            Toast.makeText(this, "图片路径不能为空", Toast.LENGTH_LONG).show();
        }else{
            new Thread(){
                public void run() {
                    try {
                        URL url=new URL(imageUrl);
                        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(5000);
                        int responseCode=httpURLConnection.getResponseCode();
                        if(responseCode==200){
                            InputStream inputStream=httpURLConnection.getInputStream();
                            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                            Message message=new Message();
                            message.what=SHOWIMAGE;
                            message.obj=bitmap;
                            //ivImage.setImageBitmap(bitmap);
                            handler.sendMessage(message);
                        }else{
                            Message message=new Message();
                            message.what=SHOWFAIL;
                            handler.sendMessage(message);
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
