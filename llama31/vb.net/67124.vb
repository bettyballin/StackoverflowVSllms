Imports System.Configuration\n\n' Save value\nMy.Settings.VariableName = "SomeValue"\nMy.Settings.Save()\n\n' Load value\nDim variableValue As String = My.Settings.VariableName