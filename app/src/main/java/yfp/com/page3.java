package yfp.com;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class page3 extends Activity {
    @TargetApi(Build.VERSION_CODES.KITKAT) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2layout);
        Button Button1 = (Button) findViewById(R.id.button1);
        Button Button2 = (Button) findViewById(R.id.button2);

// g1

        WebView web = (WebView)findViewById(R.id.webView1);
        web.setWebViewClient(new WebViewClient() );
        //web.loadUrl("file:///android_asset/loading.html");
        //web.loadUrl("https://meiyingtw.github.io/app/fp/fplist.htm");
        web.loadUrl("https://www.etax.nat.gov.tw/etw-main/web/ETW183W1/");
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSaveFormData(false);

        // webSettings.setSupportZoom(false);   //------------------------------- �ץ���1

        //------------------------------- �ץ���1
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

//      web.setaaaWebViewClient(
//              new SSLaaaToaaalerentWebViewClient()
//      );
//
        //-------------------------------�ץ���1
      /*web.evaluateJavascript("alert('hi')",  new ValueCallback<String>() {
    	    @Override
    	    public void onReceiveValue(String s) {
    	        //Log.d("LogName", s); // Prints: "this"
    	    }
    	});
      */


        Button1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }

        });
        Button2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent ();
                intent.setClass(page3.this, MainActivity.class);
                startActivity(intent);
                page3.this.finish();
            }

        });

    }

}