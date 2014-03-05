#@Author Raunaq Suri
#March 3, 2014
#Gets the different units and places them into a file
#PRE: Requries getFaculties.py to already have ran

import json
import urllib.request
import urllib.parse
from pprint import pprint

print("Getting all the Units from the faculties")


baseUrl = "https://api.uwaterloo.ca/v2/codes/units.json"
api_key = input("Enter the api key here: ") #asked to enter api key because having the api key as open source in code is not a smart idea

url = baseUrl+"?key="+api_key

website = urllib.request.urlopen(url)

#gets the user's data
data = json.loads(website.read().decode("utf-8"))

#creates the file to write to

faculties = open('faculties.csv', 'r')

unitFile = open('units.csv', 'w+')
unitFile.write("UnitID,FacultyID\n")

for line in faculties:
	splitLine = line.split(',') #splits line into a list between the comma
	facultyID = splitLine[0]



	if(facultyID == "Faculty ID"):
		pass


	for items in data['data']:

		#gets the names and the faculty codes
		if(items['group_code'] == facultyID):
			unit_code = items['unit_code']
			unitFile.write(unit_code + ","+facultyID+'\n')
			print(unit_code)

		
unitFile.close()
faculties.close()
input("Enter any key to exit: ")
