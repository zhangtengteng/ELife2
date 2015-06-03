package com.elife.main.ui;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.elife.R;
import com.elife.model.PremissionsModel;
import com.elife.net.CommonData;
import com.elife.net.PremissionRequest;
import com.elife.project.comm.ExtractorThread;
import com.elife.project.manage.comm.SharedPreManager;
import com.elife.ui.base.BaseActivity;
import com.elife.utils.LogN;
import com.elife.utils.ToastUtils;

public class LoadingActivity extends BaseActivity {
	private String uid;
	private String ucode;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
				case 100 :
					startActivity(new Intent(LoadingActivity.this,
							MainActivity.class));
					LoadingActivity.this.finish();
					break;
				case CommonData.HTTP_HANDLE_FAILE :
					ToastUtils.showToast(LoadingActivity.this, "获取权限失败！", 2000);
					break;
				case CommonData.HTTP_HANDLE_SUCCESS :
					if (msg.obj != null) {
						doAfterPremissionSuccess(msg.obj.toString());
					} else {
						LogN.i(this, "msg.obj is null!");
					}
					break;
				default :
					break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		SharedPreManager.getInstance().init(this);
		showLoading();

	}

	/***
	 * 获取权限 ucode uid
	 */
	private void getPremissionRequest() {
		ExtractorThread.getInstance().getAsyncHandler().post(new Runnable() {
			@Override
			public void run() {
				PremissionRequest premissionRequest = new PremissionRequest(
						handler);
				premissionRequest.setParams("0", "0");
				premissionRequest.sendRequest();
			}
		});

	}

	private void doAfterPremissionSuccess(String str) {
		try {
			JSONObject o = new JSONObject(str);
			boolean result = o.getBoolean("success");
			if (result) {
				// JSONArray dataArray = o.getJSONArray("data");
				SharedPreManager.getInstance().setString(
						SharedPreManager.UCODE, o.getString("ucode"));
				SharedPreManager.getInstance().setString(SharedPreManager.UID,
						o.getString("uid"));
				// for (int i = 0; i < dataArray.length(); i++) {
				// JSONObject obj = dataArray.getJSONObject(i);
				// try {
				// model = (PremissionsModel) JSONUtil.fromJsonToJava(obj,
				// PremissionsModel.class);
				// } catch (Exception e) {
				// e.printStackTrace();
				// }
				// }

				startActivity(new Intent(LoadingActivity.this,
						MainActivity.class));
				LoadingActivity.this.finish();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void showLoading() {
		uid = SharedPreManager.getInstance()
				.getString(SharedPreManager.UID, "");
		ucode = SharedPreManager.getInstance().getString(
				SharedPreManager.UCODE, "");
		if (uid != "" || ucode != "") {
			startActivity(new Intent(LoadingActivity.this, MainActivity.class));
			LoadingActivity.this.finish();
		} else {
			getPremissionRequest();
		}
	}
}
