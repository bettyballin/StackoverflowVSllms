Public Class MyClass(Of BaseType)\n\n    ' Widening conversion from base type to MyClass\n    Public Shared Widening Operator CType(ByVal source As BaseType) As MyClass(Of BaseType)\n        Return New MyClass(Of BaseType)(source)\n    End Operator\n\n    ' Widening conversion from MyClass to base type\n    Public Shared Narrowing Operator CType(ByVal source As MyClass(Of BaseType)) As BaseType\n        Return source.Value ' Assuming 'Value' is a property of your class holding the base type value\n    End Operator\n\n    ' Equality operator for two instances of MyClass\n    Public Shared Operator =(obj1 As MyClass(Of BaseType), obj2 As MyClass(Of BaseType)) As Boolean\n        If obj1 Is Nothing AndAlso obj2 Is Nothing Then Return True\n        If obj1 Is Nothing OrElse obj2 Is Nothing Then Return False\n        Return obj1.Value.Equals(obj2.Value)\n    End Operator\n\n    ' Inequality operator for two instances of MyClass\n    Public Shared Operator <>(obj1 As MyClass(Of BaseType), obj2 As MyClass(Of BaseType)) As Boolean\n        Return Not (obj1 = obj2)\n    End Operator\n\n    ' Override Equals method for object comparison\n    Public Overrides Function Equals(obj As Object) As Boolean\n        If TypeOf obj Is MyBaseType Then\n            Return Me.Value.Equals(CType(obj, MyBaseType))\n        End If\n        If TypeOf obj Is MyClass(Of BaseType) Then\n            Return CType(obj, MyClass(Of BaseType)).Value.Equals(Me.Value)\n        End If\n        Return False\n    End Function\n\n    ' Override GetHashCode method (important for collections)\n    Public Overrides Function GetHashCode() As Integer\n        Return Me.Value.GetHashCode()\n    End Function\n\n    ' Field to hold the base type value\n    Private _value As BaseType\n\n    ' Constructor\n    Public Sub New(value As BaseType)\n        _value = value\n    End Sub\n\n    ' Property to access the base type value\n    Public ReadOnly Property Value As BaseType\n        Get\n            Return _value\n        End Get\n    End Property\nEnd Class