# Wild-life-tracker

## Author 
*UMURERWA Lynda Flower*

# DESCRIPTION

This is an app that allows user to add animals to the database andalso allow the ranger to allow the report an endangered animal. 

# User story

* Users can click on navigation bar on add animal endengered or not.
* Fill the form to add animal or report her/his sightseeing.
* After filling form you check whether your answers becomes successefully.


# PRE-REQUISITES

A couple of things to get you started:

1.Ensure you have Java installed
A simple way to install Java is using sdkman.

Simply follow the instructions to have sdkman installed and install java:

    sdk install java
    
2. Gradle
Gradle is used as the build tool and can be installed with sdkman:

    sdk install gradle

# SETUP/INSTALLATION
To create the necessary databases, launch postgres, then psql, and run the following commands:

*   CREATE DATABASE wildlife_tracker;
*   \c wildlife_tracker;
*   CREATE TABLE animals (id serial PRIMARY KEY, animalName varchar,health varchar,age varchar,endangered varchar);
*   CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, name varchar);


# TECHNOLOGIES USED:

* Heroku

* Java - source language.

* Gradle for dependency management and running tasks.

* Bootstrap.

* Cascading Style Sheets.

* Spark

* PostgreSQL


# Support & Contact
  
*  Email Address: umurerwalynda@gmail.com.
  
* github-username: lyndaflower.


# License

The app is licensed by MIT. Copyright (c) 2019 Lynda Flower





Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
