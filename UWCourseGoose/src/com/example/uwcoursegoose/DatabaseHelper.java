package com.example.uwcoursegoose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* Handles all database methods, including getting and inserting rows
 * @author Tristan Amini
 * @date November, 2013
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String dbName = "courseDB";
	private static final int dbVersion = 1;
	private static final String KEY_ID = "id";
	private static final String KEY_COMMENT = "Comment";
	private static final String KEY_RATING = "Rating";
	
	private static final String[] COLUMNS = {KEY_ID, KEY_COMMENT, KEY_RATING};
	
	public DatabaseHelper(Context context) {
		super(context, dbName, null, dbVersion);
		
	}

	/* Method run to create tables
	 * @param SQLiteDatabase db	the database to add the tables too
	 */
	public void onCreate(SQLiteDatabase db) {
		String [] courseCodes = new String[7];
		courseCodes[0] = "SYDE_101";
		courseCodes[1] = "SYDE_101L";
		courseCodes[2] = "SYDE_111";
		courseCodes[3] = "SYDE_113";
		courseCodes[4] = "SYDE_121";
		courseCodes[5] = "SYDE_161";
		courseCodes[6] = "SYDE_181";
		// Create all tables
		for (int table = 0; table < courseCodes.length; table++)
		{
			db.execSQL("CREATE TABLE " + courseCodes[table] + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Comments TEXT, "+
                "Rating TEXT )");
		}
	}

	/* Currently unused onUpgrade method
	 * @param SQLiteDatabase db	the database to upgrade
	 * @param int oldVersion	the previous version of the database
	 * @param int newVersion 	the databse version being upgraded to
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	/* Adds a row including rating and comment to the given course table
	 * @param Course course	the course to modify the table of
	 */
	public void addRating(Course course)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put (KEY_COMMENT, course.getLastComment());
		values.put (KEY_RATING, course.getLastRating());
		db.insert(course.courseID, null, values);
		Log.d("Database add Rating", "Rating added");
	}
	
	/* Retrieves a course table from the database
	 * @param String courseID	the course to return
	 * @return 					the course object containing all the comments and ratings
	 */
	public Course getCourse(String courseID)
	{
		Course toReturn = new Course(courseID);
		String query = "SELECT * FROM " + courseID;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor myCursor = db.rawQuery(query, null);
		// Add ratings/comments to course
		if (myCursor.moveToFirst())
		{
			do {
				toReturn.addNewComment(myCursor.getString(1));
				toReturn.addNewRating(Double.parseDouble(myCursor.getString(2)));
				
			}while (myCursor.moveToNext());
		}
		
			return toReturn;
	}
	
}
