let data = [\n    { name: 'Alice', age: 30 },\n    { name: 'Bob', age: 25 },\n    { name: 'Charlie', age: 35 }\n];\n\ndata.sort((a, b) => a.age - b.age);\nconsole.log(data);