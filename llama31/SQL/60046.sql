DECLARE @customer_name nvarchar(max) = 'John Smith'\n\nSELECT * FROM customers\nWHERE customers.customer_name LIKE '%' + REPLACE(@customer_name, ' ', '%') + '%'