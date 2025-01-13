Imports XsdCodeGen\n\nModule Module1\n    Sub Main()\n        Dim xsdFile As String = "path/to/your/dataset.xsd"\n        Dim namespace As String = "Your.Namespace"\n        Dim outputFolder As String = "path/to/output/folder"\n\n        Dim generator As New XsdCodeGen.CodeGenerator(xsdFile, namespace, outputFolder)\n        generator.GenerateCode()\n    End Sub\nEnd Module