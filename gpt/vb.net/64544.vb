Sub CopySheetsAndUpdateCharts()\n    Dim wsChart As Worksheet\n    Dim wsData As Worksheet\n    Dim newWsChart As Worksheet\n    Dim newWsData As Worksheet\n    Dim chartObj As ChartObject\n    Dim series As Series\n    Dim oldDataSheetName As String\n    Dim newDataSheetName As String\n    Dim newChartSheetName As String\n    Dim personName As String\n    Dim i As Integer\n    Dim numPeople As Integer\n\n    ' Set the number of people (reports) you want to create\n    numPeople = 5\n\n    ' Loop through the number of people\n    For i = 1 To numPeople\n        personName = "Person" & i\n\n        ' Copy the data sheet\n        Set wsData = ThisWorkbook.Sheets("DataTemplate")\n        wsData.Copy After:=ThisWorkbook.Sheets(ThisWorkbook.Sheets.Count)\n        Set newWsData = ThisWorkbook.Sheets(ThisWorkbook.Sheets.Count)\n        newDataSheetName = personName & " - Data"\n        newWsData.Name = newDataSheetName\n\n        ' Copy the chart sheet\n        Set wsChart = ThisWorkbook.Sheets("ChartTemplate")\n        wsChart.Copy After:=ThisWorkbook.Sheets(ThisWorkbook.Sheets.Count)\n        Set newWsChart = ThisWorkbook.Sheets(ThisWorkbook.Sheets.Count)\n        newChartSheetName = personName & " - Chart"\n        newWsChart.Name = newChartSheetName\n\n        ' Update chart references in the new chart sheet\n        For Each chartObj In newWsChart.ChartObjects\n            For Each series In chartObj.Chart.SeriesCollection\n                series.Formula = Replace(series.Formula, "DataTemplate", newDataSheetName)\n            Next series\n        Next chartObj\n    Next i\nEnd Sub