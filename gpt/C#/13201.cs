string filePath = Server.MapPath("~/uploads/" + Path.GetFileName(userInput));\n    if (!File.Exists(filePath)) {\n        // Handle file not found\n    }