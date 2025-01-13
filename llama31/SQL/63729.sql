SELECT \n    ROW_NUMBER() OVER (ORDER BY client_name) AS LineNumber,\n    client_name\nFROM \n    (SELECT DISTINCT client_name FROM deliveries) AS subquery