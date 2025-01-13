using (FileStream fs = new FileStream(myFile, FileMode.Open, FileAccess.Read, FileShare.ReadWrite))\nusing (StreamReader reader = new StreamReader(fs))\n{\n    string line;\n    while ((line = reader.ReadLine()) != null)\n    {\n        // Check if the line matches what you're looking for\n        if (line.Contains("your_search_string"))\n        {\n            // Do something with the line\n        }\n    }\n}