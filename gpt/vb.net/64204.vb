Dim printerSettings1 As New Printing.PrinterSettings()\nprinterSettings1.PrinterName = "Printer1"\n\nDim printerSettings2 As New Printing.PrinterSettings()\nprinterSettings2.PrinterName = "Printer2"\n\nDim receipt1 As New Receipt("Text for printer 1", printerSettings1)\nDim receipt2 As New Receipt("Text for printer 2", printerSettings2)\n\nreceipt1.Print()\nreceipt2.Print()