static ArrayList ReadFromFile(string filename)\n{\n    StreamReader SR;\n    string S;\n    string[] S_split;\n\n    SR = File.OpenText(filename);\n    S = SR.ReadLine();\n\n    ArrayList myItems = new ArrayList();\n\n    List<List<string>> matrix = new List<List<string>>();\n\n    while (S != null)\n    {\n        List<string> row = new List<string>(); // Create a new row list for each iteration\n        S_split = S.Split(' ');\n        for (int i = 1; i < S_split.GetLength(0); i++)\n        {\n            row.Add(S_split[i]);\n        }\n        matrix.Add(row); // Add the row to the matrix after it's populated\n\n        S = SR.ReadLine();\n    }\n    Console.WriteLine(matrix[1][1]);\n    SR.Close();\n    return myItems;\n}