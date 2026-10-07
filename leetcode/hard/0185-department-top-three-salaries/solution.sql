# Write your MySQL query statement below
WITH joined_table AS (
    SELECT e.id as id, e.name as name, e.salary as salary, d.name as department FROM Employee e
    INNER JOIN Department d
    ON e.departmentId = d.id
),
rnk_table AS(
    SELECT *, DENSE_RANK() OVER(
        PARTITION BY department
        ORDER BY salary DESC
    ) AS rnk FROM joined_table
)
SELECT Department, name AS Employee, Salary FROM rnk_table
WHERE rnk in (1,2,3);