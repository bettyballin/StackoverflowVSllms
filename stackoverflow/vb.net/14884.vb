Dim itemId As Integer\nDim itemType as String\n\nIf Not Integer.TryParse(Request.QueryString("i").ToString, itemId) Then\n    itemId = -1 ' Or whatever your default value is\nElse\n    ' Else not required. Variable itemId contains the value when Integer.TryParse returns True.\nEnd If\n\nitemType = Request.QueryString("t").ToString ' <-- ToString important here!