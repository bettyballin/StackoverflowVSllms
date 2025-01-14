Dim originalString As String = "Date: Wed, 5 Nov 2008 13:12:12 -0500 (EST)"\nDim cleanString As String\n\n' Remove unnecessary parts from the string\ncleanString = originalString.Replace("(", "").Replace(")", "").Replace("(EST)", "").Trim()\n\n' Extract the date part after "Date: "\nIf cleanString.StartsWith("Date: ") Then\n    cleanString = cleanString.Substring(6).Trim()\nEnd If\n\nDim dateValue As DateTime\nDim formatString As String = "yyyyMMdd_HHmmss"\n\nIf Date.TryParse(cleanString, System.Globalization.DateTimeFormatInfo.InvariantInfo, Globalization.DateTimeStyles.AdjustToUniversal, dateValue) Then\n    MsgBox(dateValue.ToString(formatString))\nElse\n    MsgBox("Invalid date format.")\nEnd If