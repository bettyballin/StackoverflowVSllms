-- Assuming stardate and enddate are of type DATETIME or TIMESTAMP\nSELECT (EXTRACT(EPOCH FROM (enddate - stardate))) AS difference_in_seconds;