public decimal ProjectValueToInterval(decimal val, decimal min, decimal max, decimal intervalBottom, decimal intervalTop)\n{\n    decimal valueIntervalSize = max - min;\n    decimal targetIntervalSize = intervalTop - intervalBottom;\n\n    decimal projectionUnit = targetIntervalSize / valueIntervalSize;\n\n    return (val - min) * projectionUnit + intervalBottom;\n}