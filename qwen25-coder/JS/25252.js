document.getElementById('formxml').addEventListener('submit', function(event) {\n    event.preventDefault(); // Prevents form submission if you're only processing the data\n    var name = document.getElementById('xmlname').value;\n    console.log(name); // Do something with the value\n});