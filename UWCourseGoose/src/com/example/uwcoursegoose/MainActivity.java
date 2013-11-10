package com.example.uwcoursegoose;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String fontPath = "font/gothic_0.TTF";
		final TextView appTextView = (TextView) findViewById(R.id.app_header);
		Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
		final RelativeLayout AHSLayout = (RelativeLayout) findViewById(R.id.ahs_layout);
		final RelativeLayout artsLayout = (RelativeLayout) findViewById(R.id.arts_layout);
		final RelativeLayout engLayout = (RelativeLayout) findViewById(R.id.engineering_layout);
		final RelativeLayout enviroLayout = (RelativeLayout) findViewById(R.id.environment_layout);
		final RelativeLayout mathLayout = (RelativeLayout) findViewById(R.id.math_layout);
		final RelativeLayout scienceLayout = (RelativeLayout) findViewById(R.id.science_layout);

		final ImageView AHSArrow = (ImageView) findViewById(R.id.ahs_arrow);
		final ImageView artsArrow = (ImageView) findViewById(R.id.arts_arrow);
		final ImageView engArrow = (ImageView) findViewById(R.id.engineering_arrow);
		final ImageView enviroArrow = (ImageView) findViewById(R.id.environment_arrow);
		final ImageView mathArrow = (ImageView) findViewById(R.id.math_arrow);
		final ImageView scienceArrow = (ImageView) findViewById(R.id.science_arrow);

		final boolean[] facultyClick = new boolean[6];
		
		for (int x = 0; x < facultyClick.length; x++){
			facultyClick[x] = false;
		}
		
		
		/*to use density pixels, we have this scale. when we set a height or width
		 * or something like that, we say the number of density pixels is:
		 * 
		 * pixels = (int) (dps * scale + 0.5f)*/
		final float scale = getBaseContext().getResources().getDisplayMetrics().density;
		
		appTextView.setTypeface(tf);
		
		
		ScrollView courseScroll = new ScrollView(this);		
		LinearLayout.LayoutParams courseScrollParams = new LinearLayout.LayoutParams(
												(int)(50 * scale + 0.5f), (int)(50 * scale + 0.5f));
		
		AHSLayout.setClickable(true);
		AHSLayout.setFocusable(true);
		AHSLayout.setEnabled(true);
		
		OnClickListener headerClick = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				switch (v.getId()){
				case R.id.ahs_layout:
					if (!facultyClick[0]){
						AHSArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[0] = true;
					}
					else{
						AHSArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[0] = false;
					}
					break;
				case R.id.arts_layout:
					if (!facultyClick[1]){
						artsArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[1] = true;
					}
					else {
						artsArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[1] = false;
					}
					break;
				case R.id.engineering_layout:
					if (!facultyClick[2]){
						engArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[2] = true;
					}
					else {
						engArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[2] = false;
					}
					break;
				case R.id.environment_layout:
					if (!facultyClick[3]){
						enviroArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[3] = true;
					}
					else {
						enviroArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[3] = false;
					}
					break;
				case R.id.math_layout:
					if (!facultyClick[4]){
						mathArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[4] = true;
					}
					else {
						mathArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[4] = false;
					}
					break;
				case R.id.science_layout:
					if (!facultyClick[5]){
						scienceArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[5] = true;
					}
					else{
						scienceArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[5] = false;
					}
					break;

				}
			}
			
		};
		
		AHSLayout.setOnClickListener(headerClick);
		artsLayout.setOnClickListener(headerClick);
		engLayout.setOnClickListener(headerClick);
		enviroLayout.setOnClickListener(headerClick);
		mathLayout.setOnClickListener(headerClick);
		scienceLayout.setOnClickListener(headerClick);
		
		
		
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
