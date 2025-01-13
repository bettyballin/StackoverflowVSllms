// Example of using LINQ with a collection\n   var numbers = new List<int> { 1, 2, 3, 4, 5 };\n   var evenNumbers = from num in numbers\n                     where num % 2 == 0\n                     select num;\n   \n   foreach (var num in evenNumbers)\n   {\n       Console.WriteLine(num);\n   }