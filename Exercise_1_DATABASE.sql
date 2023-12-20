-- Database: employee

-- DROP DATABASE IF EXISTS employee;

CREATE DATABASE employee
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_India.1252'
    LC_CTYPE = 'English_India.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE department(
    department_id INT PRIMARY KEY,
    department_name VARCHAR(255)
);

CREATE TABLE employee(
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255),
    salary INT,
    department_id INT REFERENCES department(department_id)
);

INSERT INTO department (department_id, department_name) VALUES
    (1,'Finance'),
    (2,'HR'),
    (3,'IT');

INSERT INTO employee (employee_id, employee_name, salary, department_id) VALUES
    (101, 'Harsh', 50000, 1),
    (102, 'Malvika', 60000, 2),
    (103, 'Manya', 75000, 1),
    (104, 'Kashita', 80000, 3);

--1. Print employee_id, employee_name, and department_name
SELECT e.employee_id, e.employee_name, d.department_name
FROM employee e
INNER JOIN department d ON e.department_id = d.department_id;

--2. Write a Query that prints all the employees and their salaries in descending order of their salary
SELECT employee_id, employee_name, salary
FROM employee
ORDER BY salary DESC;

--3. Write a Query that prints the average salary of employees in each department with the department name
SELECT d.department_name, AVG(e.salary) AS average_salary
FROM employee e
INNER JOIN department d ON e.department_id = d.department_id
GROUP BY d.department_name;
