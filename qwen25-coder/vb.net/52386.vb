Imports System.Management\n\nPublic Function GetProcessorId() As String\n    Dim processorId As String = String.Empty\n    Using searcher As New ManagementObjectSearcher("SELECT * FROM Win32_Processor")\n        For Each obj As ManagementObject In searcher.Get()\n            processorId = obj("ProcessorId").ToString()\n            Exit For\n        Next\n    End Using\n    Return processorId\nEnd Functio