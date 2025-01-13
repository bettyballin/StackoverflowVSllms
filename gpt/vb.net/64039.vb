Module Module1\n    Sub Main()\n        ' Sample data\n        Dim sample() As Byte = {235, 240, 245, 0, 1, 255, 237, 243, 240, 238, 236}\n\n        ' Step 1: Remove outliers using IQR\n        Dim cleanedSample As List(Of Byte) = RemoveOutliers(sample)\n\n        ' Step 2: Calculate zero-crossings to find frequency\n        Dim frequency As Double = CalculateFrequency(cleanedSample, sampleRate:=44100) ' Assume sample rate is 44100 Hz\n\n        Console.WriteLine("Calculated Frequency: " & frequency & " Hz")\n    End Sub\n\n    Function RemoveOutliers(ByVal data() As Byte) As List(Of Byte)\n        Dim sortedData As List(Of Byte) = data.ToList()\n        sortedData.Sort()\n\n        Dim Q1 As Double = sortedData(sortedData.Count \ 4)\n        Dim Q3 As Double = sortedData(3 * sortedData.Count \ 4)\n        Dim IQR As Double = Q3 - Q1\n\n        Dim lowerBound As Double = Q1 - 1.5 * IQR\n        Dim upperBound As Double = Q3 + 1.5 * IQR\n\n        Return sortedData.Where(Function(x) x >= lowerBound AndAlso x <= upperBound).ToList()\n    End Function\n\n    Function CalculateFrequency(ByVal data As List(Of Byte), ByVal sampleRate As Integer) As Double\n        Dim zeroCrossings As Integer = 0\n        Dim lastValue As Double = data(0) - 128 ' Center around 0\n\n        For i As Integer = 1 To data.Count - 1\n            Dim currentValue As Double = data(i) - 128 ' Center around 0\n            If (lastValue < 0 AndAlso currentValue > 0) OrElse (lastValue > 0 AndAlso currentValue < 0) Then\n                zeroCrossings += 1\n            End If\n            lastValue = currentValue\n        Next\n\n        Dim timePeriod As Double = data.Count / sampleRate ' Total time in seconds\n        Dim frequency As Double = (zeroCrossings / 2) / timePeriod ' Zero-crossings per second\n\n        Return frequency\n    End Function\nEnd Module