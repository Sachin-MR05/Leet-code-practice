# Write your MySQL query statement below

select e.name as Employee from employee e where e.salary >(select ee.salary from employee ee where ee.id = e.managerid )
