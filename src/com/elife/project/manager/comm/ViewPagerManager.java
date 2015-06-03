package com.elife.project.manager.comm;

import android.app.LocalActivityManager;
import android.content.Context;

/***
 * ViewPager 管理类
 * @author Administrator
 *
 */
public class ViewPagerManager {

	public static LocalActivityManager manager;
	private volatile static ViewPagerManager instance;
	/**
	 * 创建单例类，提供静态方法调用
	 * 
	 * @return ActivityManager
	 */
	public static ViewPagerManager getInstance() {
		if (instance == null) {
			instance = new ViewPagerManager();
		}
		return instance;

	}
	


}
