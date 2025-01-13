WITH RecursiveCategories AS (\n    SELECT CategoryId, ParentCategoryId, 0 AS Level\n    FROM Category\n    WHERE ParentCategoryId = 0\n    UNION ALL\n    SELECT c.CategoryId, c.ParentCategoryId, Level + 1\n    FROM Category c\n    INNER JOIN RecursiveCategories r ON c.ParentCategoryId = r.CategoryId\n)\nSELECT DISTINCT p.ProductId, rc.CategoryId\nFROM ProductCategory p\nINNER JOIN RecursiveCategories rc ON p.CategoryId = rc.CategoryId\nORDER BY p.ProductId, rc.CategoryId;