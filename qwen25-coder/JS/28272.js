const handler = {\n    apply: function(target, thisArg, argumentsList) {\n        return `Called with arguments: ${argumentsList.join(', ')}`;\n    }\n};\n\nconst obj = new Proxy(function() {}, handler);\n\nconsole.log(obj('test', 'function')); // Outputs: Called with arguments: test, functio