<ExpectedException(GetType(ArgumentOutOfRangeException), "Line No exceeds 4 characters.*")> _\n<Test()> _\nSub testLineNoExceedsMaxLength()\n    Dim it As New X("aaaaa", "Test")\nEnd Sub