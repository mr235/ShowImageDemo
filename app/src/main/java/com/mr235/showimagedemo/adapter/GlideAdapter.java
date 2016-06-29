package com.mr235.showimagedemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mr235.showimagedemo.Constants;
import com.mr235.showimagedemo.R;

/**
 * Created by Administrator on 2016/6/29.
 */
public class GlideAdapter extends RecyclerView.Adapter<GlideAdapter.ViewHolder> {
	public GlideAdapter() {
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

		Glide.with(holder.itemView.getContext())
				.load(url)
				.centerCrop()
				.placeholder(R.drawable.ic_empty)
				.crossFade()
				.into(holder.mImageView);
	}

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
