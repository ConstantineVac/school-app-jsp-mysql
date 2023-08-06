# School App Pro - README

## Overview

School App Pro is a web application that allows user admins to manage various aspects of a school system. The application provides functionalities for signing up, signing in, and performing basic CRUD (Create, Read, Update, Delete) operations for teachers, meetings, students, cities, and specialties.

## Features

The School App Pro provides the following features:

### User Authentication

- User admins can sign up and create an account.
--- 
![image](https://github.com/ConstantineVac/school-app-jsp-mysql/assets/108877593/f775e627-be2a-452e-8775-981b0ede66d9)

- Existing user admins can sign in with their credentials.
---
![image](https://github.com/ConstantineVac/school-app-jsp-mysql/assets/108877593/63b40755-2bb0-4e92-9331-2dc8e7b7ef3d)

- User Passwords are hash encrypted while stored in the Database.
![image](https://github.com/ConstantineVac/school-app-jsp-mysql/assets/108877593/bf13e85f-6943-46f3-a0fe-a6e28cb30cbe)

### Teachers Management
- User admins can add new teachers to the system.
---
![image](https://github.com/ConstantineVac/school-app-jsp-mysql/assets/108877593/eafe3105-e6aa-42b6-97a8-c046858b5f5f)

- User admins can view a list of all teachers in the school.
- User admins can update the information of existing teachers (e.g., first name, last name).
- User admins have the option to delete teachers from the system.
---
![image](https://github.com/ConstantineVac/school-app-jsp-mysql/assets/108877593/af5f61ea-4555-420d-9da5-fd60eb8a32df)


### Meetings Management

- User admins can schedule new meetings with specified teachers and students.
---
![image](https://github.com/ConstantineVac/school-app-jsp-mysql/assets/108877593/7308e193-5cff-4fdf-aea8-657fac468bc5)

- User admins can view a list of all scheduled meetings.
- User admins can update the details of existing meetings (e.g., room, meeting date).
- They can also cancel or delete scheduled meetings.
--- 
![image](https://github.com/ConstantineVac/school-app-jsp-mysql/assets/108877593/e77db3e7-16f3-4ca1-8ddc-9a49891a906f)

### Students Management

- User admins can view a list of all students enrolled in the school.
- They can add new students to the system.
- User admins have the ability to update student information (e.g., first name, last name, gender).
- They can remove students from the system if needed.

### Cities Management

- User admins can view a list of all cities where the school operates.
- They can add new cities to the system.
- User admins can update city information (e.g., city name).
- They can delete cities from the system.

### Specialties Management

- Although currently not implemented, the School App Pro is designed to include specialties management in the future.
- User admins will be able to view, add, update, and delete specialties for teachers and students.

## Technologies Used

The School App Pro is built using the following technologies:

- Front-end: HTML, CSS, JavaScript
- Back-end: Java with Servlets and JSP (JavaServer Pages)
- Database: MySQL for storing user admin credentials and school-related data

## Installation

1. Clone the School App Pro repository to your local machine.
2. Set up a MySQL database and import the provided SQL schema to create the necessary tables.
3. Configure the database connection details in the application's configuration files.
4. Deploy the application on a Java web server (e.g., Apache Tomcat).

## Usage

1. Access the application through your web browser using the provided URL.
2. Sign up as a user admin if you don't have an account, or sign in with your credentials.
3. Use the navigation menu to access the different management functionalities (teachers, meetings, students, cities, specialties - when implemented).
4. Perform the desired CRUD operations according to your needs.

## Status

The School App Pro is currently under development, and some features (e.g., specialties management) are yet to be implemented. However, the existing functionalities are functional and can be used by user admins for basic management tasks.

## License

The School App Pro is an open-source project and is distributed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the application as per the terms of the license.

## Contributions

Contributions to the School App Pro project are welcome. If you encounter any issues or have ideas for improvement, please submit an issue or a pull request on the project's repository.

---

Thank you for taking your time to check out my School App Pro! If you have any questions or want to make any suggestions, please don't hesitate to contact us. Happy Coding!
