Dim currentTime As DateTime = DateTime.Now\nIf currentTime.Hour < 12 Then\n    Response.Write("Good Morning")\nElse\n    Response.Write("Good Afternoon")\nEnd If