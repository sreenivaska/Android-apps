package com.enlume.events;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Ball extends View {

	private  float x;
	private float y;
	private  int r;
	private  Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

	public Ball(Context context, float x, float y, int r) {
		super(context);
		// TODO Auto-generated constructor stub
		mPaint.setColor(0xFFFF0000);
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	 @Override
	 protected void onDraw(Canvas canvas) {
	     super.onDraw(canvas);
	     canvas.drawCircle(x, y, r, mPaint);
	    // canvas.drawRect(x,y,r,r,mPaint);
	 }

}
