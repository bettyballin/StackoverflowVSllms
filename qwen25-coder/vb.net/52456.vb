Dim test As New Class2\ntest.NewProperty2 = "2"\n\nDim go As New ObjectCompare\nDim propInf As PropertyInfo()\npropInf = test.GetType.GetProperties()\n\ngo.OriginalObject = propInf\n\n' Pass the instance of Class2 (test) to CompareObjects method\ngo.CompareObjects(test)