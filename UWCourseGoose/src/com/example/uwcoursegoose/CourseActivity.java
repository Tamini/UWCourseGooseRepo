package com.example.uwcoursegoose;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class CourseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		
		TextView courseCode, courseName;
		EditText userReview;
		RatingBar userRating;
		Button addReview;
		
		courseCode = (TextView) findViewById(R.id.tvCourseTitle);
		courseName = (TextView) findViewById(R.id.tvCourseDescription);
		userReview = (EditText) findViewById(R.id.txtUserComment);
		userRating = (RatingBar) findViewById(R.id.rateUser);
		addReview = (Button) findViewById(R.id.btnAddReview);
		
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.course, menu);
		return true;
	}

}
