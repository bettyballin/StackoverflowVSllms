Public Function GetNextNonDuplicateNumber(NumberToCheck as Long) as Long\n    ' The non-duplicate number the function will return\n    Dim NonDuplicate as Long\n\n    If CheckForDuplicate(NumberToCheck) = True Then\n        Throw New DuplicateException()\n    Else\n        NonDuplicate = NumberToCheck\n    End If\n\n    Return NonDuplicate\nEnd Function\n\nPublic Function SafeGetNextNonDuplicateNumber(NumberToCheck as Long) as Long\n    Dim NonDuplicate as Long\n\n    Try\n        NonDuplicate = GetNextNonDuplicateNumber(NumberToCheck)\n    Catch ex as DuplicateException\n        NonDuplicate = IncrementToNonDuplicateValue(NumberToCheck)\n        ' You have handled the duplicate here, now decide if you want to alert other code\n        Throw ex ' Optionally rethrow if you need to alert other parts of the code\n    End Try\n\n    Return NonDuplicate\nEnd Functio