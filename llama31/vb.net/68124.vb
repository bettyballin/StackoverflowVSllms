Dim diff As Long = 0\nIf Not Session("sessioncreated") Is Nothing Then\n    diff = Now.Ticks - Session("sessioncreated")\nEnd If\nDim timediff As Double = TimeSpan.FromTicks(diff).TotalSeconds