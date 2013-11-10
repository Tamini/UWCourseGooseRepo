package com.example.uwcoursegoose;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	DatabaseHelper db = new DatabaseHelper(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final float scale = getBaseContext().getResources().getDisplayMetrics().density;

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

		for (int x = 0; x < facultyClick.length; x++) {
			facultyClick[x] = false;
		}

		final LinearLayout engList = (LinearLayout) findViewById(R.id.eng_list);
		LinearLayout.LayoutParams listParams = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		final TextView syde101 = new TextView(this);
		final TextView syde101L = new TextView(this);
		final TextView syde111 = new TextView(this);
		final TextView syde113 = new TextView(this);
		final TextView syde121 = new TextView(this);
		final TextView syde161 = new TextView(this);
		final TextView syde181 = new TextView(this);

		syde101.setLayoutParams(listParams);
		syde101.setText("SYDE 101");
		syde101.setTextSize(9 * scale + 0.5f);
		syde101.setTypeface(tf);
		syde101.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				String code = "SYDE_101";
				System.out.println(code);
				if(event.getAction() == MotionEvent.ACTION_UP) {
					Intent openCourse = new Intent("com.example.uwcoursegoose.COURSEACTIVITY");
					openCourse.putExtra("key", code);
					startActivity(openCourse);
		            return true;
				}
				return false;
			}
		});

		syde101L.setLayoutParams(listParams);
		syde101L.setText("SYDE 101L");
		syde101L.setTextSize(9 * scale + 0.5f);
		syde101L.setTypeface(tf);
		

		syde111.setLayoutParams(listParams);
		syde111.setText("SYDE 111");
		syde111.setTextSize(9 * scale + 0.5f);
		syde111.setTypeface(tf);
		
		syde113.setLayoutParams(listParams);
		syde113.setText("SYDE 113");
		syde113.setTextSize(9 * scale + 0.5f);
		syde113.setTypeface(tf);
		
		syde121.setLayoutParams(listParams);
		syde121.setText("SYDE 121");
		syde121.setTextSize(9 * scale + 0.5f);
		syde121.setTypeface(tf);
		
		syde161.setLayoutParams(listParams);
		syde161.setText("SYDE 161");
		syde161.setTextSize(9 * scale + 0.5f);
		syde161.setTypeface(tf);
		

		syde181.setLayoutParams(listParams);
		syde181.setText("SYDE 181");
		syde181.setTextSize(9 * scale + 0.5f);
		syde181.setTypeface(tf);
		
		listParams.setMargins((int) (10 * scale + 0.5f), 0, 0, 0);

		/*
		 * to use density pixels, we have this scale. when we set a height or
		 * width or something like that, we say the number of density pixels is:
		 * 
		 * pixels = (int) (dps * scale + 0.5f)
		 */

		appTextView.setTypeface(tf);

		ScrollView courseScroll = new ScrollView(this);
		LinearLayout.LayoutParams courseScrollParams = new LinearLayout.LayoutParams(
				(int) (50 * scale + 0.5f), (int) (50 * scale + 0.5f));

		AHSLayout.setClickable(true);
		AHSLayout.setFocusable(true);
		AHSLayout.setEnabled(true);

		OnClickListener headerClick = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				switch (v.getId()) {
				case R.id.ahs_layout:
					if (!facultyClick[0]) {
						AHSArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[0] = true;
					} else {
						AHSArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[0] = false;
					}
					break;
				case R.id.arts_layout:
					if (!facultyClick[1]) {
						artsArrow
								.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[1] = true;
					} else {
						artsArrow
								.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[1] = false;
					}
					break;
				case R.id.engineering_layout:
					if (!facultyClick[2]) {
						engArrow.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[2] = true;
						// engLayout.addView(engList);
						engList.addView(syde101);
						engList.addView(syde101L);
						engList.addView(syde111);
						engList.addView(syde113);
						engList.addView(syde121);
						engList.addView(syde161);
						engList.addView(syde181);

					} else {
						engArrow.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[2] = false;
						engLayout.removeView(engList);
						engList.removeView(syde101);
						engList.removeView(syde101L);
						engList.removeView(syde111);
						engList.removeView(syde113);
						engList.removeView(syde121);
						engList.removeView(syde161);
						engList.removeView(syde181);

					}
					break;
				case R.id.environment_layout:
					if (!facultyClick[3]) {
						enviroArrow
								.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[3] = true;
					} else {
						enviroArrow
								.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[3] = false;
					}
					break;
				case R.id.math_layout:
					if (!facultyClick[4]) {
						mathArrow
								.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[4] = true;
					} else {
						mathArrow
								.setBackgroundResource(R.drawable.triangle_right);
						facultyClick[4] = false;
					}
					break;
				case R.id.science_layout:
					if (!facultyClick[5]) {
						scienceArrow
								.setBackgroundResource(R.drawable.triangle_down);
						facultyClick[5] = true;
					} else {
						scienceArrow
								.setBackgroundResource(R.drawable.triangle_right);
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

		// If the user selects syde101. same for all below
		syde101.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});

		syde101L.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});

		syde111.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});

		syde113.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});

		syde121.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});

		syde161.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});

		syde181.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}

		});

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

	void displayEngCourses() {

	}

}
