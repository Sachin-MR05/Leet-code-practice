CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set n =N -1;
  RETURN (
      # Write your MySQL query statement below.
    select case when (select count(distinct salary) from employee )>=n 
    then(select distinct salary from employee order by salary desc limit 1 offset n) 
    else null 
    end 

  );
END