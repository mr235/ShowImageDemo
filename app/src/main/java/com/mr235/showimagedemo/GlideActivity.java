package com.mr235.showimagedemo;

import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.mr235.showimagedemo.adapter.GlideAdapter;

import java.io.File;

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
		File sdcard = Environment.getExternalStorageDirectory();
		String cachePath = sdcard + "/Android/data/" + getPackageName() + "/";
		// Glide 设置全局disk cache和memory cache
		new GlideBuilder(this)
				.setMemoryCache(new LruResourceCache(50 * 1024 * 1024))
				.setDiskCache(new InternalCacheDiskCacheFactory(this, cachePath, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE));

	}
}
