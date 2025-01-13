CREATE TABLE orders (\n      order_id NUMBER,\n      order_date DATE,\n      customer_id NUMBER,\n      amount NUMBER\n  )\n  PARTITION BY RANGE (order_date) (\n      PARTITION p0 VALUES LESS THAN (TO_DATE('2022-01-01', 'YYYY-MM-DD')),\n      PARTITION p1 VALUES LESS THAN (TO_DATE('2023-01-01', 'YYYY-MM-DD'))\n  );