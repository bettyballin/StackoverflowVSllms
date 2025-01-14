SELECT \n    ROW_NUMBER() OVER (ORDER BY client_name) AS LineNumber,\n    client_name\nFROM \n    deliveries\nGROUP BY \n    client_name;