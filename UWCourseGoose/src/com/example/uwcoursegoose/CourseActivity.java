package com.example.uwcoursegoose;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class CourseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		
		final Course course = new Course("SYDE 101");
		
		
		TextView courseCode, courseName, review1, review2, review3;
		final EditText userReview;
		final RatingBar userRating, rBar1, rBar2, rBar3;
		Button addReview;
		
		
		courseCode = (TextView) findViewById(R.id.course_code_TextView);
		courseName = (TextView) findViewById(R.id.course_description_TextView);
		addReview = (Button) findViewById(R.id.btnAddReview);
		userRating = (RatingBar) findViewById(R.id.ratingUser);
		userReview = (EditText) findViewById(R.id.editUserReview);
		review1 = (TextView) findViewById(R.id.review1);
		review2 = (TextView) findViewById(R.id.review2);
		review3 = (TextView) findViewById(R.id.review3);
		rBar1 = (RatingBar) findViewById(R.id.reviewBar1);
		rBar2 = (RatingBar) findViewById(R.id.reviewBar2);
		rBar3 = (RatingBar) findViewById(R.id.reviewBar3);
		
		review1.setText(course.getLastComment());
		rBar1.setRating((float)course.getLastRating());
		
		
		courseName.setText(course.courseID);
		courseCode.setText(course.getCourseDescription());
		addReview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				course.addNewComment(userReview.getText().toString());
				course.addNewRating(userRating.getRating());
				
			}
		});
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.course, menu);
		return true;
	}

}
