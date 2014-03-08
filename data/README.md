***DEPRECATED, NOW ITS WAY EASIER TO ORGANIZE DATA. /subjects from the api contains faculty data as well***

The data to run the queries with. The data is split into partitions because it was way easier to code this way/organize the data.

What we needed was Course,Faculty in a csv, but instead I have to do:

FacultyID,Faculty
UnitID,FacultyID
SubjectID,FacultyID (Subject is derived from the previous line's data file)
Course,FacultyID (Derived from previous data file)

I decided to put them all in different scripts to make it easier to debug. It'd be better if they were all in one script, so I'll consolidate it later.

Contains all the necessary python scripts and the data in csvs. Would not recommend looking at the csvs for courses. Kinda messy due to commas in the description
