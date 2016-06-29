package com.mr235.showimagedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.uil).setOnClickListener(this);
		findViewById(R.id.glide).setOnClickListener(this);
		findViewById(R.id.picasso).setOnClickListener(this);
		findViewById(R.id.fresco).setOnClickListener(this);
		findViewById(R.id.volley).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
			case R.id.uil:
				intent = new Intent(this, UILActivity.class);
				startActivity(intent);
				break;
			case R.id.glide:
				intent = new Intent(this, GlideActivity.class);
				startActivity(intent);
				break;
			case R.id.picasso:
				intent = new Intent(this, PicassoActivity.class);
				startActivity(intent);
				break;
			case R.id.fresco:
				intent = new Intent(this, FrescoActivity.class);
				startActivity(intent);
				break;
			case R.id.volley:
				intent = new Intent(this, VolleyActivity.class);
				startActivity(intent);
				break;
		}
	}
}
