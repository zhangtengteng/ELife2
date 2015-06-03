package com.elife.main.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.elife.R;
import com.elife.diy.EditTextWithDel;
import com.elife.net.CommonData;
import com.elife.net.CodeRequest;
import com.elife.net.RegisterRequest;
import com.elife.project.manage.comm.SharedPreManager;
import com.elife.ui.base.BaseActivity;
import com.elife.utils.StringUtils;
import com.elife.utils.ToastUtils;
/***
 * 注册
 * 
 * @author zhangtengteng
 * 
 */
public class RegActivity extends BaseActivity implements OnClickListener {
	private Button btnSendCode;
	private TimeCount timeCount;
	private EditTextWithDel phone;
	private Button register;
	private EditText code;
	String why;
	private Handler handler = new Handler() {
		@Override
		public void dispatchMessage(Message msg) {
			super.dispatchMessage(msg);

			if (msg.obj != null) {
				why = msg.obj.toString();
			}
			switch (msg.what) {

				case CommonData.HTTP_HANDLE_FAILE :
					ToastUtils.showLongToast(RegActivity.this, why);
					break;
				case CommonData.HTTP_HANDLE_FAILE2 :
					ToastUtils.showLongToast(RegActivity.this, why);
					break;
				case CommonData.HTTP_HANDLE_SUCCESS :
					ToastUtils.showLongToast(RegActivity.this, "获取验证码成功！");
					break;
				case CommonData.HTTP_HANDLE_SUCCESS2 :
					ToastUtils.showLongToast(RegActivity.this, "注册成功！");
					break;

				default :
					break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.elife.R.layout.activity_reg);
		initViews();
		bindListener();
	}

	private void bindListener() {
		btnSendCode.setOnClickListener(this);
	}

	private void initViews() {
		btnSendCode = (Button) findViewById(com.elife.R.id.btn_send_code);
		timeCount = new TimeCount(60000, 1000);

		phone = (EditTextWithDel) findViewById(R.id.et_phone);

		register = (Button) findViewById(R.id.btn_register);
		register.setOnClickListener(this);

		code = (EditText) findViewById(R.id.et_code);
	}

	/**
	 * 倒计时
	 * 
	 * @author zhangtengteng
	 * 
	 */
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		@Override
		public void onFinish() {// 计时完毕时触发
			btnSendCode.setText("重新验证");
			btnSendCode.setClickable(true);
			btnSendCode.setBackground(getResources().getDrawable(
					R.drawable.corners_bg_reg0_bule));

		}

		@Override
		public void onTick(long millisUntilFinished) {// 计时过程显示
			btnSendCode.setBackground(getResources().getDrawable(
					R.drawable.corners_bg_reg0_gray));
			btnSendCode.setClickable(false);
			btnSendCode.setText(millisUntilFinished / 1000 + "秒");
		}
	}
	/**
	 * 发送验证码
	 */
	private void sendCode() {
		if (StringUtils.isEmpty(phone.getText().toString())) {
			ToastUtils.showLongToast(this, "手机号不能为空！");
			return;
		}
		timeCount.start();
		CodeRequest registerRequest = new CodeRequest(handler);
		registerRequest.setParams(
				phone.getText().toString(),
				SharedPreManager.getInstance().getString(
						SharedPreManager.UCODE, ""),
				SharedPreManager.getInstance().getString(SharedPreManager.UID,
						""));
		registerRequest.sendRequest();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_send_code :
				sendCode();
				break;

			case R.id.btn_register :
				registerRequest();
				break;

			default :
				break;
		}
	}

	/***
	 * 注册
	 */
	private void registerRequest() {
		if (StringUtils.isEmpty(code.getText().toString())) {
			ToastUtils.showLongToast(this, "验证码不能为空！");
			return;
		}
		RegisterRequest registerRequest = new RegisterRequest(handler);
		registerRequest.setParams(
				phone.getText().toString(),
				SharedPreManager.getInstance().getString(
						SharedPreManager.UCODE, ""),
				SharedPreManager.getInstance().getString(SharedPreManager.UID,
						""), code.getText().toString());
		registerRequest.sendRequest();
	}
}
