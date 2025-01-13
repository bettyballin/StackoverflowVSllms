System.IO.MemoryStream stream = new System.IO.MemoryStream();\n\nstream = (System.IO.MemoryStream)this.Report.ExportToStream(CrystalDecisions.Shared.ExportFormatType.PortableDocFormat);\n\nthis.Response.Clear();\nthis.Response.Buffer = true;\nthis.Response.ContentType = "application/pdf";\n// Set the Content-Disposition header to specify the filename\nthis.Response.AddHeader("Content-Disposition", "attachment;filename=MyReportName.pdf");\nthis.Response.BinaryWrite(stream.ToArray());\nthis.Response.End();