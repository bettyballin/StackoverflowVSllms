Imports System.Runtime.CompilerServices\n\n''//functions.vb\nSub LogInfo(ByVal entry As String, <CallerMemberName> Optional ByVal callingMethod As String = "")\n    Console.WriteLine($"[{callingMethod}] {entry}")\nEnd Sub