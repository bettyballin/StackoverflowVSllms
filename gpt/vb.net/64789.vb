Imports System.Globalization\n\ndim myNumericVariable as Integer = Integer.Parse(dr.Item(columnName).ToString(), CultureInfo.InvariantCulture)