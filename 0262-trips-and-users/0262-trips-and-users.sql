# Write your MySQL query statement below
SELECT 
    Request_at AS Day,
    ROUND(
        SUM(CASE 
            WHEN Status IN ('cancelled_by_driver', 'cancelled_by_client') 
            THEN 1 
            ELSE 0 
        END) / COUNT(*),
        2
    ) AS `Cancellation Rate`
FROM Trips t
JOIN Users u1
    ON t.Client_Id = u1.Users_Id
JOIN Users u2
    ON t.Driver_Id = u2.Users_Id
WHERE u1.Banned = 'No'
  AND u2.Banned = 'No'
  AND Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY Request_at;