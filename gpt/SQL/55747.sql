CREATE INDEX idx_Products_CategoryId ON Products(CategoryId);\n\nSELECT p.ProductId, p.Name, c.CategoryId, c.Name AS Category\nFROM Products p\nINNER JOIN ProductCategories c ON p.CategoryId = c.CategoryId\nWHERE c.CategoryId = 1;