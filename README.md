# CloudTechnologies
Source Code of cloud technologies project

**University Name:** http://www.sjsu.edu/ 

**Course:** Cloud Technologies

**Professor:** Sanjay Garje 

**ISA:** Divyankitha Urs

**Student:** Shalini Narang (Sorry I don't maintain a linked in profile)


**What does application do ?**

The application is used to manage files on cloud. A user is authenticated to use the web-site. Once the user logs in, he can perform following tasks:
Upload a file
Modify the existing file
Delete the file
Download the file
Show a list of uploaded files

**Technologies Used:**

UI Tier - Angular JS and Bootstrap
Middle Tier - Spring Boot 
DB Tier - MySQL RDS
Hosted on - Amazon AWS
Files Storage - Amazon S3

**Below are some screen shots of the application.**

1. Login page:
![3](https://user-images.githubusercontent.com/31361406/31965230-80f1def6-b8bb-11e7-8f69-b06e0a73f872.png)

2. File upload:
![5](https://user-images.githubusercontent.com/31361406/31965273-b713460a-b8bb-11e7-9e54-6231068fe78c.png)

3. View the list of uploaded files
![7](https://user-images.githubusercontent.com/31361406/31965276-b8a34150-b8bb-11e7-9922-5efb43019e25.png)

4. Delete File
![8](https://user-images.githubusercontent.com/31361406/31965280-bd7b53b6-b8bb-11e7-8bec-8ad301bf99ee.png)

5. Download file
![9](https://user-images.githubusercontent.com/31361406/31965283-c03591de-b8bb-11e7-9d7b-eb0b664c39aa.png)

**Pre-requisites Set Up**
**1. Preconfigure resources**
1. Create a AWS account
2. Create a S3 bucket to store the files uploaded by the user  - Define security policies, life cycle rules 
3. Create a mySQL RDS instance and create 2 tables using DB creation script. Also execute insert statement to put seed data in the user table which will be used to authenticate users
4. Create an IM user, who has privs to upload/download and delete files in the S3 bucket. Generate access tokens for this user.
5. Update application.properties file with AWS token keys and DB connection details.

**2.Software downloaded locally**
Following configuration is for windows environment
1. Download java 8 SDK 
2. Download eclipse oxygen 
3. Download MySQL workbench and establish a connection with the instance created in AWS RDS MySQL

**How to set up and run project locally**
1. Download the source code from GIT and import it as a maven project into eclipse. When the project is imported the maven pom.xml will resolve and import all the dependencies. The dependencies include AWS SDK, Spring Boot.
2. Update run configuration in eclipse as follows - select maven build, current directory - current workspace and goals as  spring-boot:run
3. Always have build automatically on for the project

