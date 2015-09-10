package com.enlume.listcontrols;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter
{
	private ArrayList<String> listCountry;
	private ArrayList<Integer> listFlag;
	private Activity activity;

	public GridviewAdapter(Activity activity,ArrayList<String> listCountry, ArrayList<Integer> listFlag) {
		super();
		this.listCountry = listCountry;
		this.listFlag = listFlag;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listCountry.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return listCountry.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflator = activity.getLayoutInflater();

		convertView = inflator.inflate(R.layout.gridview_row, null);

		TextView textView= (TextView) convertView.findViewById(R.id.textView1);
		ImageView imageView= (ImageView) convertView.findViewById(R.id.imageView1);


		textView.setText(listCountry.get(position));
		imageView.setImageResource(listFlag.get(position));

		return convertView;
	}

}
