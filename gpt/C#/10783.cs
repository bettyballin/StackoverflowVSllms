using System;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("sse_example.dll", CallingConvention = CallingConvention.Cdecl)]\n    private static extern void AddFloatArrays(float[] a, float[] b, float[] result, int count);\n\n    static void Main()\n    {\n        float[] a = new float[4] { 1.0f, 2.0f, 3.0f, 4.0f };\n        float[] b = new float[4] { 5.0f, 6.0f, 7.0f, 8.0f };\n        float[] result = new float[4];\n\n        AddFloatArrays(a, b, result, a.Length);\n\n        Console.WriteLine(string.Join(", ", result));  // Output: 6, 8, 10, 12\n    }\n}