package com.enlume.example.galleryexample;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener; 

public class GalleryExample extends Activity {

     private Gallery gallery;

 

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
       // gallery(Gallery) findViewById()
         gallery = (Gallery) findViewById(R.id.examplegallery);
         gallery.setAdapter(new AddImgAdp(this));
 
         gallery.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView parent, View v, int position, long id) {
// Displaying the position when the gallery item in clicked

                Toast.makeText(GalleryExample.this, "Position=" + position, Toast.LENGTH_SHORT).show();

            }

        });

    }

    public class AddImgAdp extends BaseAdapter {

        int GalItemBg;
        private Context cont;

 

// Adding images.

        private Integer[] Imgid = {

                R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5

        };

 

        public AddImgAdp(Context c) {

            cont = c;
            TypedArray typArray = obtainStyledAttributes(R.styleable.GalleryTheme);

            GalItemBg = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
            typArray.recycle();
        }

 
       public int getCount() {

            return Imgid.length;

        }
        public Object getItem(int position) {
            return position;

        }
        public long getItemId(int position) {
            return position;

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgView = new ImageView(cont);
            imgView.setImageResource(Imgid[position]);

// Fixing width & height for image to display

            imgView.setLayoutParams(new Gallery.LayoutParams(80, 70));

            imgView.setScaleType(ImageView.ScaleType.FIT_XY);

            imgView.setBackgroundResource(GalItemBg);

 

            return imgView;

        }

    }

 

}
