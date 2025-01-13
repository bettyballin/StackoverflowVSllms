using (PdfStamper stamper = new PdfStamper(reader, ms)) {\n    AcroFields fields = stamper.AcroFields;\n    fields.GenerateAppearances = true;\n\n    // Iterate through the fields and trigger calculations\n    foreach (string fieldName in fields.GetFieldNames()) {\n        PdfDictionary fieldDict = fields.GetFieldItem(fieldName).GetMerged(0);\n        if (fieldDict.Contains(PdfName.JS)) {\n            PdfString js = fieldDict.GetAsString(PdfName.JS);\n            // Execute the JavaScript code\n            stamper.JavaScript = js.ToUnicodeString();\n            stamper.Writer.AddJavaScript(stamper.JavaScript);\n        }\n    }\n}