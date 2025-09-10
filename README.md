# FlightManagementSystem

A Spring Boot-based **Flight Management System** for learning and practical implementation of Java Full Stack development.

---

## ✅ Features
- Manage flights, bookings, and users
- Built with Java, Spring Boot, JPA, MySQL and REST APIs
- Will be integrated with React
- Demonstrates real-world application structure and best practices

---

## 📂 Technologies Used
- **Java** (Spring Boot, JPA/Hibernate)
- **Maven** for dependency management
- **MySQL** as the database
- **Lombok** for reducing boilerplate code
- **REST APIs** for backend communication
- Compatible with React/Angular frontend

---

## ⚙️ Setup Instructions

Follow the steps below to set up and run the **FlightManagementSystem** on your local machine.

---

### ✅ **1. Clone the repository**

Open a terminal or command prompt and run:

```bash
git clone https://github.com/kaustubhchoudhary/FlightManagementSystem.git
```

This will download the project files to your local system.

---

### ✅ **2. Import the project as a Maven project in STS**

1. Open **Spring Tool Suite (STS)**.
2. Click on **File → Import → Existing Maven Projects**.
3. Browse and select the root `FlightManagementSystem` folder.
4. Finish the import process. STS will read the `pom.xml` and set up the project structure.

---

### ✅ **3. Do a Maven update**

After importing:

1. Right-click on the project in the **Package Explorer**.
2. Select **Maven → Update Project…**.
3. Check **Force Update of Snapshots/Releases**.
4. Click **OK**.

This ensures that all dependencies are downloaded and linked properly.

---

### ✅ **4. Start MySQL Server and create a schema**

1. Open **MySQL Workbench** or any MySQL client, or use the command line.
2. Start the MySQL server if it’s not already running.
3. Create a new schema/database by running:

```sql
CREATE DATABASE flight_db;
```

This will create a database where the application will store flight, user, and booking data.

---

### ✅ **5. Configure database credentials in `application.properties`**

1. Open the file located at `src/main/resources/application.properties`.
2. Find the database settings and update them with your credentials. Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/flight_db
spring.datasource.username=root
spring.datasource.password=*your_password_here*
spring.jpa.hibernate.ddl-auto=update
```

Replace `your_password_here` with your actual MySQL password.

---

### ✅ **6. Setup Lombok**

Lombok helps reduce boilerplate code like getters and setters.

1. Download `lombok.jar` from [https://projectlombok.org/download](https://projectlombok.org/download).

2. Double click lombok.jar file to run it.

3. In the dialog box when asked, select the STS installation directory:

   ```
   C:\SpringToolSuite4\sts-4.15.1.RELEASE
   ```
4. Click **Install/Update** and confirm the setup.

Also, in STS:

* Go to **Window → Preferences → Java → Compiler → Annotation Processing**
* Check **Enable annotation processing**
* Click **Apply and Close**

---

### ✅ **7. Run the application as a Spring Boot App**

1. Right click on the project `FlightManagementSystem` and select **Run As → Spring Boot App**.
2. The console will show startup logs. Once started, the application will be accessible at `http://localhost:9192`.

---

### ✅ **8. Open Postman to test the APIs**

1. Download and install **Postman** from [https://www.postman.com/downloads/](https://www.postman.com/downloads/).
2. Open Postman and create requests using the API endpoints provided in the section below.
3. You can test operations like adding flights, registering users, creating bookings, etc.

---

✅ After completing these steps, your **FlightManagementSystem** will be fully functional and ready for further development and testing.

APIs and Data
=============

# 📘 User Management API Documentation


✅ API Endpoints

---

📌 1. Register 4 Users (Admin, Flight Owner, Flight Manager and Passenger)

=> Method: `POST`
=> URL: `http://localhost:9192/api/users`
=> Description: Register a new user with personal details.

Request Body (JSON):

User: Admin, Role: 1

```json
{
  "fullName": "Ravi Kumar Sharma",
  "dateOfBirth": "1988-07-22",
  "gender": "Male",
  "username": "ravikumar88",
  "password": "India@123",
  "address": "Flat 302, Green Residency, MG Road, Bengaluru, Karnataka - 560001",
  "emailId": "ravi.sharma@example.in",
  "phoneNo": "9876543210",
  "roleId": 1
}
```

User: FLIGHT_OWNER, Role: 2

```json
{
  "fullName": "Anita Singh",
  "dateOfBirth": "1990-03-15",
  "gender": "Female",
  "username": "anitasingh90",
  "password": "India@123",
  "address": "A-12, Silver Oaks Apartments, Sector 45, Gurugram, Haryana - 122003",
  "emailId": "anita.singh@example.in",
  "phoneNo": "9123456780",
  "roleId": 2
}
```
User: FLIGHT_MANAGER, Role: 3

```json
{
  "fullName": "Manish Reddy",
  "dateOfBirth": "1985-11-05",
  "gender": "Male",
  "username": "manishreddy85",
  "password": "India@123",
  "address": "Plot 23, Palm Residency, Jubilee Hills, Hyderabad, Telangana - 500033",
  "emailId": "manish.reddy@example.in",
  "phoneNo": "9988776655",
  "roleId": 3
}
```

User: USER, Role: 4

```json
{
  "fullName": "Priya Kapoor",
  "dateOfBirth": "1995-08-20",
  "gender": "Female",
  "username": "priyak95",
  "password": "India@123",
  "address": "Flat 505, Lotus Heights, Andheri West, Mumbai, Maharashtra - 400053",
  "emailId": "priya.kapoor@example.in",
  "phoneNo": "9876123456",
  "roleId": 4
}
```

Content-Type: `application/json`

---

📌 2. Get User by ID

=> Method: `GET`
=> URL: `/api/users/{userId}`
=> Description: Retrieve details of a user by their ID.

Example Request:

```
GET http://localhost:9192/api/users/3
```

---

📌 3. Get All Users

=> Method: `GET`
=> URL: `/api/users`
=> Description: Retrieve the list of all users.

Example Request:

```
GET http://localhost:9192/api/users
```

---

📌 4. Update User Profile

Here’s a detailed guide on how to perform this API request using Postman to update a user profile with multipart form data:

---

## ✅ How to Test “Update User Profile” API in Postman

1. Open Postman and create a new request

* Click New → Request.
* Name it something like Update User Profile.
* Select PUT as the method.
* Enter the URL, for example:

  ```
  http://localhost:9192/api/users/4/profile
  ```

  Replace `4` with the actual user ID you want to update.

---

2. Set the request body type

1. Go to the Body tab.
2. Select form-data.
3. Add the following fields:

| Key          | Type | Value                                             |
| ------------ | ---- | ------------------------------------------------- |
| address      | Text | B-12, Sector 22, Noida, Uttar Pradesh - 201301    |
| phoneNo      | Text | 9123456780                                        |
| profileImage | File | Select your profile image file                    |
| iDocs        | File | Select your first document file (e.g. aadhar.pdf) |
| iDocs        | File | Select your second document file (e.g. pan.pdf)   |

✔ For multiple files in `iDocs`, add the key `iDocs` again for each file.

---

3. Set the request headers

* Postman will automatically set the header:

  ```
  Content-Type: multipart/form-data
  ```
* You don't need to manually set it—Postman takes care of it.

---

4. Add Authorization (if required)

If your API requires authentication:

1. Go to the Authorization tab.
2. Select the appropriate type (e.g., Bearer Token, Basic Auth).
3. Enter your token or credentials.

---

5. Send the request

* Click Send.
* Check the response returned by the server to confirm the profile was updated.

---

✅ Example Screenshot Workflow

1. Method: PUT
2. URL: `http://localhost:9192/api/users/25/profile`
3. Headers: Auto-managed by Postman
4. Body:

   * address → Text
   * phoneNo → Text
   * profileImage → File (choose file from your system)
   * iDocs → File (choose first document)
   * iDocs → File (choose second document)

---

Notes:

✔ Use the same key (`iDocs`) multiple times to upload multiple files.
✔ Make sure the server is running at `localhost:9192`.
✔ Validate that your backend is set to accept multipart requests.


---

📌 5. Delete User

=> Method: `DELETE`
=> URL: `/api/users/{userId}`
=> Description: Delete a user by their ID.

Example Request:

```
DELETE http://localhost:9192/api/users/25
```

---

✅ Notes

✔ All responses are wrapped inside `ApiResponseDTO` with fields:

=> `status` – HTTP status code (e.g. 200, 201)
=> `message` – a descriptive message
=> `data` – the actual response object or `null`

✔ For date fields like `dateOfBirth`, use format `yyyy-MM-dd`.
✔ Phone numbers should be 10 digits, e.g. `"9876543210"`.
✔ Address format follows Indian standards with city, state, and PIN code.
✔ File uploads should use `multipart/form-data`.
✔ Role IDs must correspond to existing roles in your system.

---


