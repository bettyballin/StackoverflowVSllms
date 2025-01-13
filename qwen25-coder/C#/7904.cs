using DocumentFormat.OpenXml.Packaging;\nusing DocumentFormat.OpenXml.Wordprocessing;\nusing System;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string docFilePath = "template.docx";\n        string outputDocFilePath = "filled_template.docx";\n\n        using (WordprocessingDocument wordDoc = WordprocessingDocument.Open(docFilePath, true))\n        {\n            // Open the main document part and find form fields to update.\n            MainDocumentPart mainDocumentPart = wordDoc.MainDocumentPart;\n            var sdtList = mainDocumentPart.Document.Descendants<SdtBlock>();\n\n            foreach (var sdt in sdtList)\n            {\n                string tag = ((SdtProperties)sdt.FirstChild)?.GetFirstChild<Tag>()?.Val.Value;\n                \n                if (tag == "TextFieldName")\n                {\n                    var textBoxContent = sdt.Elements<SdtContentRun>().First();\n                    var run = textBoxContent.Elements<Run>().First();\n                    var text = run.Elements<Text>().First();\n\n                    text.Text = "Entered Value"; // Set the desired value here\n                }\n                else if (tag == "CheckBoxFieldName")\n                {\n                    var checkBoxContent = sdt.Elements<SdtContentBlock>().First();\n                    var checkBoxParagraph = checkBoxContent.Elements<Paragraph>().First();\n                    var checkBoxRun = checkBoxParagraph.Elements<Run>().First();\n                    var checkBoxFieldCode = checkBoxRun.Elements<FieldChar>().First();\n\n                    // Set checkbox status\n                    if (checkBoxFieldCode.FieldCharType == FieldCharValues.Begin)\n                    {\n                        checkBoxRun.GetFirstChild<Text>().Text = "X"; // Check the box by putting an 'X'\n                    }\n                }\n            }\n\n            // Save changes\n            mainDocumentPart.Document.Save();\n        }\n\n        File.Copy(docFilePath, outputDocFilePath, true);\n    }\n}