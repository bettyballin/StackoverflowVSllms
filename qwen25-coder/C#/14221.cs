public void Import(Product product)\n{\n    var mageProduct = new catalogProductCreateEntity();\n    // ... (your existing code to set up product details)\n\n    _m.catalogProductCreate(MageSessionProvider.GetSession(), "simple", "26", product.SKU, mageProduct);\n\n    var stock = new catalogInventoryStockItemUpdateEntity();\n    // ... (your existing code to update stock details)\n    _m.catalogInventoryStockItemUpdate(MageSessionProvider.GetSession(), product.SKU, stock);\n    \n    // Reindex the necessary indexes\n    int[] processIds = _m.indexProcessCollection(MageSessionProvider.GetSession()).Keys.ToArray();\n    foreach (var processId in processIds)\n    {\n        _m.indexProcessReindex(MageSessionProvider.GetSession(), processId);\n    }\n\n    Console.WriteLine(product.Name + " imported and indexed");\n}