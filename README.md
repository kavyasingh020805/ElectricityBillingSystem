# ElectricityBillingSystem

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
