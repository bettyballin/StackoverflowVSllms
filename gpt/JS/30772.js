function functionWithRest(a, ...args) {\n    console.log(a, args);\n}\n\nfunctionWithRest(1, 2, 3, 4); // a = 1, args = [2, 3, 4]