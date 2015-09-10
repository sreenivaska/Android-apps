package com.enlume.example.hellospinner;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HelloSpinner extends Activity {
	private TextView tv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        tv = (TextView)findViewById(R.id.text);
        
       // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
              //  this, R.array.planets_array, android.R.layout.simple_list_item_1);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        ArrayAdapter<String> adpt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,COUNTRIES);
        adpt.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adpt);
       
        spinner.setSelection(4, true);
        tv.setText(spinner.getSelectedItem().toString());
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
        
        
        
    }
    
    
    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {
          Toast.makeText(parent.getContext(), "The planet is " +
              parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
        }

        public void onNothingSelected(AdapterView<?> parent) {
          // Do nothing.
        }
    }
    
    static final String[] COUNTRIES= new String[]{
    	"Afganistan","Albania","India","Pakistan","Srilanka",
    	"Bangladesh","Nepal","UK","Japan","Jermany","US","Zimbawe"
    };
}