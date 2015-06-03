package com.elife.main.home.ui;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.elife.R;
import com.elife.adapter.MyPagerAdapter;
import com.elife.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity implements OnClickListener{
	LocalActivityManager manager = null;
	private ViewPager viewPager;
	//当前选中的圆圈
	private View currentSelectRound;
	// 圆圈Group
	private LinearLayout RoundGroup;
	//存放圆圈View的Map
	private HashMap<Integer, View> rounds = new HashMap<Integer, View>();
	//e
	private ImageButton ibE;
	private ImageButton ibLocal;
	private ImageButton ibLittle;
	private ImageButton ibdelicious;
	private ImageButton ibMenu;
	private ImageButton ibAid;
	private ImageButton ibAll;
	@Override
	protected void onCreate(Bundle sroundsavedInstanceState) {
		super.onCreate(sroundsavedInstanceState);
		setContentView(R.layout.activity_main_home);
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(sroundsavedInstanceState);
		initViews();
		initPagerViewer();
	}

	private void initViews() {
		RoundGroup = (LinearLayout) findViewById(R.id.ll_round);
		for (int i = 0; i < 6; i++) {
			rounds.put(i, RoundGroup.getChildAt(i));
		}
		currentSelectRound=RoundGroup.getChildAt(0);
		
		ibE=(ImageButton) findViewById(R.id.ib_e);
		ibE.setOnClickListener(this);
		
		ibLocal=(ImageButton) findViewById(R.id.ib_local);
		ibLocal.setOnClickListener(this);
		
		ibLittle=(ImageButton) findViewById(R.id.ib_little);
		ibLittle.setOnClickListener(this);	
		
		ibdelicious=(ImageButton) findViewById(R.id.ib_delicious);
		ibdelicious.setOnClickListener(this);
		
		ibMenu=(ImageButton) findViewById(R.id.ib_menu);
		ibMenu.setOnClickListener(this);
		
		ibAid=(ImageButton) findViewById(R.id.ib_aid);
		ibAid.setOnClickListener(this);
		
		ibAll=(ImageButton) findViewById(R.id.ib_all);
		ibAll.setOnClickListener(this);

		
	}

	/**
	 * 初始化PageViewer
	 */
	private void initPagerViewer() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		final ArrayList<View> list = new ArrayList<View>();
		Intent intent = new Intent(this, ViewPagerActivity1.class);
		list.add(getView("0", intent));

		Intent intent2 = new Intent(this, ViewPagerActivity2.class);
		list.add(getView("1", intent2));

		Intent intent3 = new Intent(this, ViewPagerActivity3.class);
		list.add(getView("2", intent3));

		Intent intent4 = new Intent(this, ViewPagerActivity4.class);
		list.add(getView("3", intent4));

		Intent intent5 = new Intent(this, ViewPagerActivity5.class);
		list.add(getView("4", intent5));

		Intent intent6 = new Intent(this, ViewPagerActivity6.class);
		list.add(getView("5", intent6));

		viewPager.setAdapter(new MyPagerAdapter(list));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				System.out.println("onPageSelected=" + position);
				
				rounds.get(position).setBackgroundDrawable(
						getResources().getDrawable(
								R.drawable.view_pager_round_red));
				currentSelectRound.setBackgroundDrawable(getResources().getDrawable(R.drawable.view_pager_round_white));
				currentSelectRound=rounds.get(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	/**
	 * 通过activity获取视图
	 * 
	 * @param id
	 * @param intent
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.ib_e:
			activityManager.startNextActivity(EActivity.class);
			break;
		case R.id.ib_menu:
			activityManager.startNextActivity(EActivity.class);
			break;
		case R.id.ib_delicious:
			activityManager.startNextActivity(EActivity.class);
			break;
		case R.id.ib_little:
			activityManager.startNextActivity(EActivity.class);
			break;
		case R.id.ib_local:
			activityManager.startNextActivity(EActivity.class);
			break;
		case R.id.ib_all:
			activityManager.startNextActivity(EActivity.class);
			break;
		case R.id.ib_aid:
			activityManager.startNextActivity(EActivity.class);
			break;

		default:
			break;
		}
	}

}
