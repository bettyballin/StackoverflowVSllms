WITH order_summary AS (\n    SELECT\n        o.customer_id,\n        ol.product_id,\n        p.product_name,\n        MIN(YEAR(o.order_date)) AS first_purchase_year,\n        MAX(CASE WHEN RANK() OVER (PARTITION BY ol.product_id ORDER BY o.order_date DESC) = 1 THEN ol.comment END) AS latest_comment,\n        SUM(CASE WHEN o.order_date >= DATEADD(year, -1, GETDATE()) THEN ol.amount * ol.price END) AS total_income_last_12_months,\n        ROW_NUMBER() OVER (PARTITION BY ol.product_id ORDER BY o.order_date DESC) AS purchase_rank,\n        o.order_date\n    FROM\n        customer c\n        JOIN orders o ON c.customer_id = o.customer_id\n        JOIN orderlines ol ON o.order_id = ol.order_id\n        JOIN product p ON ol.product_id = p.product_id\n    WHERE\n        c.customer_id = :customer_id\n    GROUP BY\n        o.customer_id, ol.product_id, p.product_name, o.order_date, ol.comment, ol.amount, ol.price\n)\nSELECT\n    product_id,\n    product_name,\n    first_purchase_year,\n    STRING_AGG(order_date, ', ') WITHIN GROUP (ORDER BY order_date DESC) AS last_three_purchase_dates,\n    latest_comment,\n    total_income_last_12_months\nFROM\n    order_summary\nWHERE\n    purchase_rank <= 3\nGROUP BY\n    product_id, product_name, first_purchase_year, latest_comment, total_income_last_12_months;