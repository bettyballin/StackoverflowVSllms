-- Using minimal logging in SQL Server (example)\nDELETE FROM OUR_TABLE WITH (TABLOCK)\nWHERE ID IN (123, 345, ...);