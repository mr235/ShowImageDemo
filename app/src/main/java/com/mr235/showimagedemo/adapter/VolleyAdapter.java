package com.mr235.showimagedemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mr235.showimagedemo.Constants;
import com.mr235.showimagedemo.R;
import com.mr235.showimagedemo.util.AppUtils;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;

/**
 * Created by Administrator on 2016/6/29.
 */
public class VolleyAdapter extends RecyclerView.Adapter<VolleyAdapter.ViewHolder> {

	private final ImageLoader imageLoader;

	public VolleyAdapter(Context context) {
		imageLoader = new ImageLoader(AppUtils.getInstance().getVolleyQueue(context), new BitmapCache());
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_volley, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		String url = Constants.PIC_BIG[position];
		holder.mImageView.setDefaultImageResId(R.drawable.ic_empty);
		holder.mImageView.setErrorImageResId(R.drawable.ic_error);
		holder.mImageView.setImageUrl(url, imageLoader);
	}

	@Override
	public int getItemCount() {
		return Constants.PIC_BIG.length;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		NetworkImageView mImageView;

		public ViewHolder(View itemView) {
			super(itemView);
			mImageView = (NetworkImageView) itemView.findViewById(R.id.iv);
		}
	}
	public class BitmapCache implements ImageLoader.ImageCache {

		private LruCache<String, Bitmap> mCache;

		public BitmapCache() {
			int maxSize = 10 * 1024 * 1024;
			mCache = new LruCache<String, Bitmap>(maxSize) {
				@Override
				protected int sizeOf(String key, Bitmap bitmap) {
					return bitmap.getRowBytes() * bitmap.getHeight();
				}
			};
		}

		@Override
		public Bitmap getBitmap(String url) {
			return mCache.get(url);
		}

		@Override
		public void putBitmap(String url, Bitmap bitmap) {
			mCache.put(url, bitmap);
		}

	}
}
