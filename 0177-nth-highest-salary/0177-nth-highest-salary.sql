-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- BEGIN
-- set n =N -1;
--   RETURN (
--       SELECT DISTINCT salary 
--       FROM Employee 
--       ORDER BY salary DESC 
--       LIMIT 1 OFFSET N

--   );
-- END


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
begin
set n = n-1;
return(
    select distinct salary from Employee
    order by salary desc limit 1 offset N
);
end
