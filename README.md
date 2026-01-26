# 🚌 Bus Reservation System (Java JDBC)

A **console-based Bus Reservation System** developed in **Java** using **JDBC and DAO design pattern**.  
The application allows users to view buses, book tickets, and manage reservations with data persisted in a relational database.

---

## 📌 Project Overview

This project demonstrates how a real-world bus reservation system can be implemented using:

- **Java Object-Oriented Programming**
- **JDBC for database connectivity**
- **DAO (Data Access Object) pattern** for clean separation of concerns

All database interactions are handled through JDBC, making the system persistent and closer to real production applications.

---

## ⚙️ Technologies Used

| Technology | Purpose |
|----------|--------|
| Java | Core programming language |
| JDBC | Database connectivity |
| DAO Pattern | Database abstraction |
| SQL | Data storage & queries |
| Console I/O | User interaction |

---

## 🧩 Project Architecture

```

Main.java
↓
DAO Layer (BusDAO, BookingDAO)
↓
DBConn.java (JDBC Connection)
↓
Relational Database

```

This layered approach ensures:
- Loose coupling
- Better maintainability
- Clean separation between logic and data access

---

## 📁 Project Structure

```

Bus-Reservation-System
├── src
│   └── oopsProject
│       ├── Main.java          # Application entry point
│       ├── DBConn.java        # JDBC connection handling
│       ├── BusDAO.java        # Bus-related DB operations
│       ├── BookingDAO.java    # Booking-related DB operations
│       ├── Bus.java           # Bus model class
│       ├── Booking.java       # Booking model class
├── .gitignore
├── Bus_Reservation_System.iml
└── README.md

````

---

## 🔗 JDBC Implementation Details

### DBConn.java
- Loads JDBC driver
- Establishes database connection
- Returns `Connection` object to DAO classes

### DAO Classes
- `BusDAO` → Executes SQL queries related to buses
- `BookingDAO` → Executes SQL queries related to bookings
- Uses JDBC components:
  - `Connection`
  - `PreparedStatement`
  - `ResultSet`

---

## 🗄️ Database Requirements

> ⚠️ Database setup is required before running the project.

You must have:
- A relational database (e.g., MySQL)
- Required tables created (Bus, Booking, etc.)
- Correct DB credentials configured in `DBConn.java`

Example (conceptual):
```sql
CREATE TABLE Bus (
    id INT PRIMARY KEY,
    bus_name VARCHAR(50),
    capacity INT
);

CREATE TABLE Booking (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    bus_id INT,
    passenger_name VARCHAR(50),
    travel_date DATE
);
````

---

## ▶️ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Vignesh21J/Bus-Reservation-System.git
```

### 2️⃣ Configure Database

* Open `DBConn.java`
* Update:

  * Database URL
  * Username
  * Password

### 3️⃣ Compile and Run

```bash
javac src/oopsProject/*.java
java -cp src/oopsProject Main
```

(Or run `Main.java` directly from your IDE)

---

## 🧪 Application Features

✔ View available buses
✔ Book bus tickets
✔ Store booking details in database
✔ DAO-based JDBC interaction
✔ Clean console-based flow

---

## 🧠 Key Learning Outcomes

* Practical use of **JDBC**
* Understanding **DAO pattern**
* Connecting Java applications to databases
* Writing clean, maintainable backend code
* Handling SQL operations from Java

---

## 🚀 Future Enhancements

* Add seat availability tracking
* User authentication (Admin / Customer)

---

## 🛡️ License

This project is open-source and intended for learning and educational purposes.

---

## 👨‍💻 Author

**Vignesh J**
Java | JDBC | Backend Enthusiast

If you found this project helpful, feel free to ⭐ the repository.
