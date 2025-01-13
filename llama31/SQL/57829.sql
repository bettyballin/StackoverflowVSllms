SELECT \n  s1.product_ID,\n  s1.items_sold_since_date,\n  s2.total_items_sold\nFROM \n  (\n    SELECT \n      product_ID,\n      SUM(quantity) AS items_sold_since_date\n    FROM \n      Sales\n    WHERE \n      order_date >= '01/01/09'\n    GROUP BY \n      product_ID\n  ) s1\nJOIN \n  (\n    SELECT \n      product_ID,\n      SUM(quantity) AS total_items_sold\n    FROM \n      Sales\n    GROUP BY \n      product_ID\n  ) s2\nON \n  s1.product_ID = s2.product_ID