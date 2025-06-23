# AFormats

**AFormats** is a backend web application designed to manage the submission and evaluation of **Formato A** — a required document for the formulation of undergraduate thesis projects at the *University of Cauca*. These projects can be either a **Research Project (TIA)** or a **Professional Internship (PPA)**.

## 📚 Project Overview

The application facilitates the full lifecycle of a Formato A, which includes:

- **Formulation** by a student and their thesis advisor.
- **Evaluation** by the program coordinator, based on feedback from the academic committee.

This backend system handles the data management, validation, and workflow logic required for this process.

## 🛠️ Technologies Used

- **Spring Boot** (Java)
- **JPA/Hibernate** (Data persistence)
- **Hexagonal Architecture** (Ports & adapters for better modularity and testability)

## ⚙️ Installation & Setup

Before running the project, make sure you have the following installed:

- **Java Development Kit (JDK)** 17 or later
- **Node.js** (for possible frontend integration in the future)
- **Maven**
- **Spring Boot** CLI or run via IDE 

### Run the application:

```bash
./mvnw spring-boot:run
