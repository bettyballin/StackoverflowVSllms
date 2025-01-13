CREATE TABLE temp1 AS (\n  SELECT t1.cust_id, t1.invoice_amt, t2.payment_date\n  FROM table_1@dblink t1\n  JOIN table_2@dblink t2 ON t1.cust_id = t2.cust_id\n);