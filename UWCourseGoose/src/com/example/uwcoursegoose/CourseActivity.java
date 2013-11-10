package com.example.uwcoursegoose;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class CourseActivity extends Activity {
	
	DatabaseHelper db = new DatabaseHelper(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		
		Intent intent = getIntent();
		String code = intent.getExtras().getString("key");
		Log.d ("COURSE ACTIVITY", code);
		final Course course = db.getCourse(code);
		
		
		TextView courseCode, courseName, review1, review2, review3;
		final EditText userReview;
		final RatingBar userRating, rBar1, rBar2, rBar3;
		Button addReview;
		
		
		courseName = (TextView) findViewById(R.id.course_code_TextView);
		courseCode = (TextView) findViewById(R.id.course_description_TextView);
		addReview = (Button) findViewById(R.id.btnAddReview);
		userRating = (RatingBar) findViewById(R.id.ratingUser);
		userReview = (EditText) findViewById(R.id.editUserReview);
		review1 = (TextView) findViewById(R.id.review1);
		review2 = (TextView) findViewById(R.id.review2);
		review3 = (TextView) findViewById(R.id.review3);
		rBar1 = (RatingBar) findViewById(R.id.reviewBar1);
		rBar2 = (RatingBar) findViewById(R.id.reviewBar2);
		rBar3 = (RatingBar) findViewById(R.id.reviewBar3);
		
		
		courseName.setText(course.courseID);
		courseCode.setText(course.getCourseDescription());
		ArrayList<Double> allRatings = course.getAllRatings();
		ArrayList<String> allComments = course.getAllComments();
		for (int i = 0; i < allComments.size() && i < allRatings.size(); i++)
		{
			if (i == 0)
			{
				review1.setText(allComments.get(i));
				rBar1.setRating((float)course.getLastRating());
			}
			if (i == 1)
			{
				review2.setText(allComments.get(i));
				rBar2.setRating((float)course.getSingleRating(course.ratings.size()-2));
			}
			if (i == 2)
			{
				review3.setText (allComments.get(i));
				rBar3.setRating((float)course.getSingleRating(course.ratings.size()-3));
			}
		}
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
	
	public void getDatabase(DatabaseHelper db2){
		db = db2;
	}

}
