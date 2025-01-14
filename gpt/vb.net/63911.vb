Imports System.Configuration\nImports System.Collections.Specialized\n\nPublic Class AppNameConfigurationHandler\n    Implements IConfigurationSectionHandler\n\n    Public Function Create(parent As Object, configContext As Object, section As XmlNode) As Object Implements IConfigurationSectionHandler.Create\n        Dim settings As New NameValueCollection()\n\n        For Each childNode As XmlNode In section.ChildNodes\n            If childNode.Attributes IsNot Nothing Then\n                Dim key As String = childNode.Attributes("key").Value\n                Dim value As String = childNode.Attributes("value").Value\n                settings.Add(key, value)\n            End If\n        Next\n\n        Return settings\n    End Function\nEnd Class