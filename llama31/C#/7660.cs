var query = from p in ctx.SomeTable()\n            select new ProductProjection\n            {\n                ProductName = p.product_name,\n                ExpirationDate = p.expiration_date,\n                PercentOfSales = p.pct_sales\n            };