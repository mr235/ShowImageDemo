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
}
