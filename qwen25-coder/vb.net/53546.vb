Imports System.Linq\n\nPublic Function GenerateQuery(searchType As String) As IQueryable(Of CouncilPlan)\n    Dim db = New YourDataContext()\n    Dim query = db.CouncilPlans.AsQueryable()\n\n    ' Assuming each control's Tag property contains the column name in the database\n    Dim controlsWithValues = From c In Me.Controls\n                             Where TypeOf c Is TextBox AndAlso Not String.IsNullOrEmpty(DirectCast(c, TextBox).Text)\n                             Select c\n\n    For Each ctrl As Control In controlsWithValues\n        Dim columnName As String = DirectCast(ctrl.Tag, String)\n\n        Select Case CType(ctrl, TextBox).Name.ToLower()\n            Case "txtname"\n                query = query.Where(Function(cp) cp.Name.Contains(DirectCast(ctrl, TextBox).Text))\n            Case "txtdescription"\n                query = query.Where(Function(cp) cp.Description.Contains(DirectCast(ctrl, TextBox).Text))\n            ' Add more cases as needed\n        End Select\n\n        ' Alternatively, use dynamic filtering with expressions for better maintainability\n        Dim param = Expression.Parameter(GetType(CouncilPlan), "cp")\n        Dim filterExpression = Expression.Call(\n                                Expression.Property(param, columnName),\n                                GetType(String).GetMethod("Contains", New Type() {GetType(String)}),\n                                Expression.Constant(DirectCast(ctrl, TextBox).Text))\n        query = query.Where(Expression.Lambda(Of Func(Of CouncilPlan, Boolean))(filterExpression, param))\n    Next\n\n    Return query\nEnd Functio