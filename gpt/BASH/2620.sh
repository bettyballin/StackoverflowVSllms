LogParser "SELECT sc-status AS StatusCode, COUNT(*) AS Hits FROM <path_to_iis_logs> GROUP BY StatusCode ORDER BY Hits DESC" -i:IISW3C