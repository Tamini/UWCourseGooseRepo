#@Author Raunaq Suri
#March 5, 2014
#Same as the others, except gets subjects from the units file
#PRE: Requries getUnitsFromFaculty.py to already have ran

import json
import urllib.request
import urllib.parse
from pprint import pprint

#To prevent sql queries from messing up
def escapeQuotes( string ):
	for char in string:
		if (char == "'"):
			string = string.replace(char, "''")
		elif(char == "\""):
			string = string.replace(char,"\"\"")

	return string

print("Getting all the courses and writing the sql queries")

#gets all the subjects 
baseUrl = "https://api.uwaterloo.ca/v2/courses/"
api_key = input("Enter the api key here: ") #asked to enter api key because having the api key as open source in code is not a smart idea


subjects = open('subjects.csv','r')
courses = open('courses.csv','w+')

#CREATE SQL QUERY FILES HERE
#sqlInsertFile = open('insertTables.sql', 'w+')
#sqlCreateFile = open('createTables.sql', 'w+')
#writes the header
courses.write('Course ID, Course Code, Course Name, Course Description, Faculty ID\n')

for line in subjects:
	splitLine = line.split(',') #splits line into a list between the comma
	subjectName = splitLine[0] #name of the subject
	facultyID = splitLine[1] #faculty
	facultyName = splitLine[2]

	#skips the first line in the file
	if(facultyID == "FacultyID"):
		pass

	#calls the api to get all the courses from that subject
	url = baseUrl + subjectName + ".json?key="+api_key
	print(url)
	website = urllib.request.urlopen(url)

	#gets the user's data
	data = json.loads(website.read().decode("utf-8"))

	#now loops through the courses to get the necessary info
	for items in data['data']:
		#starts getting the required stuff
		#for now I'm just writing to a file all the data we need
		if(items['academic_level'] == "undergraduate"):
			courseID = items['course_id']
			courseCode = items['subject'] + items['catalog_number']
			courseName = items['title']
			courseDescription = items['description']

			#writes to the file
			lineToWrite = courseID + ',' + courseCode +','+ courseName +','+ "\""+courseDescription +"\"" + "," + facultyID +"\n"
			courses.write(lineToWrite)
		
subjects.close()
courses.close()
#sqlInsertFile.close()
#sqlCreateFile.close()
input("Enter any key to exit: ")
