Database:
Student : id, name, grade(int), isEnrolled(boolean)
Teacher: id, name, course


Rest API:
Student : 
          getStudent : GET /api/student/{name}
          getStudentById : GET /api/student/{id}
          saveStudent : INSERT /api/student/{id}
          updateStudent : POST /api/student/{id}
          deleteStudent : DELETE /api/student/{id}     


Request JSON:
{
  "id": "1"
  "name": "Tom"
}

