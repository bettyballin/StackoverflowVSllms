Imports System.Net.Sockets\nImports System.Text\n\nPublic Class UdpPacketHandler\n    Private Const DELIMITER As Char = "|"c\n\n    Public Structure PacketData\n        Public Id As Integer\n        Public Username As String\n        Public Command As String\n        Public Message As String\n    End Structure\n\n    ' Method to create a packet string from data\n    Public Function CreatePacket(id As Integer, username As String, command As String, message As String) As String\n        Return $"{id}{DELIMITER}{username}{DELIMITER}{command}{DELIMITER}{message}"\n    End Function\n\n    ' Method to parse packet string back into components\n    Public Function ParsePacket(packet As String) As PacketData\n        Dim parts = packet.Split(DELIMITER)\n        If parts.Length < 4 Then\n            Throw New FormatException("Invalid packet format")\n        End If\n\n        Dim result As New PacketData With {\n            .Id = Integer.Parse(parts(0)),\n            .Username = parts(1),\n            .Command = parts(2),\n            .Message = parts(3)\n        }\n\n        Return result\n    End Function\nEnd Class