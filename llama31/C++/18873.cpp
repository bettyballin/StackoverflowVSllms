unsigned long start = millis();\nmyFunction(); // call the function you want to measure\nunsigned long end = millis();\n\nunsigned long duration = end - start;\nSerial.println("Execution time: " + String(duration) + " milliseconds");