this.someMethod = function() {\n       setTimeout(this.anotherMethod.bind(this), 1000);\n   };