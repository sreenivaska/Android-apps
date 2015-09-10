package com.enlume.customlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class CustomList extends ListView{

	public CustomList(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		
	}

	public CustomList(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	public CustomList(Context context) {
		super(context);
		
	}

}

class CustomAdapter extends BaseAdapter{
	
	private Object []item;
	private View []view;
	private int numberOfViews;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return item[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setNumberOfView(int c){
		numberOfViews =c;
		view = new View[numberOfViews];
	}
	
}
