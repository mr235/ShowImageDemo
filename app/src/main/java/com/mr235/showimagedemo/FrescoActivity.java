package com.mr235.showimagedemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mr235.showimagedemo.adapter.FrescoAdapter;

public class FrescoActivity extends BaseActivity {


	private RecyclerView mRecyclerView;
	private LinearLayoutManager mLayoutManager;

	@Override
	protected void setActivityContentView() {
		setContentView(R.layout.activity_fresco);
	}

	@Override
	protected void initView() {
		mRecyclerView = (RecyclerView) findViewById(R.id.rv);
	}

	@Override
	protected void initData() {
		Fresco.initialize(this);
		mLayoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(new FrescoAdapter());
	}
}
