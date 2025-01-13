using System;\nusing System.Drawing;\nusing ZXing;\n\nclass Program\n{\n    static void Main()\n    {\n        // Load the image containing the barcode\n        string imagePath = "path_to_your_image_file.png";\n        Bitmap barcodeBitmap = (Bitmap)Image.FromFile(imagePath);\n\n        // Create a barcode reader instance\n        IBarcodeReader reader = new BarcodeReader();\n\n        // Decode the barcode from the image\n        var result = reader.Decode(barcodeBitmap);\n\n        if (result != null)\n        {\n            Console.WriteLine($"Decoded barcode text: {result.Text}");\n            Console.WriteLine($"Barcode format: {result.BarcodeFormat}");\n        }\n        else\n        {\n            Console.WriteLine("Barcode could not be decoded.");\n        }\n    }\n}