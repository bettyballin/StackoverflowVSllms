var data = { name: "John", time: "2pm" };\n$.post("test.php", data, function(response) {\n  console.log(data.name);  // Outputs: John\n  console.log(data.time);  // Outputs: 2pm\n});