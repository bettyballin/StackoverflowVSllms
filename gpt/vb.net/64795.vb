Imports System.Collections\n\nPublic Function ByteArrayCompare(ByVal array1() As Byte, ByVal array2() As Byte) As Boolean\n    Return StructuralComparisons.StructuralEqualityComparer.Equals(array1, array2)\nEnd Functio