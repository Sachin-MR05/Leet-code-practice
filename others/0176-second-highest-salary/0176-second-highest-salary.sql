SELECT CASE
    WHEN(SELECT COUNT(distinct salary) FROM employee)>=2
    THEN(SELECT DISTINCT salary FROM employee ORDER BY salary desc LIMIT 1 offset 1)
    ELSE NULL
end  as SecondHighestSalary