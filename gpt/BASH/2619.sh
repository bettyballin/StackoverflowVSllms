LogParser "SELECT TOP 10 c-ip AS ClientIP, COUNT(*) AS Requests FROM <path_to_iis_logs> GROUP BY ClientIP ORDER BY Requests DESC" -i:IISW3C