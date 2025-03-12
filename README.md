# ElectricityBillingSystem


ABSTRACT
Electricity billing is a crucial aspect of utility management, but traditional methods often lead to inefficiencies, delays, and inaccuracies. Customers are frequently required to visit electricity board offices for bill payments, which is both time-consuming and inconvenient. Manual calculations also increase the chances of errors, leading to disputes and discrepancies in billing. To overcome these challenges, this project introduces a computerized Electricity Billing System that automates the entire billing process, making it more efficient and user-friendly.
The system is developed using Java Swing for the user interface and MySQL for backend database management. It includes two types of users: Admin and Customer. The admin is responsible for managing customer details, recording monthly electricity usage, and overseeing bill calculations. Once the usage data is entered, the system automatically computes the bill based on predefined tariffs and updates the customer’s account. Customers can log in to their accounts to check their electricity consumption, view their generated bills, and make payments before the due date.
By shifting to an automated billing system, the project eliminates the need for physical visits, minimizes human errors, and enhances accessibility. The secure database ensures proper storage of customer records, payment history, and usage statistics, making tracking and management seamless. This system not only improves the efficiency of bill generation but also provides a convenient, transparent, and reliable solution for both customers and electricity providers. Our goal is to modernize the billing process, ensuring accuracy, efficiency, and ease of access in electricity bill payments.


#this is the mysql database script to be executed one by one to create the required database in your system



create database ebs;
use ebs;
create table login(meter_no varchar(20), username varchar(30), name varchar(30), password varchar(30), user varchar(20));
describe login;
select * from login;
create table customer(name varchar(30), meter_no varchar(20), address varchar(30), state varchar(30), city varchar(30), email varchar(30), phone varchar(15));
describe customer;
select * from customer;
create table meter_info(meter_no varchar(20), meter_location varchar(30), meter_type varchar(20), phase_code varchar(20), bill_type varchar(20), days varchar(10));
describe meter_info;
select * from meter_info;
create table tax_rent(cost_per_unit varchar(20), meter_rent varchar(20), service_charge varchar(20), service_tax varchar(20), swachh_bharat_cess varchar(20), fixed_tax varchar(20));
describe tax_rent;
select * from tax_rent;
create table bill(meter_no varchar(20), month varchar(20), units varchar(20), total_bill varchar(20), staus varchar(20));
describe bill;
select * from bill;
