var m = new int[2, 2] { { 1, 2 }, { 3, 4 } };\nvar q = from e in m.Cast<int>() select e;\nforeach (var e in q)\n{\n    Console.WriteLine(e);\n}