// Example usage\nDataSet dataSet = new DataSet(); // Assume you have data in this.\nstring filePath = @"C:\path\to\your\file.xlsx";\n\nDataSetToExcelExporter exporter = new DataSetToExcelExporter();\nexporter.Export(dataSet, filePath);