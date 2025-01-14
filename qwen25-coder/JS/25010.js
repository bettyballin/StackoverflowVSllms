function printR(obj) {\n    console.log(JSON.stringify(obj, null, 4));\n}\n\n// Example usage:\nlet data = { \n    name: "John Doe",\n    age: 30,\n    children: ["Jane Doe", "Doe Junior"],\n    address: { \n        street: "1234 Elm St",\n        city: "Somewhere"\n    }\n};\n\nprintR(data);