Excel.Worksheet wsnew = sheets.Add(m, m, m, m) as Excel.Worksheet;\n// ...\nMarshal.ReleaseComObject(wsnew);\nwsnew = null;