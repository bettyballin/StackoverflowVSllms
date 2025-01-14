Dim query = From p In ctx.SomeTable()\n            Select New With {\n                .ProductName = p.product_name,\n                .ExpirationDate = p.expiration_date,\n                .PctOfSales = p.pct_sales\n            }