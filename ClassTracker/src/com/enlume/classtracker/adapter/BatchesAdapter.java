package com.enlume.classtracker.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.enlume.classtracker.activity.AddClassActivity;
import com.enlume.classtracker.activity.ListClassesActivity;
import com.enlume.classtracker.activity.R;
import com.enlume.classtracker.activity.UpdateBatchActivity;
import com.enlume.classtracker.db.Database;
import com.enlume.classtracker.vo.Batch;

public class BatchesAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private ArrayList<Batch> batches;

	public BatchesAdapter(Context ctx) {
		inflater = LayoutInflater.from(ctx);
		batches = Database.getBatches(ctx);
	}

	public int getCount() {
		return batches.size();
	}

	public Object getItem(int pos) {
		return batches.get(pos);
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.batch, null);
			Button btnClasses = (Button) convertView.findViewById(R.id.btnClasses);
			Button btnUpdate = (Button) convertView.findViewById(R.id.btnUpdate);
			Button btnAddClass = (Button) convertView.findViewById(R.id.btnAddClass);
			
            final Batch batch = batches.get(position);

            TextView textCode = (TextView) convertView.findViewById(R.id.textCode);
			textCode.setText( batch.getCode());
			
			TextView textCourse = (TextView) convertView.findViewById(R.id.textCourse);
			textCourse.setText( batch.getCourse());
			
			TextView textStartDate = (TextView) convertView.findViewById(R.id.textStartDate);
			textStartDate.setText(batch.getStartdate());
			
			TextView textEndDate = (TextView) convertView.findViewById(R.id.textEndDate);
			textEndDate.setText(batch.getEnddate());
			
			btnClasses.setOnClickListener(new OnClickListener() {
				public void onClick(View view) {
				    Context context = view.getContext();
					Intent intent = new Intent(context, ListClassesActivity.class);
					intent.putExtra("batchcode",batch.getCode());
					context.startActivity(intent);
				}
			});
			
			
			btnAddClass.setOnClickListener(new OnClickListener() {
				public void onClick(View view) {
				    Context context = view.getContext();
					Intent intent = new Intent(context, AddClassActivity.class);
					intent.putExtra("batchcode",batch.getCode());
					context.startActivity(intent);
				}
			});
			
			
			
			btnUpdate.setOnClickListener(new OnClickListener() {
				public void onClick(View view) {
					
					Context context = view.getContext();
					Intent intent = new Intent(context, UpdateBatchActivity.class);
					intent.putExtra("batchcode",batch.getCode());
					context.startActivity(intent);
				}
			});
		}
		return convertView;
	}
}
