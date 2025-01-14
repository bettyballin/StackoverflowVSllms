function MyUtils() {\n  // Member Variables (Constructor)\n  var x = getComplexData();\n  var y = doSomeInitialization();\n\n  // ParamHash Constructor\n  this.ParamHash = function() {\n    // Member variables\n    this.length = 0;\n    this.items = [];\n\n    // Constructor\n    for (var i = 0; i < arguments.length; i += 2) {\n      // Fill the items array.\n      this.items[arguments[i]] = arguments[i + 1];\n      this.length++;\n    }\n  };\n\n  // Utility method to create a new ParamHash\n  this.createParamHash = function() {\n    // Ensure paramHash is a new instance every time\n    this.paramHash = new this.ParamHash(...arguments);\n  };\n\n  // Functions\n  this.doSomething = function() {\n    // Do something.\n    // Uses the items in the ParamHash object.\n    for (var key in this.paramHash.items) {\n      if (this.paramHash.items.hasOwnProperty(key)) {\n        // Really do something!\n      }\n    }\n\n    // Clear the ParamHash object by creating a new instance (if needed).\n  };\n}\n\n// Usage\nvar utils = new MyUtils();\nutils.createParamHash("a", 1, "b", 2);\nutils.doSomething();\n\n// Consequent calls\nutils.createParamHash("c", 3);\nutils.doSomething();