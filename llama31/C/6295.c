// Example in C\nvoid (*funcPtr)();\n\n// Check CPU capabilities at runtime\nif (isAVXSupported()) {\n    funcPtr = avxOptimizedFunction;\n} else if (isSSESupported()) {\n    funcPtr = sseOptimizedFunction;\n} else {\n    funcPtr = genericFunction;\n}\n\nfuncPtr(); // Call the functio