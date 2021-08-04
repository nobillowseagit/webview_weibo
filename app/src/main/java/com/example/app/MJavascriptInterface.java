package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.webkit.WebView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MJavascriptInterface {
    private Context context;
//    private String [] imageUrls;
    private String imageUrls;
    private WebView mWebView;

    public MJavascriptInterface(Context context, String imageUrls, WebView webView) {
        this.mWebView = webView;
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @android.webkit.JavascriptInterface
    public void openImage(String img) {
        Intent intent = new Intent();
        intent.putExtra("imageUrls", imageUrls);
        intent.putExtra("curImageUrl", img);
        intent.setClass(context, PhotoBrowserActivity.class);
        context.startActivity(intent);
    }

    @android.webkit.JavascriptInterface
    public void show(String url) {
        mWebView.loadUrl(url);
    }

    @android.webkit.JavascriptInterface
    public void url2bitmap(String url1) {
        Bitmap bm = null;
        try {
//            URL iconUrl = new URL(url1);
//            URLConnection conn = iconUrl.openConnection();
//            HttpURLConnection http = (HttpURLConnection) conn;
//            int length = http.getContentLength();
//            conn.connect();

//            URL url = new URL("https://baidu.com");
            URL url = new URL(url1);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
//            urlConnection.setInstanceFollowRedirects(false);
//            urlConnection.setDoOutput(true);
//            urlConnection.setDoInput(true);
//            urlConnection.setConnectTimeout(Common.TIME_OUT);
//            urlConnection.setReadTimeout(Common.FILE_TIME_OUT);
            urlConnection.setRequestMethod("GET");
//            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
//            urlConnection.setRequestProperty("Accept-Encoding", "gzip");
            int length = urlConnection.getContentLength();


            // 获得图像的字符流
            InputStream is = urlConnection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is, length);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
            if (bm != null) {
                save2Album(url1, bm);
            }
        } catch (Exception e) {
//            new Handler().post (new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(mActivity, "保存失败", Toast.LENGTH_SHORT).show();
//                }
//            });
            e.printStackTrace();
        }
    }

    private void save2Album(String url, Bitmap bitmap) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "lyt");
        if (!appDir.exists()) appDir.mkdir();
        String[] str = url.split("/");
//        String fileName = str[str.length - 1];
        String fileName = "lyt.jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            onSaveSuccess(file);
        } catch (IOException e) {
//            mActivity.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(mActivity, "保存失败", Toast.LENGTH_SHORT).show();
//                }
//            });
            e.printStackTrace();
        }
    }

    private void onSaveSuccess(final File file) {
//        mActivity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mActivity.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
//                Toast.makeText(mActivity, "已成功保存到：相册-二维码####", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
