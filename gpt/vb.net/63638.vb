Dim myObject As Object = Nothing\n\n' Correct way to check if myObject is a null reference\nIf myObject Is Nothing Then\n    Console.WriteLine("myObject is Nothing")\nEnd If\n\n' Also correct, though less commonly used\nIf Nothing Is myObject Then\n    Console.WriteLine("myObject is Nothing")\nEnd If\n\n' This would cause a compiler error\n' If myObject = Nothing Then\n'     Console.WriteLine("myObject is Nothing")\n' End If