SELECT TOP 10 c-ip, COUNT(*) AS REQUESTS \n   FROM ex*.log \n   GROUP BY c-ip \n   ORDER BY REQUESTS DESC;