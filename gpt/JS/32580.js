function greet(name, greeting = 'Hello') {\n  console.log(`${greeting}, ${name}!`);\n}\n\ngreet('Alice'); // Output: Hello, Alice!\ngreet('Bob', 'Hi'); // Output: Hi, Bob!