interface IPrintable { void Print(); }\nstruct PrintableInt : IPrintable { public int Value; public void Print() { Console.WriteLine(Value); } }\nPrintableInt value = new PrintableInt { Value = 42 };\nIPrintable printable = value; // value is boxed to an IPrintable