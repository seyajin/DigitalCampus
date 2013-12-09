package cn.sh.mhedu.mhzx.digitalcampus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";
	
	/**
	 * WebView show main content.
	 */
	private WebView mWebView;
	
	private String mUrl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mUrl = getIntent().getExtras().getString("url");
		
		initView();
	}
	
	private void initView() {
		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.setWebViewClient(new MyWebViewClient());
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl(mUrl);
	}
	
	private class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
	    	mWebView.goBack();
	        return true;
	    } 
		return super.onKeyDown(keyCode, event);
	}
	
	public void handleBackClick(View view) {
		Log.d(TAG, "back");
		if (mWebView.canGoBack()) {
			mWebView.goBack();
		} 
	}
	
	public void handleForwardClick(View view) {
		Log.d(TAG, "forward");
		if (mWebView.canGoForward()) {
			mWebView.goForward();
		}
	}
	
	public void handleRefreshClick(View view) {
		Log.d(TAG, "refresh"); 
		mWebView.reload();
	}
}
