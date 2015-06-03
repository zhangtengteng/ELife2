package com.elife.main.home.ui;
import android.os.Bundle;
import android.widget.GridView;

import com.elife.R;
import com.elife.adapter.EGridViewAdapter;
import com.elife.ui.base.BaseActivity;


public class EActivity extends BaseActivity {
	private GridView gridView;
	private EGridViewAdapter eGridViewAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_e_recommend);
		initViews();
	}

	private void initViews() {
		gridView = (GridView) findViewById(R.id.gride_view);
		eGridViewAdapter = new EGridViewAdapter(this);
		gridView.setAdapter(eGridViewAdapter);
	}
	
}
