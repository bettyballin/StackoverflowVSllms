Dim myNumericVariable As Integer\nIf Integer.TryParse(dr.Item(columnName).ToString(), NumberStyles.Integer, CultureInfo.InvariantCulture, myNumericVariable) Then\n    ' parsing was successful\nElse\n    ' parsing failed\nEnd If