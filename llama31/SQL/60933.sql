-- Both queries will produce the same results\nSELECT column, COUNT(*) \nFROM table \nGROUP BY column HAVING COUNT(*) > 1;\n\nSELECT column, COUNT('x') \nFROM table \nGROUP BY column HAVING COUNT('x') > 1;