Imports System.Diagnostics\n\nSub OpenWordDocument(filePath As String)\n    Process.Start("WINWORD.EXE", filePath)\nEnd Sub