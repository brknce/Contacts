# Contacts
The candidate should write a web API that is able to import a batch of contacts from Postman into a database, avoiding duplicate records; and display relevant records when searched by name.


Objective <br/>
Application should have two endpoints:
<br/><br/>
POST /contacts  <br/>
GET /contacts?name=...  <br/> <br/>
The import request is always a JSON request containing an arbitrary number of contacts, each of
which has the following schema:
 <br/> <br/>
{ <br/>
"name": "Ahmet", <br/>
"lastName": "Mehmet", <br/>
"phone": "+90 555 222 33 44" <br/>
}
 <br/> <br/>
Within the contacts to import; there can be duplicate records, or those which are repeated but with
different phone numbers. These records must be merged, and the final elements on the database
should have phone numbers as a set of elements. <br/> <br/>
The contacts should be saved on a MySQL table, where they are searched only by name field. <br/> <br/>
Response of a search should have at least the following structure: <br/> <br/>
{ <br/>
"name": "Ahmet", <br/>
"lastName": "Mehmet", <br/>
"phones": ["+90 555 222 33 44", "+90 555 666 77 88"] <br/>
}
