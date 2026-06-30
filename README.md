# 🎓 UniPortal

A modern **Student Management System** built using **Spring Boot**, **PostgreSQL (Supabase)**, **HTML**, **CSS**, and **JavaScript**. It allows administrators to manage student records, marks, attendance, announcements, and notes, while students can securely view their academic information.

---

## 🚀 Live Demo

### Frontend (Vercel)
https://omega.vercel.app

### Backend (Render)
https://uniportal-worj.onrender.com

---

## 📂 GitHub Repository

https://github.com/p-ganesh45/uniportal

---

# ✨ Features

### 👨‍💼 Admin Module

- Secure Admin Login
- Search Student by USN
- Add/Edit/Delete Marks
- Add/Edit/Delete Attendance
- Upload PDF Notes
- Add/Delete Announcements
- View Student Information

### 👨‍🎓 Student Module

- Student Login
- View Marks
- View Attendance
- View Announcements
- Download PDF Notes

---

# 🛠 Tech Stack

## Backend

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL (Supabase)

## Frontend

- HTML5
- CSS3
- JavaScript

## Deployment

- Render (Backend)
- Vercel (Frontend)
- Supabase (Database)

---

# 📁 Project Structure

```
UniPortal
│
├── src
│   ├── main
│   │   ├── java
│   │   ├── resources
│   │   │     └── application.properties
│   │   └── static
│   │
│   └── test
│
├── pom.xml
└── README.md
```

---

# ⚙ Prerequisites

Install the following before running the project.

- Java JDK 17+
- Maven
- PostgreSQL or Supabase
- Git
- VS Code / IntelliJ IDEA

---

# 📥 Installation

## 1. Clone Repository

```bash
git clone https://github.com/p-ganesh45/uniportal.git
```

Move into project

```bash
cd uniportal
```

---

## 2. Configure Database

Open

```
src/main/resources/application.properties
```

Configure your database.

Example:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

---

## 3. Build Project

```bash
mvn clean install
```

---

## 4. Run Project

```bash
mvn spring-boot:run
```

OR

```bash
java -jar target/*.jar
```

---

## 5. Open Application

Frontend

```
http://localhost:8080
```

If deployed

Frontend

```
https://omega.vercel.app
```

Backend

```
https://uniportal-worj.onrender.com
```

---

# 🗄 Database

This project uses **PostgreSQL**.

Tables are automatically created by Hibernate.

Main Tables

- Student
- Marks
- Attendance
- Notes
- Announcement
- Admin

---

# 📷 Screenshots
<img width="934" height="902" alt="image" src="https://github.com/user-attachments/assets/e55fe5d3-82df-4c2e-99c4-2c5c9d6df3f2" />
<img width="1873" height="821" alt="image" src="https://github.com/user-attachments/assets/e5226127-d513-4e8f-85b2-af784b8ab8e8" />
<img width="1892" height="673" alt="image" src="https://github.com/user-attachments/assets/a9e92103-fe15-4538-9da8-0d3779a7e297" />
<img width="1917" height="560" alt="image" src="https://github.com/user-attachments/assets/d0419766-d795-4304-ab91-c2da845bcd3a" />
---

# 🔒 Security

- Admin Authentication
- Student Authentication
- REST APIs
- CORS Configuration
- PostgreSQL Database

---

# 📚 API Endpoints

## Admin

```
POST /api/admin/login
```

---

## Student

```
POST /api/student/login
```

```
GET /api/student/{usn}
```

---

## Marks

```
POST /api/marks
```

```
GET /api/marks/student/{usn}
```

```
PUT /api/marks/{id}
```

```
DELETE /api/marks/{id}
```

---

## Attendance

```
POST /api/attendance
```

```
GET /api/attendance/student/{usn}
```

```
PUT /api/attendance/{id}
```

```
DELETE /api/attendance/{id}
```

---

## Announcements

```
GET /api/announcements
```

```
POST /api/announcements
```

```
DELETE /api/announcements/{id}
```

---

## Notes

```
POST /api/notes
```

```
GET /api/notes
```

```
GET /api/notes/download/{id}
```

```
DELETE /api/notes/{id}
```

---

# 👨‍💻 Future Improvements

- JWT Authentication
- Student Profile Photo
- Dark Mode
- Email Notifications
- Password Encryption
- Role Based Access
- Dashboard Analytics
- Search & Filters
- Export Reports as PDF
- Mobile Responsive UI

---

# 🙋 Author

**P Ganesh**

GitHub

https://github.com/p-ganesh45

LinkedIn

https://www.linkedin.com/in/p-ganesh-252a70396/

---

# ⭐ Support

If you like this project,

⭐ Star this repository

🍴 Fork the repository

🛠 Contribute with improvements

---

# 📄 License

This project is developed for educational and learning purposes.


---




