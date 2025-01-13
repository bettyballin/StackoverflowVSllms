class CallableObject {\n    constructor() {\n        // Initialize properties if needed\n    }\n\n    call(x, y) {\n        console.log(x, y);\n    }\n}\n\n// Create an instance of CallableObject\nconst inst = new CallableObject();\n\n// Call the instance method\ninst.call(1, 2);  // Output: 1 2