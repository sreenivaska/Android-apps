package com.enlume.customcomponent.labelview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class LabelView extends View {

	private Paint mTextPaint;
	private String mText;
	private int mAscent;
	
	public LabelView(Context context) {
		super(context);
		initLabelView();
		// TODO Auto-generated constructor stub
	}
	
	public LabelView(Context context,AttributeSet attr){
		super(context,attr);
		initLabelView();
		
		TypedArray a = context.obtainStyledAttributes(attr,R.styleable.LabelView);
		
	}
	
	
	private final void initLabelView() {
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(16);
        mTextPaint.setColor(0xFF000000);
        setPadding(3, 3, 3, 3);
    }

}
