package cn.sh.mhedu.mhzx.digitalcampus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	
	private static final String TAG = "MainActivity";
	
	/**
	 * WebView show main content.
	 */
	private WebView mWebView;
	
	private Button mButtonBack;
	private Button mButtonForward;
	private Button mButtonRefresh;
	
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
		
		mButtonBack = (Button) findViewById(R.id.browser_back);
		mButtonBack.setOnClickListener(this);
		mButtonForward = (Button) findViewById(R.id.browser_forward);
		mButtonForward.setOnClickListener(this);
		mButtonRefresh = (Button) findViewById(R.id.browser_refresh);
		mButtonRefresh.setOnClickListener(this);
	}
	
	private class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			Log.d(TAG, "shouldOverrideUrlLoading");
			return true;
		}
		
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			Log.d(TAG, "onPageFinished");
			updateButtonsState();
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
		updateButtonsState();
	}
	
	public void handleForwardClick(View view) {
		Log.d(TAG, "forward");
		if (mWebView.canGoForward()) {
			mWebView.goForward();
		}
		updateButtonsState();
	}
	
	public void handleRefreshClick(View view) {
		Log.d(TAG, "refresh"); 
		mWebView.reload();
	}
	
	private void updateButtonsState() {
		mButtonBack.setEnabled(mWebView.canGoBack());
		mButtonForward.setEnabled(mWebView.canGoForward());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.browser_back:
			handleBackClick(v);
			break;
			
		case R.id.browser_forward:
			handleForwardClick(v);
			break;
			
		case R.id.browser_refresh:
			handleRefreshClick(v);
			break;

		default:
			break;
		}
		
	}
}
