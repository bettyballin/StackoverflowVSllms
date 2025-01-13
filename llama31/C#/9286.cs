using DocumentFormat.OpenXml;\nusing DocumentFormat.OpenXml.Packaging;\n\n// Open the Word document\nWordprocessingDocument wordDoc = WordprocessingDocument.Open("path/to/form.docx", true);\n\n// Get the main document part\nMainDocumentPart mainPart = wordDoc.MainDocumentPart;\n\n// Get the form fields\nvar formFields = mainPart.Document.Descendants<FieldCode>();\n\n// Fill out the form fields\nforeach (var field in formFields)\n{\n    if (field.InnerText == "FieldName1")\n    {\n        field.Parent.Descendants<Text>().First().Text = "Value1";\n    }\n}\n\n// Save the changes\nmainPart.Document.Save();\nwordDoc.Close();