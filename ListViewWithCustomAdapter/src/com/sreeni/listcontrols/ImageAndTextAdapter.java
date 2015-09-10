package com.sreeni.listcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAndTextAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	
	private String[] strings;
	private String[] capitals;
	private TypedArray icons;
	
	private int viewResourceId;
	
	public ImageAndTextAdapter(Context ctx, int viewResourceId,
			String[] strings,String[] capitals, TypedArray icons) {
		super();
		
		this.inflater = (LayoutInflater)ctx.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		
		this.strings = strings;
		this.capitals=capitals;
		this.icons = icons;
		
		this.viewResourceId = viewResourceId;
	}

	@Override
	public int getCount() {
		return strings.length;
	}

	@Override
	public String getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d("event:", "Get View Called For Item :"+position);
		convertView = inflater.inflate(viewResourceId, null);
		
		ImageView iv = (ImageView)convertView.findViewById(R.id.option_icon);
		iv.setImageDrawable(icons.getDrawable(position));

		TextView tv = (TextView)convertView.findViewById(R.id.option_text);
		tv.setText(strings[position]);
		
		TextView tvc = (TextView)convertView.findViewById(R.id.cap_text);
		tvc.setText(capitals[position]);
		
		return convertView;
	}
}
