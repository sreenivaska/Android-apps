package com.enlume.example.list6;



import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;


public class Container extends View {
	
	 public Container(Context context, AttributeSet attrs) {
	        super(context, attrs);

	        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TileView);
	        a.recycle();
	    }
	 
	 public void setLayout(LayoutParams params){
		 this.setLayoutParams(params);
	 }
	 
	 public void addView(View v){
	
	 }

}
