WITH RECURSIVE TimeSeries AS (\n    SELECT MIN(received) AS received, MAX(received) AS max_received\n    FROM your_table\n    UNION ALL\n    SELECT received + 1 SECOND, max_received\n    FROM TimeSeries\n    WHERE received < (SELECT MAX(received) FROM your_table)\n)\nSELECT ts.received, COALESCE(t.value, LAG(t.value) OVER (ORDER BY ts.received)) AS value\nFROM TimeSeries ts\nLEFT JOIN your_table t ON ts.received = t.received\nORDER BY ts.received;