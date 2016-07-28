package com.mr235.showimagedemo.util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/6/29.
 */
public class AppUtils {
	private static AppUtils ourInstance = new AppUtils();
	private RequestQueue mQueue;

	public static AppUtils getInstance() {
		return ourInstance;
	}

	private AppUtils() {
	}

	public RequestQueue getVolleyQueue(Context context) {
		if (mQueue==null) {
			mQueue = Volley.newRequestQueue(context.getApplicationContext());
		}
		return mQueue;
	}

	public static void copy(Context context, String content) {
		if (android.os.Build.VERSION.SDK_INT > 11) {
			// 得到剪贴板管理器
			android.content.ClipboardManager cmb = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
			cmb.setText(content);
		} else {
			android.text.ClipboardManager cmb = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
			cmb.setText(content);
		}
	}
}
