### Requetes pour initialiser la base de données

```sql
INSERT INTO address VALUES (1,'Happy Street','Delhi'),(2,'2nd Street','Mumbai'),(3,'3rd Street','Delhi'),(4,'any street','Mumbai');
INSERT INTO student (id, first_name, last_name, email, address_id) VALUES (1,'John','Smith','john@gmail.com',1),(2,'Virat','Dave','virat@gmail.com',2),(3,'Steve','Martin','steve@gmail.com',3),(4,'Sachin','Kumar','sachin@gmail.com',4);
INSERT INTO subject (id, subject_name, marks_obtained, student_id) VALUES (1, 'Java', 80, 1), (2, 'MySQL', 70, 1), (3, 'Java', 80, 2), (4, 'MySQL', 70, 2), (5, 'MongoDB', 70, 2), (6, 'MySQL', 70, 3), (7, 'MongoDB', 70, 3), (8, 'Java', 60, 4), (9, 'MongoDB', 50, 4);
```
### Requêtes avec filtre
```graphql
query {
  student(id: 3) {
    email
    firstName
    lastName
    learningSubjects(subjectNameFilter: MongoDB) {
      id
      subjectName
    }
    fullName
  }
}
```

### Requête de modification
```graphql
mutation {
  createStudent(createStudentRequest: {
    firstName: "Alex"
    lastName: "Omar"
    email: "alexomar@gmail.com"
    street: "any street"
    city: "canada"
    subjectsLearning: [
      {
        subjectName: "Java"
        marksObtained: 60.00
      },
      {
        subjectName: "MongoDB"
        marksObtained: 50.00
      }
    ]
  }) {
    id
    firstName
    lastName
    email
    street
    city
    learningSubjects(subjectNameFilter: All) {
      id
      subjectName
      marksObtained
    }
    fullName
  } 
}
```