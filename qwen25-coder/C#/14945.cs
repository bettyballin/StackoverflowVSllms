using System;\nusing System.IO;\n\nclass Program {\n    static void Main() {\n        AppDomain.CurrentDomain.SetData("APPBASE", Environment.CurrentDirectory);\n        AppDomain.CurrentDomain.AppendPrivatePath(Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "odac"));\n        \n        // Load your application logic here\n    }\n}