SELECT p.[name]\n FROM products p\n WHERE p.product_id in (SELECT s.product_id\n     FROM productsales s\n     WHERE s.[date] between @dateStart and @dateEnd\n     GROUP BY s.product_id\n     HAVING Sum(s.quantity) > @X )