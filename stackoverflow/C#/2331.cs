public ActionResult List(bool fromCache, string filter)\n{\n    // if filtering - always pull from cache to increase performance\n    ProductList productList;\n    if (fromCache)\n        productList = Session[SessionKeys.ProductList] as ProductList;\n    else\n    {\n        productList = ProductInfoList.GetProductInfoList();\n        Session[SessionKeys.ProductInfoList] = productList;\n    }\n\n    // apply filter\n    var data = productList.Where(p => p.Category == filter);\n    return View(ViewLocations.ProductListing, data);\n}