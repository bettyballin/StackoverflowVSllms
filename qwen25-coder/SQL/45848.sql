SELECT \n    DATE_FORMAT(timestamp_column, '%Y-%m-%d %H:00:00') AS hour_start,\n    AVG(value_column) AS average_value\nFROM \n    your_table_name\nGROUP BY \n    DATE_FORMAT(timestamp_column, '%Y-%m-%d %H');