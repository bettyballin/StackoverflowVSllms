static const char *formatString = "Value: %d, Min: %d, Max: %d";\n\nsnprintf(tempStr, size, formatString,\n         A2DtoV(testResults[testID].value),\n         A2DtoV(testResults[testID].min),\n         A2DtoV(testResults[testID].max));