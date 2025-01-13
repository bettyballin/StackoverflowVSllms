foreach (string product in productTokens)\n{\n    tempProduct = product.Trim();\n    if (tempProduct.Length > 0)\n    {\n        if (tempProduct.Length < 10)\n        {\n            product_id = tempProduct;\n        }\n        else\n        {\n            int charPosition = tempProduct.IndexOf(" ");\n            product_id = tempProduct.Substring(0, charPosition);\n        }\n        \n        var productName = productAdapter.GetProductName(product_id);\n        if (productName != null)\n        {\n            s_product = productName.ToString();\n        }\n        else\n        {\n            s_product = "";\n        }\n        \n        if (s_product.Length > 0)\n        {\n            sTemp = sTemp + s_product + "; ";\n        }\n    }\n}