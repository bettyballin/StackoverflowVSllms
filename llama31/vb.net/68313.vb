Imports System.Text.RegularExpressions\n\nFunction RemoveWhitespaceBetweenTags(html As String) As String\n    Return Regex.Replace(html, ">\s+<", "><")\nEnd Functio