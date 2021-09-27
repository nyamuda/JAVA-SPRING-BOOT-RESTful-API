# JAVA-SPRING-BOOT-RESTful-API
A RESTful API for A 'Level physics and chemistry students. It provides the exam definitions of physics and chemistry terms required by the curriculum (Cambridge/CAPS).

<h2>Motivation</h2>
One of the main reasons students fail physics and chemistry exams is the inability to define and state physics and chemistry terms properly. In physics and chemistry, unlike other subjects, terms are required to be defined in a specific way and must contain specific keywords. Failure to do so means losing marks. As  a part-time teacher who has been teaching physics and chemistry for 3 years, I’ve seen that a lot of science students struggle with definitions and some don’t even don’t even know how to properly define a term in a way required by their curriculum. It is this  API’s aim  to help such students. The API’s main focus is on Cambridge A’ level and CAPS matric students.

<h2>Build Status</h2>
New terms are still being added to the database. So there aren't a lot of terms yet.

<h2>Screenshots</h2> 
The structure of the database is as follows:
<image src="https://github.com/pnyamuda/Data-Engineering-University-Courses/blob/master/sciencetermsdatabase.png?raw=true">

<h2>Tech/Framework used</h2>
Java, Spring Boot, Hibernate & MySQL.
The API uses JSON Web Tokens for authentication and authorization.

<h2>How to Use?</h2>
To use the API, the user needs register first and the following fields are required:</br>
<code>
{
username:””,
password:””, 
firstName:””,
secondName:””,
curriculum:{
  id:""
  }
}
</code>

Once the registration is successful, the user is added to the database with the role of “user” and they can login to access the API.</br>
To login:</br>
<code>
{
“username””,
“password”:””
}</br>
//the route is /login
</code>
</br>
Once the user logs in, the API will send a token(lasts for 24hrs) that the user can use to access the API.

<h3>Routes the user can access are:</h3></br>
<h4>Curriculums</h4>
1. To get all the curriculums:</br>
<code>/curriculums</code></br>
2. To get a particular curriculum:</br>
<code>/curriculum/{id}</code></br>

<h4>Subjects</h4>
1. To get all the subjects for a curriculum:</br>
<code>curriculum/{curriculumId}/subjects</code></br>
2. To get a particular subject:</br>
<code>subject/{id}</code></br>

<h4>Topics</h4>
1. To get all the topics for a particular curriculum and subject:</br>
<code>subject/{subjectId}/curriculum/{curriculumId}/topics</code></br>
2. To get a particular topic:</br>
<code>topic/{topicId}</code></br>

<h4>Terms</h4>
1. To get all the terms for particular curriculum and subject:</br>
<code>curriculum/{curriculumId}/subject/{subjectId}/terms</br></code></br>
2. To access all the terms for particular curriculum and topic:</br>
<code>curriculum/{curriculumId}/topic/{topicId}/terms</code></br>
3. To get a particular term:</br>
<code>/term/{id}</code></br>
4. To search for a particular term:</br>
<code>curriculum/{curriculumId}/term/{termName}</code></br>
5. To get the definition of a term:</br>
<code>curriculum/{curriculumId}/term/{termId}/definition</code>

