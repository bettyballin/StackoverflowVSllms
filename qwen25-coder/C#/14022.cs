using System;\n   using System.Diagnostics;\n\n   Process currentProcess = Process.GetCurrentProcess();\n   long privateMemorySize = currentProcess.PrivateMemorySize64; // Includes all private memory used by the process\n   long workingSet = currentProcess.WorkingSet64; // Represents the physical memory allocated to a process, including both mapped file and image sections.