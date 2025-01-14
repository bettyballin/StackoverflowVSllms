Imports System\n\nModule SimulatedAnnealingExample\n    ' The objective function (Rastrigin function)\n    Function Rastrigin(x As Double) As Double\n        Return 10 + x * x - 10 * Math.Cos(2 * Math.PI * x)\n    End Function\n\n    Sub Main()\n        Dim initialTemperature As Double = 100.0\n        Dim minTemperature As Double = 0.01\n        Dim coolingRate As Double = 0.95\n        Dim currentTemp As Double = initialTemperature\n        Dim solution As Double = 5 ' Initial guess (arbitrary)\n        Dim bestSolution As Double = solution\n        Dim value As Double = Rastrigin(solution)\n        Dim bestValue As Double = value\n\n        Console.WriteLine("Initial Solution: " & solution)\n        Console.WriteLine("Initial Function Value: " & value)\n\n        ' Simulated Annealing Algorithm\n        While currentTemp > minTemperature\n            ' Generate a new neighbor solution around the current solution\n            Dim random As New Random()\n            Dim newSolution As Double = solution + (random.NextDouble() - 0.5) * 4\n            Dim newValue As Double = Rastrigin(newSolution)\n\n            ' Calculate the change in function value\n            Dim deltaE As Double = newValue - value\n\n            ' Decide whether to accept the new solution\n            If deltaE < 0 OrElse Math.Exp(-deltaE / currentTemp) > random.NextDouble() Then\n                solution = newSolution\n                value = newValue\n            End If\n\n            ' Keep track of the best solution found so far\n            If value < bestValue Then\n                bestSolution = solution\n                bestValue = value\n            End If\n\n            ' Cool down\n            currentTemp *= coolingRate\n        End While\n\n        Console.WriteLine("Best Solution: " & bestSolution)\n        Console.WriteLine("Function Value at Best Solution: " & bestValue)\n    End Sub\nEnd Module