Public Function convert(ByVal robert As String)\n    Try\n        robert = Replace(robert, "U", "A")\n        robert = Replace(robert, """", "A")