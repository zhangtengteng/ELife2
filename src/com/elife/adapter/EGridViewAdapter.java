package com.elife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.elife.R;
import com.elife.ui.base.BaseActivity;

public class EGridViewAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	public EGridViewAdapter(Context context) {
		super();
		this.context = context;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		if(view==null){
			view=inflater.inflate(R.layout.item_e_grideview, null);
		}
		return view;
	}
	
}
