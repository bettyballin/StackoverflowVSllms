lock (typeof(Console))\n{\n    TextWriter originalOut = Console.Out;\n    Console.SetOut(new MyTextWriterClass(originalOut));\n}