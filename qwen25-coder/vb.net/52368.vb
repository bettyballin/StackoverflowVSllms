Function Index() As ActionResult\n    Dim svm As New Stock_ViewModel()\n    \n    ' Retrieve parameters from TempData\n    If TempData.ContainsKey("param1") Then\n        svm.Param1 = CStr(TempData("param1"))\n    End If\n    If TempData.ContainsKey("param2") Then\n        svm.Param2 = CStr(TempData("param2"))\n    End If\n    \n    Return View(svm)\nEnd Functio