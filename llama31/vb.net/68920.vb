Dim test As New Class2\ntest.NewProperty2 = "2"\n\nDim go As New ObjectCompare\ngo.TargetObject = test\nDim propInf As PropertyInfo()\npropInf = test.GetType.GetProperties()\ngo.OriginalObject = propInf\ngo.CompareObjects()