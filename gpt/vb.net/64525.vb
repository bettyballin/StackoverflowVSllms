Sub ConvertMathMLToMathType()\n    Dim mathML As String\n    Dim mtCmd As Object\n    \n    ' Assuming MathML is stored in a string variable\n    mathML = "<math xmlns='http://www.w3.org/1998/Math/MathML'>...</math>"\n    \n    ' Insert the MathML as plain text temporarily\n    Selection.TypeText Text:=mathML\n    \n    ' Convert the inserted MathML to MathType\n    Set mtCmd = CreateObject("MathType6.Command")\n    mtCmd.MathMLToMathType Selection.Range.Text, Selection.Range\nEnd Sub