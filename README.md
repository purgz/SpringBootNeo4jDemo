# SpringBootNeo4jDemo
Demo project using spring boot with the neo4j data starter for a simple student - department graph database

Also using this project to become familiar with using postman to test REST api using post requests. For example the create student request accepts a json file from 
the body of the post request to fill in the student details which are then updated in the neo4j database.

The program just creates a simple database with student nodes which are related to department nodes. Only one department can have a particular name and if a request is made with a department with no current name then a new department is created.
<hr>
Updated to include simple CRUD requests.

<strong>Create a new student with post:</strong><br>
request param - department with name:<br>
<em>localhost:8080/students/create?department=engineering</em><br>
request body:
```json
{
"name": "testuser",
"birthYear": 1990
}
```

Returns a json of the new student if successfully added to the database.

<strong>Delete a student using delete mapping:<br></strong>
<em>localhost:8080/students/delete/6</em>

Returns a string "Delete student" if successful.

<strong>Read all students with get request</strong><br>
<em>localhost:8080/students/readAll</em>

Returns json with all the student objects.

<strong>Update a student with post request</strong><br>
<em>localhost:8080/students/updatestudent</em>

request body - supply student id and relevant information.
If there is no department with the department name given then a department is created and assigned to that student.
```json
{
    "id": 2,
    "updatedName": "updated testuser",
    "updatedBirthYear": 2005,
    "updatedDepartment": {
        "name": "new department"
    }
}
```
Returns json of updated student object.
<hr>

I used this small project to become more familiar with graph database and creating basic CRUD requests as well as utilizing postman for the first time to test the requests.


