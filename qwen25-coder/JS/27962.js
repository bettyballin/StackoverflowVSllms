// Assuming some functionality that chains these calls\nfunction executeFunctionsSequentially() {\n    firstFunction();\n    secondFunction();\n    thirdFunction();\n}\n\nexecuteFunctionsSequentially();\n\nfunction firstFunction() {\n    console.log('First function executed');\n}\n\nfunction secondFunction() {\n    console.log('Second function executed');\n}\n\nfunction thirdFunction() {\n    console.log('Third function executed');\n}