Public Sub Bind(webForm As System.Web.UI.Page, bindingObjects As Hashtable)\n    For Each ctl As Control In webForm.FlattenControls()\n        If ctl.ID.Contains(".") Then\n            Dim parts() = ctl.ID.Split(".")\n            ' Assuming the first part is the key in the hashtable and the second part is the property name\n            Dim objectName As String = parts(0)\n            Dim propertyName As String = parts(1)\n\n            If bindingObjects.ContainsKey(objectName) Then\n                Dim obj As Object = bindingObjects(objectName)\n                Dim propInfo As Reflection.PropertyInfo = obj.GetType().GetProperty(propertyName)\n                If propInfo IsNot Nothing Then\n                    ' Set the value based on the control type, this example assumes TextBox controls\n                    ctl.Text = Convert.ToString(propInfo.GetValue(obj))\n                End If\n            End If\n        End If\n    Next\nEnd Sub