Function RoundDownToTwoDecimalPlaces(number As Double) As Double\n    Dim factor As Double = 10 ^ 2 ' 100 for two decimal places\n    Return Math.Floor(number * factor) / factor\nEnd Function\n\n' Example usage:\nDim number As Double = 2.556\nDim roundedNumber As Double = RoundDownToTwoDecimalPlaces(number)\nConsole.WriteLine(roundedNumber) ' Output: 2.55