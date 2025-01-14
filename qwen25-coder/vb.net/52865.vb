TRANSFORM First(Sales.price) AS price\nSELECT Sales.customer_name,\n       (SELECT COUNT(*) \n        FROM Sales sub \n        WHERE sub.customer_name = Sales.customer_name \n        AND sub.order_date <= Sales.order_date\n        ORDER BY sub.order_date, sub.price) - 1 AS pivot_id\nFROM Sales\nWHERE (\n    SELECT COUNT(*)\n    FROM Sales sub2\n    WHERE sub2.customer_name = Sales.customer_name\n    AND sub2.order_date >= Sales.order_date\n    ORDER BY sub2.order_date, sub2.price\n) <= 5\nGROUP BY Sales.customer_name,\n         (SELECT COUNT(*) \n          FROM Sales sub \n          WHERE sub.customer_name = Sales.customer_name \n          AND sub.order_date <= Sales.order_date\n          ORDER BY sub.order_date, sub.price) - 1 \nPIVOT "order_date" + CStr(\n    SELECT COUNT(*)\n    FROM Sales sub3\n    WHERE sub3.customer_name = Sales.customer_name\n    AND sub3.order_date <= Sales.order_date\n    ORDER BY sub3.order_date, sub3.price\n) - 1;