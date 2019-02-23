package com.toly1994.mycode.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.toly1994.mycode.R;
import com.toly1994.mycode.view.widget.AlphaImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.id_wv);

        AlphaImageView back = findViewById(R.id.id_iv_back);
        AlphaImageView refresh = findViewById(R.id.id_iv_refresh);
        TextView topTitle = findViewById(R.id.id_tv_title);

        String noteUrl = getIntent().getStringExtra("url");
        webView.loadUrl(noteUrl);

        //开启js
        WebSettings setting = webView.getSettings();
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);
        setting.setJavaScriptEnabled(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);

        //网页标题获取
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                topTitle.setText(title);
            }
        });


        webView.setWebViewClient(new WebViewClient() {
            @Override//禁止跳转浏览器
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override//错误页面的本地处理
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                view.loadUrl("file:///android_asset/error/error404.html");
            }
        });

        //返回按钮
        back.setOnAlphaListener(v->{
            back();
        });

        //刷新按钮
        refresh.setOnAlphaListener(v -> {
            webView.reload();
        });



    }

    //返回键的处理
    @Override
    public void onBackPressed() {
        back();
    }

    private void back() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }

    /**
     * 通过url访问服务器,并接收服务器响应数据
     *
     * @param path url
     * @param file 文件地址
     */
    private void download(String path, File file) {
        InputStream is = null;
        OutputStream os = null;
        HttpURLConnection conn = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file);
            URL url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                int len;
                byte[] buf = new byte[1024];
                while ((len = is.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (is != null) {
                    os.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
