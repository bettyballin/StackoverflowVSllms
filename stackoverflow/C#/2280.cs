DataTable clone = original.Clone();\n        string t;\n        var qry = from DataRow row in original.Rows\n                  let arr = row.ItemArray\n                  select Array.ConvertAll(arr, s =>\n                      (t = s as string) != null\n                      && t.StartsWith("\'")\n                      && t.EndsWith("\'") ? t.Trim('\'') : s);\n        foreach (object[] arr in qry) {\n            clone.Rows.Add(arr);\n        }