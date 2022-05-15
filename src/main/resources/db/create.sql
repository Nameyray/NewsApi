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


