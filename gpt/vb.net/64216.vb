Dim dateString As String = "10/01/2008"\nDim dateFormat As String = "dd/MM/yyyy"\nDim parsedDate As DateTime = DateTime.ParseExact(dateString, dateFormat, System.Globalization.CultureInfo.InvariantCulture)\nDim month As Integer = parsedDate.Month