Dim isAtEnd As Boolean = _\n    (richtextbox1.GetFirstCharIndexOfCurrentLine() + richtextbox1.ClientSize.Height >= richTextBox1.GetTotalTextHeight())\n\n' Helper function to get total text height\nPrivate Function GetTotalTextHeight(ByVal rtb As RichTextBox) As Integer\n    Dim lastRow As Int32 = rtb.GetLineFromCharIndex(rtb.TextLength - 1)\n    Using grfx As Graphics = rtb.CreateGraphics()\n        Dim charWidthAverage As Single = GraphicsUnitConverter.Convert( _\n            New PointF(rtb.Font.SizeInPoints, rtb.Font.SizeInPoints), GraphicsUnit.Point, GraphicsUnit.Pixel).X\n        ' Estimate height of each line based on average character size and lines count\n        Return CInt(Math.Ceiling(lastRow * charWidthAverage)) + 10 '10 for padding adjustment\n    End Using\nEnd Function\n\n' Note: This is a simplified estimation. For precise measurement, consider using more detailed calculations or P/Invoke.