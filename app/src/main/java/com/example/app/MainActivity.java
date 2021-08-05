package com.example.app;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.booter.StudentAidl;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.TimerTask;


public class MainActivity extends Activity implements View.OnClickListener {

    private WebView mWebView;
    private Button mButton;
    private Button mBtnLogon;
    private Button mButton2;
    private EditText mEditText;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private MyWebViewClient mMyWebViewClient;
    private Button mButton3;
    private Button mBtnNext;
    private Button mBtnBack;
    private boolean mShowFlag = true;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.activity_main_webview);
        mWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mButton = findViewById(R.id.button);
        mBtnLogon = findViewById(R.id.btn_logon);
        mBtnLogon.setOnClickListener(this);

        mButton.setOnClickListener(this);
        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(this);

        mButton3 = findViewById(R.id.button3);
        mButton3.setOnClickListener(this);

        mBtnNext = findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(this);

        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(this);

        mEditText = findViewById(R.id.editText);


        // REMOTE RESOURCE
         mWebView.loadUrl("https://m.weibo.cn");
//
//         preferences = getSharedPreferences("count", 0);
//         int count = preferences.getInt("count", 0);
//         if (count != 0) {
//             mWebView.setWebViewClient(new MyWebViewClient());
//         }
//         editor = preferences.edit();
//         editor.putInt("count", ++count);


        mWebView.addJavascriptInterface(new MJavascriptInterface(this,"aaa", mWebView), "imagelistener");

//        mWebView.setWebViewClient(new MyWebViewClient());
        mMyWebViewClient = new MyWebViewClient();
        mWebView.setWebViewClient(mMyWebViewClient);


//        Boolean isFirstIn = false;
//        SharedPreferences pref = this.getSharedPreferences("myActivityName", 0);
////取得相应的值，如果没有该值，说明还未写入，用true作为默认值
//        isFirstIn = pref.getBoolean("isFirstIn", true);


        // LOCAL RESOURCE
        // mWebView.loadUrl("file:///android_asset/index.html");

        Logger.addLogAdapter(new AndroidLogAdapter());


        init();

    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    //重写onClick()方法
    @Override
    public void onClick(View v) {
        String js6;



        switch (v.getId()) {
            case R.id.button:
                mWebView.loadUrl("https://photos.google.com");
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_logon:
                mWebView.loadUrl("https://photos.google.com/albums");
                break;
            case R.id.button2:
                String aaa = "https://photos.google.com/search/";
                aaa = aaa + mEditText.getText();

                mMyWebViewClient.setSearchStatus(true);

//                mWebView.loadUrl("https://photos.google.com/search/dog");
                mWebView.loadUrl(aaa);


                break;

                //show
            case R.id.button3:
//                mMyWebViewClient.setPlayStatus(true);
//                mWebView.refreshDrawableState();
//                mWebView.reload();

//                String js6 = "javascript:(function() {" +
//                        "var e = document.getElementsByClassName(\"p137Zd\")[0];\n" +
//                        "e.click();\n" +
//                        "})()";
//                mWebView.loadUrl(js6);

                if (mShowFlag) {
                    mShowFlag = false;
                    setTimer();
                } else {
                    mShowFlag = true;
                    stopTimer();
                }

                break;
//            case R.id.btn_previous:
////                mMyWebViewClient.setNextStatus(true);
////                mWebView.refreshDrawableState();
////                mWebView.reload();
//
//                js6 = "javascript:(function() {" +
//                        "var e = document.getElementsByClassName(\"Vtmiqc\")[0];\n" +
//                        "e.click();\n" +
//                        "})()";
//                mWebView.loadUrl(js6);
//                break;
            case R.id.btn_next:
//                mMyWebViewClient.setNextStatus(true);
//                mWebView.refreshDrawableState();
//                mWebView.reload();

                js6 = "javascript:(function() {" +
                        "var e = document.getElementsByClassName(\"Vtmiqc\")[1];\n" +
                        "e.click();\n" +
                        "})()";
                mWebView.loadUrl(js6);
                break;
            case R.id.btn_back:
//                mMyWebViewClient.setBackStatus(true);
//                mWebView.refreshDrawableState();
//                mWebView.reload();

//                js6 = "javascript:(function() {" +
//                        "var e = document.getElementsByClassName(\"WpHeLc\");\n" +
//                        "e[0].click();\n" +
//                        "})()";
//                mWebView.loadUrl(js6);



//                js6 = "javascript:(function() {" +
//                        "var e = document.getElementsByClassName(\"Vtmiqc\")[0];\n" +
//                        "e.click();\n" +
//                        "})()";
//                mWebView.loadUrl(js6);

//                finish();

//                try {
//                    String sname = student.getStudent(new Integer(1));
//                    Log.d("lyt", sname);
//                    String aa = sname;
//
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }

                break;
        }
    }

    private static final int TIMER = 999;
    private MyTimeTask task;

    private void setTimer(){
        task =new MyTimeTask(10000, new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(TIMER);
                //或者发广播，启动服务都是可以的
            }
        });
        task.start();
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TIMER:
                    //在此执行定时操作

//                    String js6 = "javascript:(function() {" +
//                            "var e = document.getElementsByClassName(\"Vtmiqc\")[1];\n" +
//                            "e.click();\n" +
//                            "})()";

//                    String js6 = "javascript:(" +
//                            "async function() {\n" +
//                            "document.getElementsByClassName('weibo-text')[0].click();\n" +
//                            "await new Promise((resolve) => setTimeout(resolve, 3000));\n" +
//                            "document.getElementsByClassName('lite-iconf-like')[0].click();\n" +
//                            "await new Promise((resolve) => setTimeout(resolve, 3000));\n" +
//                            "document.getElementsByClassName('m-font m-font-arrow-left')[0].click();\n" +
//                            "}" +
//                            ")()";

//                    String js6 = "javascript:(" +
//                            "async function() {\n" +
//                            "document.getElementsByClassName('weibo-text')[0].click();\n" +
//                            "await setTimeout(function(){}, 3000);\n" +
//                            "document.getElementsByClassName('lite-iconf-like')[0].click();\n" +
//                            "await setTimeout(function(){}, 3000);\n" +
//                            "document.getElementsByClassName('m-font m-font-arrow-left')[0].click();\n" +
//                            "}" +
//                            ")()";
//
//                    mWebView.loadUrl(js6);

                    mWebView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                        String js6 = "javascript:(" +
//                                "function sleep (time) {\n" +
//                                "return new Promise((resolve) => setTimeout(resolve, time));\n" +
//                                "}\n" +
//                                "async function() {" +
//                                "document.getElementsByClassName('weibo-text')[0].click();\n" +
//                                "await sleep(1000);\n" +
//                                "document.getElementsByClassName('lite-iconf-like')[0].click();\n" +
//                                "await sleep(1000);\n" +
//                                "document.getElementsByClassName('m-font m-font-arrow-left')[0].click();\n" +
//                                "})()";

                            String js6 = "javascript:(" +
                                    "async function() {\n" +
                                    "document.getElementsByClassName('weibo-text')[0].click();\n" +
                                    "await new Promise((resolve) => setTimeout(resolve, 2000));\n" +
                                    "document.getElementsByClassName('lite-iconf-like')[0].click();\n" +
                                    "await new Promise((resolve) => setTimeout(resolve, 2000));\n" +
                                    "document.getElementsByClassName('m-font m-font-arrow-left')[0].click();\n" +
                                    "}" +
                                    ")()";

                            mWebView.loadUrl(js6);
                        }
                    }, 1000);


                    break;
                default:
                    break;
            }
        }
    };

    private void stopTimer(){
        task.stop();
    }





    private ServiceConnectionImpl sci ;
//    private StudentAidl student;


    private void init() {
//        Intent intent = new Intent();
//        intent.setAction("student.query");

//        Intent intent = new Intent("com.example.booter.StudentService");



//        final Intent intent = new Intent();
//        intent.setAction("com.example.booter.StudentService");
//        final Intent eintent = new Intent(createExplicitFromImplicitIntent(this,intent));

//        sci = new ServiceConnectionImpl();
//        bindService(eintent, sci, BIND_AUTO_CREATE);
    }

    class ServiceConnectionImpl implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            student = StudentAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
//            student = null;
        }

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if(sci != null) {
            unbindService(sci);
        }
    }



    /***
     * Android L (lollipop, API 21) introduced a new problem when trying to invoke implicit intent,
     * "java.lang.IllegalArgumentException: Service Intent must be explicit"
     *
     * If you are using an implicit intent, and know only 1 target would answer this intent,
     * This method will help you turn the implicit intent into the explicit form.
     *
     * Inspired from SO answer: http://stackoverflow.com/a/26318757/1446466
     * @param context
     * @param implicitIntent - The original implicit intent
     * @return Explicit Intent created from the implicit original intent
     */
    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }

}
