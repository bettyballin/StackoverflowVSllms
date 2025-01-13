using Microsoft.Office.Interop.Word;\n\npublic class WordApp\n{\n    Application app = null;\n    object m = System.Reflection.Missing.Value; \n    object oFalse = false; \n    object oTrue = true;\n\n    public void InitializeWordApp()\n    {\n        try\n        {\n            app = new Application();\n            app.Visible = false;\n            app.DisplayAlerts = WdAlertLevel.wdAlertsNone;\n            app.PrintPreview = false;\n        }\n        catch (Exception ex)\n        {\n            // Handle exception\n            Console.WriteLine("Error initializing Word application: " + ex.Message);\n        }\n    }\n\n    public void PrintDocument(string fullPath)\n    {\n        System.Windows.Forms.PrintDialog pd = new System.Windows.Forms.PrintDialog();\n        // Configure the print dialog as needed\n        ...\n\n        this.app.ActivePrinter = pd.PrinterSettings.PrinterName;\n        object oNumcopies = pd.PrinterSettings.Copies;\n        object oRange = WdPrintOutRange.wdPrintAllDocument;\n        object inputname = fullPath;\n        Document doc = app.Documents.Add(\n            ref inputname,\n            ref m,\n            ref m,\n            ref m);\n        try\n        {\n            // Print the document \n            doc.PrintOut(ref oFalse, ref oRange, ref m, ref m, ref m, ref m, ref m, ref m, ref oNumcopies);\n        }\n        catch (Exception ex)\n        {\n            // Handle exception\n            Console.WriteLine("Error printing document: " + ex.Message);\n        }\n        finally\n        {\n            // Cleanup\n            doc.Close(ref oFalse, ref m, ref m);\n            app.Quit(ref oFalse, ref m, ref m);\n        }\n    }\n}