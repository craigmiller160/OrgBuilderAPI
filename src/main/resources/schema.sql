# noinspection SqlNoDataSourceInspectionForFile
/* DDL for creating the database for this application */

/* Create database */
drop database if exists orgbuilder;
create database orgbuilder;

/* People table */
drop table if exists orgbuilder.people;
create table orgbuilder.people(
  person_id bigint not null auto_increment,
  last_modified timestamp not null,
  prefix varchar(20),
  first_name varchar(255),
  middle_name varchar(255),
  last_name varchar(255),
  suffix varchar(20),
  birth_date date default '1900-1-1',
  gender varchar(20),
  primary key(person_id)
);

/* People_Addresses table */
drop table if exists orgbuilder.people_addresses;
create table orgbuilder.people_addresses(
  address_id bigint not null auto_increment,
  last_modified timestamp not null,
  person_id bigint not null,
  address_type varchar(20),
  street_address varchar(255),
  po_box varchar(50),
  unit varchar(20),
  city varchar(255),
  state char(2),
  zip varchar(10),
  primary key(address_id),
  foreign key(person_id) references orgbuilder.people(person_id)
);

/* People_Emails table */
drop table if exists orgbuilder.people_emails;
create table orgbuilder.people_emails(
  email_id bigint not null auto_increment,
  last_modified timestamp not null,
  person_id bigint not null,
  email_type varchar(20),
  email_address varchar(255),
  primary key(email_id),
  foreign key(person_id) references orgbuilder.people(person_id)
);

/* People_Phones table */
drop table if exists orgbuilder.people_phones;
create table orgbuilder.people_phones(
  phone_id bigint not null auto_increment,
  last_modified timestamp not null,
  person_id bigint not null,
  phone_type varchar(20),
  area_code char(3),
  prefix char(3),
  line_number char(4),
  extension varchar(10),
  primary key(phone_id),
  foreign key(person_id) references orgbuilder.people(person_id)
);