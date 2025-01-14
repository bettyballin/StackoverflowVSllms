// Assuming you have an array of objects called `data`\nconst data = [\n    { name: 'John', age: 30 },\n    { name: 'Jane', age: 22 }\n];\n\n// Sorting by age in ascending order\ndata.sort((a, b) => a.age - b.age);\n\nconsole.log(data);