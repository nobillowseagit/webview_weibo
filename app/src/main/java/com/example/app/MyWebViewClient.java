package com.example.app;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.orhanobut.logger.Logger;

class MyWebViewClient extends WebViewClient {
    private boolean mPlayStatus = false;
    private boolean mPlaySlideStatus = false;
    private boolean mBackStatus = false;
    private boolean mPreviousStatus = false;
    private boolean mNextStatus = false;
    private boolean mSearchStatus = false;
    private boolean mMainStatus = true;

    public boolean isPlayStatus() {
        return mPlayStatus;
    }

    public void setPlayStatus(boolean mPlayStatus) {
        this.mPlayStatus = mPlayStatus;
    }

    public boolean isPlaySlideStatus() {
        return mPlaySlideStatus;
    }

    public void setPlaySlideStatus(boolean mPlaySlideStatus) {
        this.mPlaySlideStatus = mPlaySlideStatus;
    }

    public boolean isBackStatus() {
        return mBackStatus;
    }

    public void setBackStatus(boolean mBackStatus) {
        this.mBackStatus = mBackStatus;
    }

    public boolean isPreviousStatus() {
        return mPreviousStatus;
    }

    public void setPreviousStatus(boolean mPreviousStatus) {
        this.mPreviousStatus = mPreviousStatus;
    }

    public boolean isNextStatus() {
        return mNextStatus;
    }

    public void setNextStatus(boolean mNextStatus) {
        this.mNextStatus = mNextStatus;
    }

    //    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        Uri uri = Uri.parse(url);
//        if (uri.getHost() != null && uri.getHost().contains("example.com")) {
//            return false;
//        }
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        view.getContext().startActivity(intent);
//        return true;
//    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Logger.d(url);

        Uri uri = Uri.parse(url);

//        if (uri.getHost() != null && (url.contains("ServiceLogin"))) {
//            String js3 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                    "abc.childNodes[0].value = 'nobillowsea@gmail.com';\n" +
//                    "})()";
//            view.loadUrl(js3);
//        }
//
//        //      document.getElementById(o.vehicleId).click();
//        if (uri.getHost() != null && (url.contains("ServiceLogin"))) {
//            String js6 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                    "abc.click();\n" +
//                    "})()";
//            view.loadUrl(js6);
//        }

//        if (uri.getHost() != null && (url.contains("signin/v2"))) {
//            String js3 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                    "abc.childNodes[0].value = 'Lijia819156';\n" +
//                    "})()";
//            view.loadUrl(js3);
//        }
//
//        //      document.getElementById(o.vehicleId).click();
//        if (uri.getHost() != null && (url.contains("signin/v2"))) {
//            String js6 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                    "abc.click();\n" +
//                    "})()";
//            view.loadUrl(js6);
//        }


//        remove head tool bar SmZ4Wd W2pADe
//        if (uri.getHost() != null && (url.equals("https://photos.google.com") ||
//                url.equals("https://photos.google.com/") ||
//                url.equals("https://photos.google.com/albums") ||
//                (url.contains("https://photos.google.com/search") && !url.contains("photo/")))) {
//
//            String js1 = "javascript:(function() {" +
////                    "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
////                    "abc.parentNode.removeChild(abc);\n" +
//                    "var b = document.getElementsByClassName(\"SmZ4Wd omBice\")[0];\n" +
//                    "b.parentNode.removeChild(b);\n" +
//                    "})()";
//
////            String js2 = "javascript:(function() {" +
////                    "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
////                    "var parent = abc.parentNode;\n" +
////                    "parent.parentNode.removeChild(parent);\n" +
////                    "})()";
//
//            view.loadUrl(js1);
//        }

        super.onPageStarted(view, url, favicon);

    }

    @Override
    public void onPageFinished(WebView view, String url) {
//        String js = "javascript:(function() {document.getElementById(\"yg-fd\").style.display=\'none\';"+ "})()";
        Logger.d(url);

        super.onPageFinished(view, url);
//        addImageClickListener(view);//待网页加载完全后设置图片点击的监听方法

        Uri uri = Uri.parse(url);


        if (uri.getHost() != null) {

//            String js6 = "javascript:(" +
//                    "function sleep (time) {\n" +
//                    "return new Promise((resolve) => setTimeout(resolve, time));\n" +
//                    "}\n" +
//                    "async function() {" +
//                    "document.getElementsByClassName('weibo-text')[0].click();\n" +
//                    "await sleep(1000);\n" +
//                    "document.getElementsByClassName('lite-iconf-like')[0].click();\n" +
//                    "await sleep(1000);\n" +
//                    "document.getElementsByClassName('m-font m-font-arrow-left')[0].click();\n" +
//                    "})()";
//            view.loadUrl(js6);

            view.postDelayed(new Runnable() {
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

                        view.loadUrl(js6);
                    }
                }, 5000);


//            if (mBackStatus == true) {
//                mBackStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
//                                "var e = document.getElementsByClassName(\"WpHeLc\")[0];\n" +
//                                "e.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 1500);
//            }
//
//            if (mNextStatus == true) {
//                mNextStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
//                                "var e = document.getElementsByClassName(\"Vtmiqc\")[1];\n" +
//                                "e.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 1500);
//            }
//
//            if (mPlayStatus == true) {
//                mPlayStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
//                                "var e = document.getElementsByClassName(\"p137Zd\")[0];\n" +
//                                "e.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 3600);
//            }
//        }

//        if (uri.getHost() != null && (url.contains("https://photos.google.com/search/"))) {
//            if (mSearchStatus) {
//                mSearchStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
//                                "var e = document.getElementsByClassName(\"p137Zd\")[0];\n" +
//                                "e.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 2500);
//            }

//            if (mPlayStatus == true) {
//                mPlayStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
////                    "var a = document.getElementsByClassName(\"RY3tic\")[0];\n" +
////                    "a.click();\n" +
////                    "var b = document.getElementsByClassName(\"eGiHwc\")[0];\n" +
////                    "b.click();\n" +
////                    "var c = document.getElementsByClassName(\"KYCEmd\")[0];\n" +
////                    "c.click();\n" +
//                                "var d = document.getElementsByClassName(\"p137Zd\")[0];\n" +
//                                "d.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 3000);
//            }
//            if (mPlaySlideStatus == true) {
//                mPlaySlideStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
////                    "var a = document.getElementsByClassName(\"RY3tic\")[0];\n" +
////                    "a.click();\n" +
////                    "var b = document.getElementsByClassName(\"eGiHwc\")[0];\n" +
////                    "b.click();\n" +
////                    "var c = document.getElementsByClassName(\"KYCEmd\")[0];\n" +
////                    "c.click();\n" +
//                                "var d = document.getElementsByClassName(\"z80M1\")[18];\n" +
//                                "d.click();\n" +
//                                "var e = document.getElementsByClassName(\"uyYuVb\")[18];\n" +
//                                "e.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 3800);
//            }
//            if (mPlaySlideStatus == true) {
//                mPlaySlideStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
////                    "var a = document.getElementsByClassName(\"RY3tic\")[0];\n" +
////                    "a.click();\n" +
////                    "var b = document.getElementsByClassName(\"eGiHwc\")[0];\n" +
////                    "b.click();\n" +
////                    "var c = document.getElementsByClassName(\"KYCEmd\")[0];\n" +
////                    "c.click();\n" +
////                                "var e = document.getElementsByClassName(\"Vtmiqc\")[1];\n" +
//                                "var d = document.getElementsByClassName(\"U26fgb\")[4];\n" +
//                                "d.click();\n" +
//                                "var e = document.getElementsByClassName(\"z80M1\")[16];\n" +
//                                "e.click();\n" +
////                                "var f = document.getElementsByClassName(\"uyYuVb\")[16];\n" +
////                                "f.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 3000);
//                return;
//            }
        }

//        id="js-header-right"
//        if (uri.getHost() != null && (url.contains("photos/about"))) {
//            String js6 = "javascript:(function() {" +
//                    "var b = document.getElementsByClassName(\"header__sign-in\")[0];\n" +
//                    "b.click();\n" +
//                    "})()";
//            view.loadUrl(js6);
//        }
//
//        //remove head tool bar SmZ4Wd W2pADe
//        if (uri.getHost() != null && (url.equals("https://photos.google.com") ||
//                url.equals("https://photos.google.com/") ||
//                url.equals("https://photos.google.com/albums") ||
//                (url.contains("https://photos.google.com/search") && !url.contains("photo/")))) {
//
//            if (mMainStatus) {
//                mMainStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
//                                "var e = document.getElementsByClassName(\"p137Zd\")[0];\n" +
//                                "e.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 2500);
//            }
//        }

//        if (uri.getHost() != null && (url.contains("ServiceLogin"))) {
//            String js3 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                    "abc.childNodes[0].value = 'nobillowsea@gmail.com';\n" +
//                    "var b = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                    "b.click();\n" +
//                    "})()";
//            view.loadUrl(js3);
//        };
//        if (uri.getHost() != null && (url.contains("ServiceLogin"))) {
//            view.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    String js3 = "javascript:(function() {" +
//                            "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                            "abc.childNodes[0].value = 'nobillowsea@gmail.com';\n" +
//                            "var b = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                            "b.click();\n" +
//                            "})()";
//                    view.loadUrl(js3);
//                }
//            }, 1600);
//            view.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    String js3 = "javascript:(function() {" +
//                            "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                            "abc.childNodes[0].value = 'nobillowsea@gmail.com';\n" +
//                            "})()";
//                    view.loadUrl(js3);
//                }
//            }, 1600);
//            view.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    String js3 = "javascript:(function() {" +
//                            "var b = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                            "b.click();\n" +
//                            "})()";
//                    view.loadUrl(js3);
//                }
//            }, 1800);
//        }

//        if (uri.getHost() != null && (url.contains("signin/v2"))) {
//            String js3 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                    "abc.childNodes[0].value = 'Lijia819156';\n" +
//                    "var b = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                    "b.click();\n" +
//                    "})()";
//            view.loadUrl(js3);
//        }

//        if (uri.getHost() != null && (url.contains("signin/v2"))) {
//            view.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    String js3 = "javascript:(function() {" +
//                            "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                            "abc.childNodes[0].value = 'Lijia819156';\n" +
//                            "var b = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                            "b.click();\n" +
//                            "})()";
//
//                    view.loadUrl(js3);
//
//                }
//
//            }, 3600);
//            view.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    String js3 = "javascript:(function() {" +
//                            "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                            "abc.childNodes[0].value = 'Lijia819156';\n" +
//                            "})()";
//                    view.loadUrl(js3);
//                }
//
//            }, 3600);
//            view.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    String js3 = "javascript:(function() {" +
//                            "var b = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                            "b.click();\n" +
//                            "})()";
//                    view.loadUrl(js3);
//                }
//            }, 3800);
//        }


//        if (uri.getHost() != null && (url.contains("ServiceLogin"))) {
//            String js3 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                    "abc.childNodes[0].value = 'nobillowsea@gmail.com';\n" +
//                    "})()";
//            view.loadUrl(js3);
//        }
//
//        //      document.getElementById(o.vehicleId).click();
//        if (uri.getHost() != null && (url.contains("ServiceLogin"))) {
//            String js6 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                    "abc.click();\n" +
//                    "})()";
//            view.loadUrl(js6);
//        }

//        try {
//            Thread.sleep(1000*3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        if (uri.getHost() != null && (url.contains("signin/v2"))) {
//            String js3 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                    "abc.childNodes[0].value = 'Lijia819156';\n" +
//                    "})()";
//            view.loadUrl(js3);
//        }
//
//        //      document.getElementById(o.vehicleId).click();
//        if (uri.getHost() != null && (url.contains("signin/v2"))) {
//            String js6 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"ZFr60d\")[0];\n" +
//                    "abc.click();\n" +
//                    "})()";
//            view.loadUrl(js6);
//        }


//        String js1 = "javascript:(function() {" +
//                "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                "abc.parentNode.removeChild(abc);\n" +
//                "})()";
//
//        String js2 = "javascript:(function() {" +
//                "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                "var parent = abc.parentNode;\n" +
//                "parent.parentNode.removeChild(parent);\n" +
//                "})()";
//
//        view.loadUrl(js2);

//        super.onPageFinished(view, url);
//        super.onPageCommitVisible(view, url);
//        super.onLoadResource(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
////        String js = "javascript:(function() {document.getElementById(\"yg-fd\").style.display=\'none\';"+ "})()";
//
        Uri uri = Uri.parse(url);
//        if (uri.getHost() != null && (url.equals("https://photos.google.com") ||
//                url.equals("https://photos.google.com/albums") ||
//                url.equals("https://photos.google.com/search"))) {
//
//            String js1 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                    "abc.parentNode.removeChild(abc);\n" +
//                    "})()";
//
//            String js2 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                    "var parent = abc.parentNode;\n" +
//                    "parent.parentNode.removeChild(parent);\n" +
//                    "})()";
//
//            view.loadUrl(js1);
//        }
//
////        super.onPageFinished(view, url);
////        super.onPageCommitVisible(view, url);
        super.onLoadResource(view, url);

//        if (uri.getHost() != null) {
//            String js6 = "javascript:(function() {" +
//                "var e6 = document.getElementsByClassName(\"RY3tic\")[0];\n" +
//                "var i6 = e6.getAttribute(\"data-latest-bg\");\n" +
////                    "window.imagelistener.url2bitmap(i6);\n" +
//                    "window.imagelistener.show(i6);\n" +
//                "})()";
//            view.loadUrl(js6);
//
//            if (mPlayStatus == true) {
//                mPlayStatus = false;
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String js6 = "javascript:(function() {" +
//                                "var d = document.getElementsByClassName(\"p137Zd\")[0];\n" +
//                                "d.click();\n" +
//                                "})()";
//                        view.loadUrl(js6);
//                    }
//                }, 5000);
//            }
//        }

    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
//        String js = "javascript:(function() {document.getElementById(\"yg-fd\").style.display=\'none\';"+ "})()";

//        Uri uri = Uri.parse(url);
//        if (uri.getHost() != null && (url.equals("https://photos.google.com") ||
//                url.equals("https://photos.google.com/") ||
//                url.equals("https://photos.google.com/albums") ||
//                (url.contains("https://photos.google.com/search") && !url.contains("photo/")))) {
//
//            String js1 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                    "abc.parentNode.removeChild(abc);\n" +
//                    "})()";
//
//            String js2 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                    "var parent = abc.parentNode;\n" +
//                    "parent.parentNode.removeChild(parent);\n" +
//                    "})()";
//
//            view.loadUrl(js1);
//        }

//        if (uri.getHost() != null && (url.contains("ServiceLogin"))) {
//            String js3 = "javascript:(function() {" +
//                    "var abc = document.getElementsByClassName(\"Xb9hP\")[0];\n" +
//                    "abc.childNodes[0].value = 'nobillowsea@gmail.com';\n" +
//                    "})()";
//            view.loadUrl(js3);
//        }

//        String js1 = "javascript:(function() {" +
//                "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                "abc.parentNode.removeChild(abc);\n" +
//                "})()";
//
//        String js2 = "javascript:(function() {" +
//                "var abc = document.getElementsByClassName(\"QtDoYb\")[0];\n" +
//                "var parent = abc.parentNode;\n" +
//                "parent.parentNode.removeChild(parent);\n" +
//                "})()";
//
//        view.loadUrl(js2);

//        super.onPageFinished(view, url);
        super.onPageCommitVisible(view, url);
//        super.onLoadResource(view, url);
    }

    private void addImageClickListener(WebView webView) {
//        webView.loadUrl("javascript:(function(){" +
//                "var objs = document.getElementsByClassName(\"RY3tic\"); " +
//                "for(var i=0;i<objs.length;i++)  " +
//                "{"
//                + "    objs[i].onclick=function()  " +
//                "    {  "
//                + "        window.imagelistener.openImage(this.src);  " +//通过js代码找到标签为img的代码块，设置点击的监听方法与本地的openImage方法进行连接
//                "    }  " +
//                "}" +
//                "})()");

//        String js6 = "javascript:(function() {" +
////                    "var a = document.getElementsByClassName(\"RY3tic\")[0];\n" +
////                    "a.click();\n" +
////                    "var b = document.getElementsByClassName(\"eGiHwc\")[0];\n" +
////                    "b.click();\n" +
////                    "var c = document.getElementsByClassName(\"KYCEmd\")[0];\n" +
////                    "c.click();\n" +
//                "var d = document.getElementsByClassName(\"p137Zd\")[0];\n" +
//                "d.click();\n" +
//                "})()";
//        webView.loadUrl(js6);
    }

    @Override
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        super.onRenderProcessGone(view, detail);
        return true;
    }


    public void setSearchStatus(boolean b) {
        mSearchStatus = b;
    }
}
