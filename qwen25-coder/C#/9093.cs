foreach (string product in productTokens) \n{\n    tempProduct = product.Trim();\n    if (tempProduct.Length > 0) \n    {\n        int charPosition = tempProduct.IndexOf(" ");\n        if (charPosition == -1 || charPosition >= tempProduct.Length)\n        {\n            product_id = tempProduct; // No space found, treat the whole string as ID\n        }\n        else\n        {\n            product_id = tempProduct.Substring(0, charPosition);\n        }\n\n        s_product = productAdapter.GetProductName(product_id); // Assuming GetProductName returns null if not found\n\n        if (s_product != null) \n        {\n            sTemp = sTemp + s_product + "; ";\n        }\n        else\n        {\n            // Handle the case where the product ID is not found, e.g., log it or skip\n            errLog.WriteLine("Product ID " + product_id + " not found in lookup table.");\n            Console.WriteLine("Product ID " + product_id + " not found in lookup table.");\n        }\n    }\n}