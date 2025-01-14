Imports System.ComponentModel\n\n' Your original class\nPublic Class ColumnProperties\n    Public Property VisibleProperty As String = "Visible"\n    Public Property ConditionalProperty As String = "Conditional"\n\n    <Category("Settings")>\n    Public Property ShowConditional As Boolean\nEnd Class\n\n' Custom type descriptor wrapper\nPublic Class ColumnPropertiesWrapper\n    Implements ICustomTypeDescriptor\n\n    Private ReadOnly _instance As ColumnProperties\n\n    Public Sub New(instance As ColumnProperties)\n        _instance = instance\n    End Sub\n\n    ' Redirect calls to the default implementation\n    Public Function GetAttributes() As AttributeCollection Implements ICustomTypeDescriptor.GetAttributes\n        Return TypeDescriptor.GetAttributes(_instance, True)\n    End Function\n\n    Public Function GetClassName() As String Implements ICustomTypeDescriptor.GetClassName\n        Return TypeDescriptor.GetClassName(Me, False)\n    End Function\n\n    Public Function GetComponentName() As String Implements ICustomTypeDescriptor.GetComponentName\n        Return TypeDescriptor.GetComponentName(Me, False)\n    End Function\n\n    Public Function GetConverter() As TypeConverter Implements ICustomTypeDescriptor.GetConverter\n        Return TypeDescriptor.GetConverter(_instance, True)\n    End Function\n\n    Public Function GetDefaultEvent() As EventDescriptor Implements ICustomTypeDescriptor.GetDefaultEvent\n        Return TypeDescriptor.GetDefaultEvent(Me, False)\n    End Function\n\n    Public Function GetDefaultProperty() As PropertyDescriptor Implements ICustomTypeDescriptor.GetDefaultProperty\n        Return TypeDescriptor.GetDefaultProperty(Me, False)\n    End Function\n\n    Public Function GetEditor(editorBaseType As Type) As Object Implements ICustomTypeDescriptor.GetEditor\n        Return TypeDescriptor.GetEditor(Me, editorBaseType, True)\n    End Function\n\n    Public Function GetEvents() As EventDescriptorCollection Implements ICustomTypeDescriptor.GetEvents\n        Return TypeDescriptor.GetEvents(_instance, True)\n    End Function\n\n    Public Function GetEvents(attributes() As Attribute) As EventDescriptorCollection Implements ICustomTypeDescriptor.GetEvents\n        Return TypeDescriptor.GetEvents(Me, attributes, False)\n    End Function\n\n    Public Function GetProperties() As PropertyDescriptorCollection Implements ICustomTypeDescriptor.GetProperties\n        ' Filter properties here\n        Dim baseProperties = TypeDescriptor.GetProperties(_instance)\n\n        Dim filteredProperties As New List(Of PropertyDescriptor)()\n        For Each pd In baseProperties.OfType(Of PropertyDescriptor)()\n            If pd.Name <> "ConditionalProperty" OrElse _instance.ShowConditional Then\n                filteredProperties.Add(pd)\n            End If\n        Next\n\n        Return New PropertyDescriptorCollection(filteredProperties.ToArray())\n    End Function\n\n    Public Function GetProperties(attributes() As Attribute) As PropertyDescriptorCollection Implements ICustomTypeDescriptor.GetProperties\n        ' Filter properties based on attributes\n        Dim baseProperties = TypeDescriptor.GetProperties(_instance, attributes)\n\n        Dim filteredProperties As New List(Of PropertyDescriptor)()\n        For Each pd In baseProperties.OfType(Of PropertyDescriptor)()\n            If pd.Name <> "ConditionalProperty" OrElse _instance.ShowConditional Then\n                filteredProperties.Add(pd)\n            End If\n        Next\n\n        Return New PropertyDescriptorCollection(filteredProperties.ToArray())\n    End Function\n\n    Public Function GetPropertyOwner(pd As PropertyDescriptor) As Object Implements ICustomTypeDescriptor.GetPropertyOwner\n        Return _instance\n    End Function\nEnd Class\n\n' Usage\nDim oColumn = New ColumnProperties()\nPropertyGrid1.SelectedObject = New ColumnPropertiesWrapper(oColumn)