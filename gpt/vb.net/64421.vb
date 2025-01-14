Module Module1\n    Sub Main()\n        ' Define a structure to hold person information\n        Dim People As New Dictionary(Of String, Dictionary(Of String, Object))\n\n        ' Add a person to the dictionary\n        Dim person1 As New Dictionary(Of String, Object)\n        person1("Age") = 30\n        person1("Email") = "john.doe@example.com"\n        person1("IsActive") = True\n\n        People.Add("John Doe", person1)\n\n        ' Add another person to the dictionary\n        Dim person2 As New Dictionary(Of String, Object)\n        person2("Age") = 25\n        person2("Email") = "jane.smith@example.com"\n        person2("IsActive") = False\n\n        People.Add("Jane Smith", person2)\n\n        ' Accessing the data\n        For Each personName In People.Keys\n            Console.WriteLine("Name: " & personName)\n            Dim personInfo As Dictionary(Of String, Object) = People(personName)\n            Console.WriteLine("Age: " & personInfo("Age"))\n            Console.WriteLine("Email: " & personInfo("Email"))\n            Console.WriteLine("Is Active: " & personInfo("IsActive"))\n            Console.WriteLine()\n        Next\n\n        Console.ReadLine()\n    End Sub\nEnd Module