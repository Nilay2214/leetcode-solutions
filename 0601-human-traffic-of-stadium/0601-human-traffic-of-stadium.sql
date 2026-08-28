WITH high_traffic AS (
    SELECT *,
           id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
)
SELECT id, visit_date, people
FROM high_traffic
WHERE grp IN (
    SELECT grp
    FROM high_traffic
    GROUP BY grp
    HAVING COUNT(*) >= 3
)
ORDER BY visit_date;