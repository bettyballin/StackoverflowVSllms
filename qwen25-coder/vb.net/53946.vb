' Using IIf - both expressions are evaluated regardless of the condition\nDim result As Integer = IIf(1 > 2, DivideByZero(), 42)\n\n' Using If - only the second expression is evaluated since the condition is false\nresult = If(1 > 2, DivideByZero(), 42)