package com.elife.project.main.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.elife.R;
import com.elife.ui.base.BaseActivity;

public class RegActivity extends BaseActivity implements OnClickListener {
	private Button btnSendCode;
	private TimeCount timeCount;

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

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_send_code:
			timeCount.start();
			break;

		default:
			break;
		}
	}
}
