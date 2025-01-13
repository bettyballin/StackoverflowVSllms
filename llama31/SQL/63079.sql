CREATE VIEW SalesSummary AS\nSELECT \n  region,\n  product,\n  SUM(sales) AS total_sales\nFROM \n  sales_data\nGROUP BY \n  region, product;