package com.example.uwcoursegoose;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String fontPath = "font/gothic_0.TTF";
		final TextView appTextView = (TextView) findViewById(R.id.app_header);
		Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
		Spinner spinner = (Spinner) findViewById(R.id.eng_spin);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.eng_array, android.R.layout.simple_spinner_item);
				
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		/*final boolean[] facultyClick = new boolean[6];
		
		for (int x = 0; x < facultyClick.length; x++){
			facultyClick[x] = false;
		}*/
		
		
		/*to use density pixels, we have this scale. when we set a height or width
		 * or something like that, we say the number of density pixels is:
		 * 
		 * pixels = (int) (dps * scale + 0.5f)*/
		final float scale = getBaseContext().getResources().getDisplayMetrics().density;
		
		appTextView.setTypeface(tf);
		
		
		ScrollView courseScroll = new ScrollView(this);		
		LinearLayout.LayoutParams courseScrollParams = new LinearLayout.LayoutParams(
												(int)(50 * scale + 0.5f), (int)(50 * scale + 0.5f));
		
		/*AHSLayout.setClickable(true);
		AHSLayout.setFocusable(true);
		AHSLayout.setEnabled(true);
		
		AHSLayout.setOnClickListener
		
		OnClickListener headerClick = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()){
				case R.id.ahs_layout:
					AHSArrow.setBackgroundResource(R.drawable.triangle_down);
					facultyClick[0] = true;
					break;
				case R.id.arts_layout:
				}
			}
			
		};*/
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.print("asdfkj");
	}

}
