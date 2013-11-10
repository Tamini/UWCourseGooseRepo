/**
 * 
 */
package com.example.uwcoursegoose;

/**
 * @author Raunaq Suri
 * The class Course which contains all the necessary methods pertaining to the courses
 * and the methods associated with it
 *
 */
import java.util.ArrayList;
import java.lang.String;
public class Course {
	
	//Required data structures
	public String courseID;
	public String courseDescription;
	ArrayList<Double> ratings = new ArrayList<Double>();
	ArrayList<String> comments = new ArrayList<String>();
	private int facultyID = 3;
	
	public static final int AHS_ID = 1, A_ID = 2,
			ENG_ID = 3, ENVIRO_ID = 4, MATH_ID = 5, SCI_ID = 6;
	
	//Constructor
	public Course(String course){
		/**
		 * Set the course's code to the one you want
		 * @param CourseID
		 */
		courseID = course;
		this.addNewRating(5.0);
		this.addNewComment("No comment.");
		this.setFacultyID(ENG_ID);
		
	}
	
	public void setCourseDescription(String courseDesc){
		/**
		 * Create's the course's description
		 * @param Course's description
		 */
		courseDescription = courseDesc;
		
	}
	
	public void setFacultyID(final int ID)
	{
		facultyID = ID;
	}
	
	public final int getFacultyID(){
		return facultyID;
	}
	public void addNewRating(double indiRating){
		/**
		 * Adds a rating
		 * @param rating to be added
		 */
		ratings.add(indiRating);
	}
	
	public void addNewComment(String comment){
		/**
		 * Adds a comment associated to this course
		 *@param comment to be included
		 */
		comments.add(comment);
	}
	
	public String getSingleComment(int index){
		/**
		 * Returns the comment at that index
		 * @param the index you wish to retrieve from
		 * @return rating at the index
		 */
		return comments.get(index);
	}
	
	public double getSingleRating (int index)
	{
		/**
		 * Returns the rating at that index
		 * @param the index you wish to retrieve from
		 * @return rating at the index
		 */
		return ratings.get(index);
	}
	
	public String getLastComment ()
	{
		return comments.get(comments.size());
	}
	
	public double getLastRating ()
	{
		return ratings.get(ratings.size());
	}
	
	public double getTotalAverage(){
		/**Calculates the total average in all of the ratings
		 * @return Average of all the ratings
		 */
		//Calculates the sum of all the ratings
		double average;
		double sum = 0;
		
		for(int i=0; i< ratings.size(); i++)
		{
			sum+= ratings.get(i);
		}
		
		//Calculates the average
		average = (sum / ratings.size() );
		
		return average;
	}
	
	public String toString(){
		return (courseID + " Desc: "+ courseDescription);
	}

}