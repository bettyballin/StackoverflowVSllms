using ZXing;\n\n   var barcodeReader = new BarcodeReader();\n   var result = barcodeReader.Decode(bitmap); // bitmap is an instance of System.Drawing.Bitmap\n\n   if (result != null)\n   {\n       Console.WriteLine(result.Text);\n   }