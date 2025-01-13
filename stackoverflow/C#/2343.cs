private DataTable GetDataTableFromCsv(string csvContent)\n    {\n        DataTable dt = new DataTable();\n        string all = csvContent;\n        string[] lines = all.Split(new string[] { Environment.NewLine }, StringSplitOptions.RemoveEmptyEntries);\n        foreach (String s in lines)\n        {\n            bool isInsideQuote = false;\n            List<string> values = new List<string>();\n            string accumulator = "";\n            for (int j = 0; j < s.Length; j++)// (char c in s)\n            {\n                char c = s[j];\n                if (c == '"')\n                {\n                    if (!isInsideQuote)\n                    {\n                        isInsideQuote = true;\n                    }\n                    else\n                    {\n                        isInsideQuote = false;\n                    }\n                    accumulator += "\"";\n                }\n                else if (c == ',' && !isInsideQuote)\n                {\n                    values.Add(accumulator);\n                    accumulator = ""; //reset\n                }\n                else if (j == s.Length - 1)\n                {\n                    accumulator += c;\n                    values.Add(accumulator);\n                    accumulator = "";\n                }\n                else\n                {\n                    accumulator += c;\n                }\n            }\n            //first time, create relevant columns\n            if (dt.Columns.Count == 0)\n            {\n                foreach (string colExample in values)\n                {\n                    dt.Columns.Add();\n                }\n                //list of strings now contains an example.\n            }\n            DataRow dr = dt.NewRow();\n            for (int i = 0; i < values.Count; i++)\n            {\n                dr[i] = values[i];\n            }\n            dt.Rows.Add(dr);\n        }\n        return dt;\n    }