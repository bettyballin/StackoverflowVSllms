SELECT DISTINCT DATE(timestamp_column), MIN(timestamp_column) AS first_occurrence \nFROM your_table \nGROUP BY DATE(timestamp_column);