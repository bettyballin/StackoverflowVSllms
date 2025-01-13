using (var context = new YourDataContext())\n{\n    // Fetch the old specs to delete\n    var oldSpecs = context.ProductSpecs.Where(ps => ps.product_id == productId).ToList();\n\n    // Delete old specs\n    context.ProductSpecs.DeleteAllOnSubmit(oldSpecs);\n    context.SubmitChanges();  // Submit the deletions first\n\n    // Add new specs\n    foreach (var spec in newSpecs)\n    {\n        context.ProductSpecs.InsertOnSubmit(spec);\n    }\n\n    // Submit the insertions\n    context.SubmitChanges();\n}