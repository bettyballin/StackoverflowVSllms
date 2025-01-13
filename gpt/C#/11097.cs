public (double min, double max, double interval) CalculateAxisValues(double minValue, double maxValue, int numberOfTicks, double? optionalValue = null)\n   {\n       double range = maxValue - minValue;\n       double interval = GetNiceNumber(range / (numberOfTicks - 1), true);\n       double axisMin = GetNiceMin(minValue, interval);\n       double axisMax = GetNiceMax(maxValue, interval);\n\n       if (optionalValue.HasValue)\n       {\n           if (optionalValue.Value < axisMin)\n           {\n               axisMin = GetNiceMin(optionalValue.Value, interval);\n           }\n           if (optionalValue.Value > axisMax)\n           {\n               axisMax = GetNiceMax(optionalValue.Value, interval);\n           }\n       }\n\n       return (axisMin, axisMax, interval);\n   }