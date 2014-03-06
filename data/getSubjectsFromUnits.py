#@Author Raunaq Suri
#March 5, 2014
#Same as the others, except gets subjects from the units file
#PRE: Requries getUnitsFromFaculty.py to already have ran

import json
import urllib.request
import urllib.parse
from pprint import pprint

print("Getting all the subjects from the units. This is goddamn annoying, but the intermediary data may prove to be useful")

#gets all the subjects 
baseUrl = "https://api.uwaterloo.ca/v2/codes/subjects.json"
api_key = input("Enter the api key here: ") #asked to enter api key because having the api key as open source in code is not a smart idea

url = baseUrl+"?key="+api_key

website = urllib.request.urlopen(url)

#gets the user's data
data = json.loads(website.read().decode("utf-8"))

#creates the file to write to

units = open('units.csv', 'r')

subjectFile = open('subjects.csv', 'w+')
subjectFile.write("SubjectID,FacultyID\n")

#sorts all the units by units + alphabetically and then writes it in a CSV

for line in units:
	splitLine = line.split(',') #splits line into a list between the comma
	unitName = splitLine[0] #name of the unit
	facultyID = splitLine[1] #faculty



	if(unitName == "UnitID"):
		pass #skips header


	for items in data['data']:

		#writes the subject name followed by the faculty
		if(items['unit'] == unitName):
			subject = items['subject']
			subjectFile.write(subject + ","+facultyID)


		
subjectFile.close()
units.close()
input("Enter any key to exit: ")