array<int> ^ints = gcnew array<int>{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };\nfor each(int i in ints)\n{\n    if(i % 2 == 0)\n        Debug::WriteLine("Even\n");\n    else\n        Debug::WriteLine("Odd\n");\n}