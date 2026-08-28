SELECT DISTINCT s1.*
FROM Stadium s1
JOIN Stadium s2
    ON s2.id BETWEEN s1.id - 2 AND s1.id + 2
JOIN Stadium s3
    ON s3.id BETWEEN s1.id - 2 AND s1.id + 2
WHERE s1.people >= 100
  AND s2.people >= 100
  AND s3.people >= 100
  AND (
        (s2.id = s1.id - 1 AND s3.id = s1.id - 2)
        OR
        (s2.id = s1.id - 1 AND s3.id = s1.id + 1)
        OR
        (s2.id = s1.id + 1 AND s3.id = s1.id + 2)
      )
ORDER BY s1.visit_date;