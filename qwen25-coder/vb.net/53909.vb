Imports System.Runtime.InteropServices\n\nModule Module1\n    Sub Main()\n        Dim width As Long = 19005\n        Dim height As Long = 32768\n        Dim size As Long = (width * height * 4) - 1\n\n        ' Allocate memory block of the required size\n        Dim ptr As IntPtr = Marshal.AllocHGlobal(size)\n\n        Try\n            ' Use the allocated memory...\n            ' Example: Set a byte at a specific position (e.g., position 1024)\n            Marshal.WriteByte(ptr, 1024, 255)\n\n            ' Access a byte from the allocated memory...\n            Dim b As Byte = Marshal.ReadByte(ptr, 1024)\n\n            Console.WriteLine("Byte at position 1024: " & b)\n        Finally\n            ' Free the allocated memory to avoid leaks\n            Marshal.FreeHGlobal(ptr)\n        End Try\n\n        Console.ReadLine()\n    End Sub\nEnd Module