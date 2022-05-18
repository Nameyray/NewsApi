# NewsAPI

**By Rachel Namiba**

**Description**

A REST API for gathering news and retrieving users and departments

**Installation Requirements**

Internet connection

access to a browser
fork from 

**PSQL**
CREATE DATABASE my_news;

\c my_news;

CREATE TABLE users(
id serial PRIMARY KEY,
name VARCHAR,
bio VARCHAR,
position VARCHAR,
role VARCHAR,
departmentId int
);

CREATE TABLE departments(
id serial PRIMARY KEY,
name VARCHAR,
bio VARCHAR
);

CREATE TABLE news(
id serial PRIMARY KEY,
title VARCHAR,
content VARCHAR,
departmentId int
);

CREATE DATABASE my_news_test WITH TEMPLATE my_news;

**Technologies Used**
IntelliJ IDEA

Java

Spark

PostgreSql

**Knownbugs**

Deployment

