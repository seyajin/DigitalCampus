package cn.sh.mhedu.mhzx.digitalcampus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import cn.sh.mhedu.mhzx.digitalcampus.database.MyPreferenceManager;

public class SignInActivity extends FragmentActivity {
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
	}
	
	public void handleInformationSoftwareBtnClick(View view) {
		if (MyPreferenceManager.getEntryCourseSignIn(this)) {
			enterEntryCourseSystem();
		} else {
			showFragmentDialog(MyAlertDialogFragment.TYPE_ENTRY_COURSE);
		}
	}
	
	public void handleEntryCourseBtnClick(View view) {
		if (MyPreferenceManager.getInformationSoftwareSignIn(this)) {
			enterInformationSoftwareSystem();
		} else {
			showFragmentDialog(MyAlertDialogFragment.TYPE_INFORMATION_SOFTWARE);
		}
	}
	
	private void enterEntryCourseSystem() {
		// TODO
	}
	
	private void enterInformationSoftwareSystem() {
		// TODO
	}
	
	public static class MyAlertDialogFragment extends DialogFragment {
		private static final int TYPE_ENTRY_COURSE = 0;
		private static final int TYPE_INFORMATION_SOFTWARE = 1;
		
		private int currentType = TYPE_ENTRY_COURSE;
		
		private EditText accountEditText;
		private EditText passwordEditText;

	    public static MyAlertDialogFragment newInstance(int title, int type) {
	        MyAlertDialogFragment frag = new MyAlertDialogFragment();
	        Bundle args = new Bundle();
	        args.putInt("title", title);
	        args.putInt("type", type);
	        frag.setArguments(args);
	        return frag;
	    }

	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        int title = getArguments().getInt("title");
	        currentType = getArguments().getInt("type");

	        return new AlertDialog.Builder(getActivity())
	                .setTitle(title)
	                .setView(getDialogContentView())
	                .setPositiveButton(R.string.alert_dialog_ok,
	                    new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog, int whichButton) {
	                            ((SignInActivity)getActivity()).doPositiveClick(currentType, 
	                            												accountEditText.getText().toString(), 
	                            												passwordEditText.getText().toString());
	                        }
	                    }
	                )
	                .setNegativeButton(R.string.alert_dialog_cancel,
	                    new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog, int whichButton) {
	                            ((SignInActivity)getActivity()).doNegativeClick(currentType);
	                        }
	                    }
	                )
	                .create();
	    }
	    
	    private View getDialogContentView() {
	    	View content = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_layout_sign_in, null);
	    	accountEditText = (EditText) content.findViewById(R.id.account);
	    	passwordEditText = (EditText) content.findViewById(R.id.password);
	    	return content;
	    }
	}
	
	private void showFragmentDialog(int type) {
		DialogFragment newFragment = MyAlertDialogFragment.newInstance(R.string.alert_dialog_sign_in, type);
	    newFragment.show(getSupportFragmentManager(), "dialog");
	}

	public void doPositiveClick(int type, String account, String password) {
		Log.d(TAG, "account : " + account);  
		Log.d(TAG, "password : " + password);  
		
	    if (type == MyAlertDialogFragment.TYPE_ENTRY_COURSE) {
	    	Log.d(TAG, "type : " + type);
	    } else {
	    	Log.d(TAG, "type : " + type);
	    }
	}

	public void doNegativeClick(int type) {
	    if (type == MyAlertDialogFragment.TYPE_ENTRY_COURSE) {
	    	Log.d(TAG, "type : " + type);
	    } else {
	    	Log.d(TAG, "type : " + type);
	    }
	}

}
