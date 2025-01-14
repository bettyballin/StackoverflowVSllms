Imports System.IO\nImports System.Runtime.InteropServices\n\nPublic Class ClipboardHelper\n    Public Shared Function GetFileNameFromClipboard() As String\n        Dim fileName As String = ""\n\n        If Clipboard.GetDataObject IsNot Nothing Then\n            Using stream As Stream = Clipboard.GetData("FileGroupDescriptorW")\n                If stream IsNot Nothing Then\n                    Using reader As New BinaryReader(stream)\n                        ' Read the size of the descriptor (first 4 bytes)\n                        Dim wSize As UShort = reader.ReadUInt16()\n                        ' Skip to the file name, which starts at offset 72 in the structure\n                        reader.BaseStream.Position = 72\n                        fileName = Marshal.PtrToStringUni(Marshal.AllocHGlobal(256))\n                        fileName = reader.ReadChars(wSize).ToArray())\n                    End Using\n                End If\n            End Using\n        End If\n\n        Return fileName.TrimEnd(Chr(0))\n    End Function\nEnd Class