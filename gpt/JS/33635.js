function print_r(obj) {\n    return JSON.stringify(obj, null, 2);\n}\n\n// Example usage:\nvar exampleObject = {\n    name: "John",\n    age: 30,\n    city: "New York",\n    hobbies: ["reading", "traveling", "swimming"]\n};\n\nconsole.log(print_r(exampleObject));