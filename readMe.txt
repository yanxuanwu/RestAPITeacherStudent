Database:
Student : id, name
Teacher: id, name


Rest API with JPA:
Student
1. Get all students 

          Request Url : /student

          Request method : GET

          Request Body : null

          Response Body :

          [
              {
                  "id": 4,
                  "name": "Roy",
              },
              {
                  "id": 8,
                  "name": "Ann",
              }
          ]


2. Get Student By id

          Request Url : /student/{id}

          Request method : GET

          Request Parameter : Pathvariable Id

          Response Body :

          {
              "id": 3,
              "name": "Tom",
          }
         
3. Insert Student 

          Request Url : /student

          Request method : PUT

          Request Body :

              {
                  "name": "Ann",
                  "age": 18,
              }
              
          Response Body :

              {
                  "name": "Ann",
                  "age": 18,
              }

4. Delete Student By Id

          Request Url : /student/{id}

          Request Parameter : Pathvariable Id

          Request Body : null

          Response Body : HTTPStatus.NO_CONTENT

          
          
5. Delete Student

          Request Url : /student

          Request method : DELETE

          Request Body : 
              {
                  "name": "Roy",
                  "age": 40
              }

          Response Body : HTTPStatus.NO_CONTENT

         
          
6. Update Student

          Request Url : /student

          Request method : PUT

          Request Body :

              {
                  "name": "Roy",
                  "age": 40
              }
          Response Body :
              
              {
                  "name": "Roy",
                  "age": 40
              }
          
          


Teacher
1. Get all teachers 

          Request Url : /teacher

          Request method : GET

          Request Body : null

          Response Body :

          [
              {
                  "id": 4,
                  "name": "Tiffany",
              },
              {
                  "id": 8,
                  "name": "Bacon",
              }
          ]


2. Get teacher By id

          Request Url : /teacher/{id}

          Request method : GET

          Request Parameter : Pathvariable Id

          Response Body :

          {
              "id": 3,
              "name": "AI",
          }
         
3. Insert teacher

          Request Url : /teacher

          Request method : PUT

          Request Body :

              {
                  "name": "Ann",
                  "age": 18,
              }
              
          Response Body :

              {
                  "name": "Ann",
                  "age": 18,
              }

4. Delete teacher By Id

          Request Url : /teacher/{id}

          Request Parameter : Pathvariable Id

          Request Body : null

          Response Body : HTTPStatus.NO_CONTENT

          
          
5. Delete teacher

          Request Url : /teacher

          Request method : DELETE

          Request Body : 
              {
                  "name": "Roy",
                  "age": 40
              }

          Response Body : HTTPStatus.NO_CONTENT

         
          
6. Update teacher

          Request Url : /teacher

          Request method : PUT

          Request Body :

              {
                  "name": "Roy",
                  "age": 40
              }
          Response Body :
              
              {
                  "name": "Roy",
                  "age": 40
              }
          
         
