Dim numberStrings = TextBox1.Text.Split(","c).Select(Function(x) x.Trim()))\nColorDialog1.CustomColors = numberStrings.Select(Function(x) CInt(x)).ToArray()