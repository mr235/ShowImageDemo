package com.mr235.showimagedemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mr235.showimagedemo.adapter.VolleyAdapter;

public class VolleyActivity extends BaseActivity {

	private RecyclerView mRecyclerView;
	private LinearLayoutManager mLayoutManager;

	@Override
	protected void setActivityContentView() {
		setContentView(R.layout.activity_volley);
	}

	@Override
	protected void initView() {
		mRecyclerView = (RecyclerView) findViewById(R.id.rv);
	}

	@Override
	protected void initData() {
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(new VolleyAdapter(this));
	}
}
