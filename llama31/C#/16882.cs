using System.Runtime.InteropServices;\n\n[DllImport("kernel32.dll")]\nstatic extern bool AllocConsole();\n\n[STAThread]\nstatic void Main(string[] args)\n{\n    AllocConsole();\n    // Your code here...\n}