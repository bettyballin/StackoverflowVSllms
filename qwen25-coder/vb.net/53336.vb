Dim obj As Object = New YourClass()\n\nIf TypeOf obj Is YourClass Then\n    Console.WriteLine("obj is an instance of YourClass")\nElse\n    Console.WriteLine("obj is not an instance of YourClass")\nEnd If