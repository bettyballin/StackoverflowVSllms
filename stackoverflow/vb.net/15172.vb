Dim tempValue As String = myPreviousValue 'changes to the object loose the selected row--save it off and restore later \nMyUltraCombo.DataSource = queryDS.Tables(0) 'load the new data\n\n'Restore the previous selection \nIf tempValue <> "" Then\n    For Each row As Infragistics.Win.UltraWinGrid.UltraGridRow In MyUltraCombo.Rows\n        If row.Cells(0).Value.ToString = tempValue Then\n            MyUltraCombo.SelectedRow = row\n        End If\n    Next\nEnd If