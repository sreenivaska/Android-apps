package com.enlume.textwithimage;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
	
	private Activity activity;
	private String []title;
	private Integer []imageIds;
	private static LayoutInflater inflater=null;
	

	 public CustomAdapter(Activity a, String[]title,Integer imageIds[]) {
		 activity = a;
		 this.title=title;
		 this.imageIds=imageIds;
		 inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public static class ViewHolder{
		public TextView txtTitle;
		public ImageView image;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi=convertView;
		ViewHolder holder;
		if(convertView==null){
			vi = inflater.inflate(R.layout.list, null);
			holder=new ViewHolder();
			holder.txtTitle=(TextView)vi.findViewById(R.id.Title);
			holder.image=(ImageView)vi.findViewById(R.id.image);
			vi.setTag(holder);
		}
		else
			holder=(ViewHolder)vi.getTag();

		holder.txtTitle.setText(title[position]);
		holder.image.setImageResource(imageIds[position]);
		return vi;

	}

}
