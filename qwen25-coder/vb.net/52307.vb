Dim value As Decimal = 3.9 ' Example decimal value\nDim roundedValue As Integer\n\nIf value Mod 1 = 0 Then\n    roundedValue = CInt(value)\nElse\n    roundedValue = CInt(Math.Ceiling(value))\nEnd If\n\nConsole.WriteLine(roundedValue)