package com.elife.main.home.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.elife.R;
import com.elife.ui.base.BaseActivity;

public class SetActivity2 extends BaseActivity
{
    
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initViews();
    }

    private void initViews()
    {
        title = (TextView) findViewById(R.id.tv);
        title.setText("22222222222222");
    }
}
