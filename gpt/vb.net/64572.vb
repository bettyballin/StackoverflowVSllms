Dim myRegExp, ResultString\nSet myRegExp = New RegExp\nmyRegExp.Global = True\nmyRegExp.Pattern = "[^\d]"\nResultString = myRegExp.Replace(SubjectString, "")