using System;\nusing System.IO;\nusing Tesseract;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Create a new Tesseract engine\n        using (TesseractEngine engine = new TesseractEngine(@"./tessdata", "eng", EngineMode.Default))\n        {\n            // Load the TIFF file\n            using (Pix img = Pix.LoadFromFile("image.tiff"))\n            {\n                // Perform OCR\n                using (Page page = engine.Process(img))\n                {\n                    // Get the OCR text\n                    string text = page.GetText();\n                    Console.WriteLine(text);\n                }\n            }\n        }\n    }\n}