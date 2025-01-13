Dim input As String = "CREATE TABLE [dbo].[User]( [UserId] [int] IDENTITY(1,1) NOT NULL, " & _\n                    "[FirstName] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL, [MiddleName] " & _\n                    "[varchar](50) COLLATE SQL_Latin1_General_CP1_CI_A"\n\nFor Each m As Match In Regex.Matches(input, "\[(?<Field>\w+)\]\s*\[(?<Type>\w+)\]")\n    Console.WriteLine("{0} : {1}", m.Groups("Field").Value, m.Groups("Type").Value)\nNext