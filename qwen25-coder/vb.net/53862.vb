Imports Microsoft.Office.Interop.Word\n\n' Assuming myFieldInstance is an instance of Word.Field\nDim doc As Document = myFieldInstance.Range.Document\nDim chkBox As CheckBox = Nothing\n\nFor Each formField As FormField In doc.FormFields\n    If formField.Type = WdFieldType.wdFieldFormCheckBox AndAlso _\n       formField.OwnStory.Range.InRange(myFieldInstance.Range) Then\n        chkBox = formField.CheckBox\n        Exit For\n    End If\nNext\n\nIf chkBox IsNot Nothing Then\n    ' Now you can work with the CheckBox object\nEnd If