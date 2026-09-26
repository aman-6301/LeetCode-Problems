CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select max(salary) as SecondHighestSalary
from (
    select salary,
      DENSE_RANK() over(order by salary desc) as rnk
    from employee
) as ranked
where rnk = N

  );
END