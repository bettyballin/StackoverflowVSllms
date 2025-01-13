Sub ExportTables()\n    Dim lTbl As Long\n    Dim dBase As Database\n    Dim TableName As String\n    Dim exportSpec As ExportSpecification\n    \n    Set dBase = CurrentDb\n    \n    For lTbl = 0 To dBase.TableDefs.Count\n        'If the table name is a temporary or system table then ignore it\n        If Left(dBase.TableDefs(lTbl).Name, 1) = "~" Or _\n        Left(dBase.TableDefs(lTbl).Name, 4) = "MSYS" Then\n            '~ indicates a temporary table\n            'MSYS indicates a system level table\n        Else\n            TableName = dBase.TableDefs(lTbl).Name\n            \n            'Create a new export specification\n            Set exportSpec = New ExportSpecification\n            \n            'Set the export specification properties\n            exportSpec.Name = "UnicodeTilde_" & TableName\n            exportSpec.Description = "Unicode tilde delimited export"\n            exportSpec.FieldDelimiter = "~"\n            exportSpec.TextQualifier = ""\n            exportSpec.CodePage = 65001 ' Unicode (UTF-8)\n            \n            'Save the export specification\n            exportSpec.Save\n            \n            'Export the table using the new export specification\n            DoCmd.TransferText acExportDelim, exportSpec.Name, TableName, "c:\" & TableName & ".txt", True\n        End If\n    Next lTbl\n    \n    Set dBase = Nothing\n    Set exportSpec = Nothing\nEnd Sub