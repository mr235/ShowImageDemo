package com.mr235.showimagedemo.util;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;

/**
 * add request headers
 */
public class GlideSetup implements GlideModule {
	@Override
	public void applyOptions(Context context, GlideBuilder builder) { /* no costumization */ }

	@Override
	public void registerComponents(Context context, Glide glide) {
		glide.register(String.class, InputStream.class, new HeaderedLoader.Factory());
	}

	private static class HeaderedLoader extends BaseGlideUrlLoader<String> {
		public static final Headers HEADERS = new LazyHeaders.Builder()
				.addHeader("User-Agent", "----user-agent")
				.addHeader("App-Agent", "-----app-agent")
				.build();

		public HeaderedLoader(Context context) {
			super(context);
		}

		@Override
		protected String getUrl(String model, int width, int height) {
			return model;
		}

		@Override
		protected Headers getHeaders(String model, int width, int height) {
			return HEADERS;
		}

		public static class Factory implements ModelLoaderFactory<String, InputStream> {
			@Override
			public StreamModelLoader<String> build(Context context, GenericLoaderFactory factories) {
				return new HeaderedLoader(context);
			}

			@Override
			public void teardown() { /* nothing to free */ }
		}
	}
}