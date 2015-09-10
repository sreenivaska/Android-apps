package com.enlume.examples.imagelist;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAndTextListAdapter extends ArrayAdapter<ImageAndText> {
	    public ImageAndTextListAdapter(Activity activity, List<ImageAndText> imageAndTexts) {
		        super(activity, 0, imageAndTexts);
	
	    }
	
	    @Override
	
	    public View getView(int position, View convertView, ViewGroup parent) {
	
	        Activity activity = (Activity) getContext();
	
	        LayoutInflater inflater = activity.getLayoutInflater();
	
	        // Inflate the views from XML
	
	        View rowView = inflater.inflate(R.layout.image, null);

	        ImageAndText imageAndText = getItem(position);
	
	 
	   // Load the image and set it on the ImageView
	
	        ImageView imageView = (ImageView) rowView.findViewById(R.id.image1);
	
	        imageView.setImageDrawable(loadImageFromUrl(imageAndText.getImageUrl()));
	
	 
	
	        // Set the text on the TextView
	
	        TextView textView = (TextView) rowView.findViewById(R.id.text);
	
	        textView.setText(imageAndText.getText());
	
	 
	
	        return rowView;
	
	    }
	
	 

	    public static Drawable loadImageFromUrl(String url) {
	
	        InputStream inputStream;
	
	        try {
	        	inputStream = new URL(url).openStream();
	
	        } catch (IOException e) {
	
	            throw new RuntimeException(e);
	
	        }
	
	        return Drawable.createFromStream(inputStream, "src");
	
	    }
	
	}

