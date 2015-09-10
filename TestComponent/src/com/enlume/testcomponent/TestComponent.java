package com.enlume.testcomponent;



//Need the following import to get access to the app resources, since this
//class is in a sub-package.
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A list view example where the data comes from a custom ListAdapter
 */
public class TestComponent extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use our own list adapter
        setListAdapter(new SpeechListAdapter(this));
    }


    /**
     * A sample ListAdapter that presents content from arrays of speeches and
     * text.
     * 
     */
    private class SpeechListAdapter extends BaseAdapter {
        public SpeechListAdapter(Context context) {
            mContext = context;
        }

        /**
         * The number of items in the list is determined by the number of speeches
         * in our array.
         * 
         * @see android.widget.ListAdapter#getCount()
         */
        public int getCount() {
            return mTitles.length;
        }

        /**
         * Since the data comes from an array, just returning the index is
         * sufficent to get at the data. If we were using a more complex data
         * structure, we would return whatever object represents one row in the
         * list.
         * 
         * @see android.widget.ListAdapter#getItem(int)
         */
        public Object getItem(int position) {
            return position;
        }

        /**
         * Use the array index as a unique id.
         * 
         * @see android.widget.ListAdapter#getItemId(int)
         */
        public long getItemId(int position) {
            return position;
        }

        /**
         * Make a SpeechView to hold each row.
         * 
         * @see android.widget.ListAdapter#getView(int, android.view.View,
         *      android.view.ViewGroup)
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            SpeechView sv;
            if (convertView == null) {
                sv = new SpeechView(mContext, mTitles[position],
                        mDialogue[position]);
            } else {
                sv = (SpeechView) convertView;
                sv.setTitle(mTitles[position]);
                sv.setDialogue(mDialogue[position]);
            }

            return sv;
        }

        /**
         * Remember our context so we can use it when constructing views.
         */
        private Context mContext;

        /**
         * Our data, part 1.
         */
        private String[] mTitles = 
        {
                "Henry IV (1)",   
                "Henry V",
                "Henry VIII",       
                "Richard II",
                "Richard III",
                "Merchant of Venice",  
                "Othello",
                "King Lear"
        };

        /**
         * Our data, part 2.
         */
        private String[] mDialogue = 
        {
                "So shaken as we are, so wan with care,",
                "Hear him but reason in divinity,",

                "I come no more to make you laugh: things now," ,

                "First, heaven be the record to my speech!"  
                ,

                "Now is the winter of our discontent" ,

                "To bait fish withal: if it will feed nothing else," ,

                "Virtue! a fig! 'tis in ourselves that we are thus" + 
                "",

                "Blow, winds, and crack your cheeks! rage! blow!" 
               
        };
    }

    /**
     * We will use a SpeechView to display each speech. It's just a LinearLayout
     * with two text fields.
     *
     */
    private class SpeechView extends LinearLayout {
        public SpeechView(Context context, String title, String words) {
            super(context);

            this.setOrientation(VERTICAL);

            // Here we build the child views in code. They could also have
            // been specified in an XML file.

            mTitle = new TextView(context);
            mTitle.setText(title);
            addView(mTitle, new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            mDialogue = new TextView(context);
            mDialogue.setText(words);
            addView(mDialogue, new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }

        /**
         * Convenience method to set the title of a SpeechView
         */
        public void setTitle(String title) {
            mTitle.setText(title);
        }

        /**
         * Convenience method to set the dialogue of a SpeechView
         */
        public void setDialogue(String words) {
            mDialogue.setText(words);
        }

        private TextView mTitle;
        private TextView mDialogue;
    }
}