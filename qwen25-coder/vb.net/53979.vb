' Use AndAlso to avoid division by zero error\nIf divisor <> 0 AndAlso numerator / divisor > threshold Then\n    ' Some action\nEnd If\n\n' Use And when you need both evaluations for side effects\nDim result = (ProcessFirst()) And ProcessSecond()