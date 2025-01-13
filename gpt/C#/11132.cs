ReportDocument mainReport = new ReportDocument();\nmainReport.Load("path_to_main_report.rpt");\n\n// Load the subreport\nReportDocument subReport = new ReportDocument();\nsubReport.Load("path_to_sub_report.rpt");\n\n// Add subreport to the main report\nmainReport.Subreports.Add(subReport);\n\n// Set data source for the main report\nmainReport.SetDataSource(mainDataSet);\n\n// Set data source for the subreport\nsubReport.SetDataSource(subReportDataSet);\n\n// Optionally, set parameter values for the subreport\nmainReport.SetParameterValue("parameterName", parameterValue, "subReportName");\n\n// Display the report in a CrystalReportViewer (if using a viewer)\ncrystalReportViewer.ReportSource = mainReport;