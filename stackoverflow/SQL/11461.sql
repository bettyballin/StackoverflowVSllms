Product\n  ProductId*\n  CategoryId: FK to Category.CategroyId\n  Name\n\nCategory\n  CategoryId*\n  Name\n\nProperty\n  PropertyId*\n  Name\n  Type\n\nCategoryProperty\n  CategoryId*: FK to Category.CategoryId\n  PropertyId*: FK to Property.PropertyId\n\nProductProperty\n  ProductId*: FK to Product.ProductId\n  PropertyId*: FK to Property.PropertyId\n  ValueAsString