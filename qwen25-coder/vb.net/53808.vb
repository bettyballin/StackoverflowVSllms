Module Module1\n    Sub Main()\n        Dim generator As New BarcodeGenerator()\n        generator.CreateCode39Barcode("1234567890", "C:\barcode_output.png")\n    End Sub\nEnd Module