Imports System.Text.RegularExpressions\n\nModule Module1\n    Sub Main()\n        Dim sql As String = "USE [MyDB] GO /****** Object: Table [dbo].[User] Script Date: 07/07/2009 10:16:48 ******/ SET ANSI_NULLS ON GO SET QUOTED_IDENTIFIER ON GO SET ANSI_PADDING ON GO CREATE TABLE [dbo].[User]( [UserId] [int] IDENTITY(1,1) NOT NULL, [FirstName] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL, [MiddleName] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_A NOT NULL )"\n        \n        Dim fields As List(Of String) = ExtractFields(sql)\n\n        For Each field As String In fields\n            Console.WriteLine(field)\n        Next\n    End Sub\n\n    Function ExtractFields(sql As String) As List(Of String)\n        Dim fields As New List(Of String)()\n        Dim pattern As String = "\[(\w+)\]\s+\[(\w+)\]\s*(\([\d,]*\))?"\n        Dim matches As MatchCollection = Regex.Matches(sql, pattern)\n\n        For Each match As Match In matches\n            Dim fieldName As String = match.Groups(1).Value\n            Dim fieldType As String = match.Groups(2).Value\n\n            ' Map SQL data types to .Net types\n            Dim netType As String = MapSqlTypeToNetType(fieldType)\n\n            fields.Add($"{fieldName} {netType}")\n        Next\n\n        Return fields\n    End Function\n\n    Function MapSqlTypeToNetType(sqlType As String) As String\n        Select Case sqlType.ToLower()\n            Case "int"\n                Return "int"\n            Case "varchar", "nvarchar", "text"\n                Return "string"\n            ' Add more mappings as needed\n            Case Else\n                Return "unknown"\n        End Select\n    End Function\nEnd Module