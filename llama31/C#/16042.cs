// Initial load\nvar initialData = service.GetProductDetails(new List<int> { 1, 2, 3, ... });\ngrid.DataSource = initialData;\n\n// Lazy loading\ngrid.Scroll += (sender, args) =>\n{\n    var scrolledProductId = (int)grid.Rows[args.RowIndex].Cells[0].Value;\n    var productDetails = service.GetProductDetails(new List<int> { scrolledProductId });\n    grid.DataSource = productDetails;\n};