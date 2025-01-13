' Declares a property.\nDim property1 As New CodeMemberProperty\nproperty1.Name = "integerProperty"\nproperty1.Type = New CodeTypeReference(GetType(Integer))\n\n' Declares a property get statement to return the value of the integer field.\nproperty1.GetStatements.Add(New CodeMethodReturnStatement(New CodeFieldReferenceExpression(New CodeThisReferenceExpression, "integerField")))\n\n' Declares a property set statement to set the value to the integer field.\nDim setValueReference As New CodePropertySetValueReferenceExpression()\nsetValueReference.PropertyName = "Value"\nsetValueReference.Type = New CodeTypeReference(GetType(Integer))\n\nproperty1.SetStatements.Add(New CodeAssignStatement(New CodeFieldReferenceExpression(New CodeThisReferenceExpression, "integerField"), setValueReference))\n\ntype1.Members.Add(property1)