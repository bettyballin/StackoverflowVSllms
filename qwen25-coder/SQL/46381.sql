-- Assuming 'your_table' has a column 'timestamp_column'\nSELECT * FROM your_table \nWHERE DATE(timestamp_column) = '2023-10-15';