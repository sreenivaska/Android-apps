package com.enlume.listcontrols;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class listviewAdapter extends BaseAdapter
{
	public ArrayList<HashMap<String,String>> list;
	Activity activity;
	
	public listviewAdapter(Activity activity, ArrayList<HashMap<String,String>> list) {
		super();
		this.activity = activity;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	private class ViewHolder {
	       TextView txtFirst;
	       TextView txtSecond;
	       TextView txtThird;
	       TextView txtFourth;
	  }

	  
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.d("event:", "Get View Called For Item :"+position);
		// TODO Auto-generated method stub
				ViewHolder holder;
				LayoutInflater inflater =  activity.getLayoutInflater();

				if (convertView == null)
				{
					convertView = inflater.inflate(R.layout.listview_row, null);
					holder = new ViewHolder();
					holder.txtFirst = (TextView) convertView.findViewById(R.id.FirstText);
					holder.txtSecond = (TextView) convertView.findViewById(R.id.SecondText);
					holder.txtThird = (TextView) convertView.findViewById(R.id.ThirdText);
					holder.txtFourth = (TextView) convertView.findViewById(R.id.FourthText);
					convertView.setTag(holder);
				}
				else
				{
					holder = (ViewHolder) convertView.getTag();
				}

				HashMap<String, String> map = list.get(position);
				holder.txtFirst.setText(map.get(Constant.FIRST_COLUMN));
				holder.txtSecond.setText(map.get(Constant.SECOND_COLUMN));
				holder.txtThird.setText(map.get(Constant.THIRD_COLUMN));
				holder.txtFourth.setText(map.get(Constant.FOURTH_COLUMN));

			return convertView;
	}

}