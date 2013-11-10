package com.example.uwcoursegoose;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String fontPath = "font/gothic_0.TTF";
		TextView appTextView = (TextView) findViewById(R.id.app_header);
		Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
		appTextView.setTypeface(tf);
		/*to use density pixels, we have this scale. when we set a height or width
		 * or something like that, we say the number of density pixels is:
		 * 
		 * pixels = (int) (dps * scale + 0.5f)*/
		/*final float scale = getBaseContext().getResources().getDisplayMetrics().density;
		
		View masterLayout = findViewById(R.id.main_linear_layout);
		ScrollView courseScroll = new ScrollView(this);		
		LinearLayout.LayoutParams courseScrollParams = new LinearLayout.LayoutParams(
												(int)(50 * scale + 0.5f), (int)(50 * scale + 0.5f));
		
		
		masterLayout.setBackgroundColor(Color.BLACK);
		courseScroll.setBackgroundColor(Color.RED);
		
		masterLayout.add(courseScroll);*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
