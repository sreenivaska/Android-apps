package com.enlume.example.loginscreen;




import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter{
	
	private Activity activity;
	private String[] data;
	private String []title;
	private String []code;
	private String []date;
	private String []status;
	private static LayoutInflater inflater=null;
	public ImageLoader imageLoader; 

	 public ImageAdapter(Activity a, String[] d,String[]title,String []code,String []date,String []status) {
		 activity = a;
		 data=d;
		 this.title=title;
		 this.code=code;
		 this.date=date;
		 this.status=status;
		 inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 imageLoader=new ImageLoader(activity.getApplicationContext());
	 }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.length;
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
		public TextView txtCode;
		public TextView txtDate;
		public TextView txtStatus;
		public ImageView image;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi=convertView;
		ViewHolder holder;
		if(convertView==null){
			vi = inflater.inflate(R.layout.listview, null);
			holder=new ViewHolder();
			holder.txtTitle=(TextView)vi.findViewById(R.id.Title);
			holder.txtCode=(TextView)vi.findViewById(R.id.Code);
			holder.txtDate=(TextView)vi.findViewById(R.id.Date);
			holder.txtStatus=(TextView)vi.findViewById(R.id.Status);
			holder.image=(ImageView)vi.findViewById(R.id.image);
			vi.setTag(holder);
		}
		else
			holder=(ViewHolder)vi.getTag();

		holder.txtTitle.setText(title[position]);
		holder.txtCode.setText("Pictage.com/"+code[position]);
		holder.txtDate.setText(date[position]);
		holder.txtStatus.setText(status[position]);
		
		//holder.image.setTag(data[position]);
		if(data[position]!=null){
			holder.image.setTag(data[position]);
			imageLoader.DisplayImage(data[position], activity, holder.image);
		}
		//imageLoader.DisplayImage(data[position], activity, holder.image);
		return vi;

	}

}
