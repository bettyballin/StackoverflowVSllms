Int32[] numbers = new Int32[] { 1, 2, 1, 3, 1, 5, 3, 1 };\n\nvar numberText =\n(\n    from n in numbers\n    where n > 0\n    select new\n    {\n        Number = n,\n        Text = \n        (\n            n == 1 ? "One" :\n            n == 2 ? "Two" :\n            n == 3 ? "Three" : "Unknown"\n        )\n    }\n);