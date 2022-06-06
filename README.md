# NewsAPI

**By Rachel Namiba**

**Description**

A REST API for gathering news and retrieving users and departments

**Installation Requirements**

Internet connection

access to a browser

fork from https://github.com/Nameyray/NewsApi.git

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

**End Points**

 ---:**URL** ---: **HTTP VERB** ---: **DESCRIPTION**
 
/user/new        POST  Adding a new user

/department/new  POST  Adding a new department

/news/new        POST  Adding new news

/departments     GET   Getting all departments

/get_all_users   GET   Getting all users

/news            GET   Getting all news

/news/:id        GET   Finding news by id

/departments/:id GET   Finding a department by their id


**Technologies Used**
IntelliJ IDEA

Java

Spark

PostgreSql

**Knownbugs**

Deployment

**License**

MIT Copyright (c) 2022 Rachel Namiba

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

**Contact**

Reach me out namibaracheal@gmail.com

