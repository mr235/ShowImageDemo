package com.mr235.showimagedemo.adapter;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.mr235.showimagedemo.Constants;
import com.mr235.showimagedemo.R;
import com.mr235.showimagedemo.util.AppUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

/**
 * Created by Administrator on 2016/6/29.
 */
public class UilAdapter extends RecyclerView.Adapter<UilAdapter.ViewHolder> {
	private DisplayImageOptions options;
	public UilAdapter() {

		options =    new DisplayImageOptions.Builder()
				.showImageOnLoading(R.mipmap.ic_launcher) // resource or drawable
				.showImageForEmptyUri(R.drawable.ic_empty) // resource or drawable
				.showImageOnFail(R.drawable.ic_error) // resource or drawable
				.resetViewBeforeLoading(false)  // default
				.delayBeforeLoading(1000)
				.cacheInMemory(true) // default
				.cacheOnDisk(true) // default
//				.preProcessor(...)
//		.postProcessor(...)
//		.extraForDownloader(...)
				.considerExifParams(true) // default
				.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
				.bitmapConfig(Bitmap.Config.ARGB_4444) // default
//				.decodingOptions(...)
				.displayer(new FadeInBitmapDisplayer(250)) // default
				.handler(new Handler()) // default
				.build();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		String url = Constants.PIC_BIG[position];
		ImageLoader.getInstance().displayImage(url, holder.mImageView, options);

		holder.mImageView.setTag(url);
		holder.mImageView.setOnClickListener(clickListener);
	}

	private View.OnClickListener clickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			String url = (String) v.getTag();
			AppUtils.copy(v.getContext(), url);
			Toast.makeText(v.getContext(), "图片地址已复制", Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	public int getItemCount() {
		return Constants.PIC_BIG.length;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {

		ImageView mImageView;

		public ViewHolder(View itemView) {
			super(itemView);
			mImageView = (ImageView) itemView.findViewById(R.id.iv);
		}
	}
}
