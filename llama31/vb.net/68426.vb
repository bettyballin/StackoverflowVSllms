Imports System.Runtime.InteropServices\n\nDim ptr As IntPtr = mydll.GetString()\nDim myString As String = Marshal.PtrToStringAuto(ptr)