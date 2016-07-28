package com.mr235.showimagedemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mr235.showimagedemo.Constants;
import com.mr235.showimagedemo.R;
import com.mr235.showimagedemo.util.AppUtils;

/**
 * Created by Administrator on 2016/6/29.
 */
public class FrescoAdapter extends RecyclerView.Adapter<FrescoAdapter.ViewHolder> {
	public FrescoAdapter() {
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_fresco, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		String url = Constants.PIC_BIG[position];
		holder.mImageView.setImageURI(url);
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

		SimpleDraweeView mImageView;

		public ViewHolder(View itemView) {
			super(itemView);
			mImageView = (SimpleDraweeView) itemView.findViewById(R.id.sdv);
		}
	}
}
