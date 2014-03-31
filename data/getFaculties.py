#@Author Raunaq Suri
#@Date December 31, 2013
#Retrieves all the faculties of Waterloo

import json
import urllib.request
import urllib.parse
from pprint import pprint

print("Getting all the faculties of UW")


baseUrl = "https://api.uwaterloo.ca/v2/codes/groups.json"
api_key = input("Enter the api key here: ") #asked to enter api key because having the api key as open source in code is not a smart idea

url = baseUrl+"?key="+api_key

website = urllib.request.urlopen(url)

#gets the user's data
data = json.loads(website.read().decode("utf-8"))

#creates the file to write to

faculties = open('faculties.csv', 'w+')
faculties.write("Faculty ID,Faculty name,Colour\n")

for items in data['data']:

	#gets the names and the faculty codes
	code = (items['group_code'])
	name = (items['group_short_name'])
	lineToWrite = code+","+name
	if(code == "AHS"):
		lineToWrite +=",turquoise"
	elif(code == "MAT"):
		lineToWrite+=",pink"
	elif(code == "ENG"):
		lineToWrite+=",purple"
	elif(code == "ART"):
		lineToWrite+=",orange"
	elif(code == "SCI"):
		lineToWrite+=",blue"
	elif(code == "ENV"):
		lineToWrite+=",green"
	else:
		lineToWrite+=",null"


	faculties.write(lineToWrite + "\n")

faculties.close()
input("Enter any key to exit: ")
