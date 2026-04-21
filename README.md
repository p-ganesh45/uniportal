# 🚀 UniPortal – Academic Management System

## 📌 Overview
UniPortal is a full-stack web-based academic management system designed to digitize and simplify student data management. It provides a centralized platform where administrators can manage academic records and students can access their information in real-time.

The system eliminates manual paperwork, improves data accessibility, and ensures efficient communication between administrators and students.

---

## 🎯 Key Features

### 👨‍💼 Admin Module
- Secure admin authentication  
- Add, update, and delete student marks  
- Manage attendance with automatic percentage calculation  
- Upload and manage PDF notes  
- Post announcements  
- Search students by USN  

---

### 🎓 Student Module
- Login using USN, Name, and Branch  
- View announcements  
- Check marks and attendance  
- Download notes (PDF)  
- Responsive UI (mobile + desktop)  

---

## 🛠 Tech Stack

- **Backend:** Spring Boot (Java)  
- **Frontend:** HTML, CSS, JavaScript  
- **Database:** PostgreSQL (Supabase)  
- **Architecture:** REST APIs  

---

## 🌐 Live Demo

🔗 https://uniportal-ten-omega.vercel.app/

---

## 🏗 Architecture


Frontend (HTML/CSS/JS)
↓
Spring Boot REST API
↓
PostgreSQL Database


---

## 🗄 Database Design

- Students  
- Marks  
- Attendance  
- Announcements  
- Notes  

---

## ⚙️ How to Use (Run Locally)

### 🔹 Prerequisites
- Java (JDK 17+)  
- Maven  
- PostgreSQL  

---

### 🔹 Step 1: Clone Repository

```bash
git clone https://github.com/p-ganesh45/uniportal-backend.git
cd uniportal-backend




🔹 Step 2: Create Database

Open PostgreSQL and run:

CREATE DATABASE uniportal;


🔹 Step 3: Configure Database

Go to:

src/main/resources/application.properties

Update:

spring.datasource.url=jdbc:postgresql://localhost:5432/uniportal
spring.datasource.username=postgres
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🔹 Step 4: Run Backend
mvn spring-boot:run

Backend will start at:

http://localhost:8080
🔹 Step 5: Run Frontend

Open frontend folder and run:

index.html
📡 API Usage (Sample)
Method	Endpoint	Description
POST	/students/add	Add student
GET	/students	Get all students
PUT	/students/{id}	Update student
DELETE	/students/{id}	Delete student
🧪 API Testing

You can test APIs using Postman:

GET http://localhost:8080/students
POST http://localhost:8080/students/add


📁 Project Structure
uniportal-backend/
├── controller/
├── service/
├── repository/
├── model/
├── config/
└── resources/



<img width="1011" height="901" alt="image" src="https://github.com/user-attachments/assets/cc615fa6-ceb3-4e9b-bbd7-e3937f8c452d" />




