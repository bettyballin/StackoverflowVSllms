MyObject = function() {\n\n    this.function_one = function(param) {  \n        return param + param;\n    };\n\n    this.function_two = function(param) {\n        return this.function_one(param) * this.function_one(param);\n        // Yes, you need to use 'this' to refer to function_one within the same object\n    };\n\n}