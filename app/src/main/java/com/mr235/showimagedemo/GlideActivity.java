package com.mr235.showimagedemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mr235.showimagedemo.adapter.GlideAdapter;

public class GlideActivity extends BaseActivity {

	private RecyclerView mRecyclerView;
	private LinearLayoutManager mLayoutManager;

	@Override
	protected void setActivityContentView() {
		setContentView(R.layout.activity_glide);
	}

	@Override
	protected void initView() {
		mRecyclerView = (RecyclerView) findViewById(R.id.rv);
	}

	@Override
	protected void initData() {
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(new GlideAdapter());

	}
}
