Database:
Student : id, name, grade(int), isEnrolled(boolean)
Teacher: id, name, course


Rest API:
Student : 
          getStudent : GET  http://127.0.0.1:8080/api/student/     return all students as a collection
          getStudentById : GET /api/student/{id}          
                              Response JSON:
                              {
                                "id": "1"
                                "name": "Tom"
                              }

          saveStudent : INSERT  http://127.0.0.1:8080/api/student/{id}/{name}/{grade}/{isEnrolled}
                               Response JSON:
                              {
                                "id": "1"
                                "name": "Tom"
                              }
                              
          updateStudent : POST  http://127.0.0.1:8080/api/student/{id}/{name}/{grade}/{isEnrolled}
                               Response JSON:
                              {
                                "id": "1"
                                "name": "Tom"
                              }
                              
          deleteStudent : DELETE  http://127.0.0.1:8080/api/student/{id} 



