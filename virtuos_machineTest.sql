create database machine_test;
use machine_test;

create table student_list (
 StudentName varchar(30),
 CollegeName varchar(50),
 Round1Marks float check(Round1Marks between 0 and 10),
 Round2Marks float check(Round2Marks between 0 and 10),
 Round3Marks float check(Round3Marks between 0 and 10),
 TechnicalRoundMarks float check(TechnicalRoundMarks between 0 and 20),
 TotalMarks float Generated Always as (Round1Marks + Round2Marks + Round3Marks + TechnicalRoundMarks) stored,
 result varchar(10) generated always as (
 case
    when (Round1Marks + Round2Marks + Round3Marks + TechnicalRoundMarks) >= 35 
    then 
     'selected' 
     else 
     'rejected'
     end
     )
     stored
);

insert into student_list (StudentName, CollegeName, Round1Marks, Round2Marks, Round3Marks, TechnicalRoundMarks) Values
('Keerthi', 'Lpu', '8', '10', '9', '12'),
('ravi', 'iit', '7', '8', '9', '12'),
('Ayush', 'Lpu', '9', '10', '9', '16');

Select StudentName, CollegeName, TotalMarks, result, dense_rank() over ( order by TotalMarks DESC) as studentRank
From student_list order by TotalMarks;

create database machine_test;
use machine_test;

create table student_list (
 StudentName varchar(30),
 CollegeName varchar(50),
 Round1Marks float check(Round1Marks between 0 and 10),
 Round2Marks float check(Round2Marks between 0 and 10),
 Round3Marks float check(Round3Marks between 0 and 10),
 TechnicalRoundMarks float check(TechnicalRoundMarks between 0 and 20),
 TotalMarks float Generated Always as (Round1Marks + Round2Marks + Round3Marks + TechnicalRoundMarks) stored,
 result varchar(10) generated always as (
 case
    when (Round1Marks + Round2Marks + Round3Marks + TechnicalRoundMarks) >= 35 
    then 
     'selected' 
     else 
     'rejected'
     end
     )
     stored
);

insert into student_list (StudentName, CollegeName, Round1Marks, Round2Marks, Round3Marks, TechnicalRoundMarks) Values
('Keerthi', 'Lpu', '8', '10', '9', '12'),
('ravi', 'iit', '7', '8', '9', '12'),
('Ayush', 'Lpu', '9', '10', '9', '16');

Select StudentName, CollegeName, TotalMarks, result, dense_rank() over ( order by TotalMarks DESC) as studentRank
From student_list order by TotalMarks;

