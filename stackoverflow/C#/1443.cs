class Program\n{\n    [DllImport("the_name_of_the_delphi_library.dll")]\n    public static extern double GetCPUSpeed();\n\n    static void Main(string[] args)\n    {\n        double cpuSpeed = GetCPUSpeed();\n        Console.WriteLine("CPU speed: {0}", cpuSpeed);\n    }\n}