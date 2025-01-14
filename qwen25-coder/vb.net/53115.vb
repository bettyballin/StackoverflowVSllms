Public Function CastToNullable(Of T As Structure)(obj As Object) As Nullable(Of T)\n    If obj Is Nothing Then\n        Return Nothing\n    End If\n\n    Dim type = GetType(T)\n\n    ' Check if the object's type matches the struct type or is a nullable of that type\n    If obj.GetType() = type OrElse obj.GetType() = Nullable.GetUnderlyingType(GetType(Nullable(Of T))) Then\n        Return DirectCast(obj, Nullable(Of T))\n    End If\n\n    Throw New InvalidCastException($"The provided object cannot be cast to type {type.Name} or Nullable({type.Name}).")\nEnd Functio