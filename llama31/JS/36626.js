// Define the callback function\nfunction processData(data) {\n  console.log(data); // Process the received data\n}\n\n// Create a script tag with the src attribute pointing to your server-side script\nvar script = document.createElement('script');\nscript.src = 'https://your-domain.com/data.php?callback=processData';\ndocument.body.appendChild(script);