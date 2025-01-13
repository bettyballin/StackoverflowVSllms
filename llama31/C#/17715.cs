string numberString = "0.000";\ndouble possibleDouble;\n\nif (Double.TryParse(numberString, NumberStyles.AllowDecimalPoint, CultureInfo.InvariantCulture, out possibleDouble))\n{\n    Console.WriteLine($"Parsed double: {possibleDouble}");\n}\nelse\n{\n    Console.WriteLine("Input string was not in a correct format");\n}