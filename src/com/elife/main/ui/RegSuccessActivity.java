package com.elife.main.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.elife.R;
import com.elife.ui.base.BaseActivity;

/***
 * 注册成功
 * @author Administrator
 *
 */
public class RegSuccessActivity extends BaseActivity {
	private TextView left,top;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg_success);
		initTops();
	}

	/**
	 * 初始化顶部
	 */
	private void initTops() {
		left =(TextView) findViewById(R.id.tv_left);
		top= (TextView) findViewById(R.id.tv_top);
		top.setText("注册成功");
	}
}
