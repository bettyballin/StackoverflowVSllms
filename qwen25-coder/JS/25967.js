function updateOutput(newContent) {\n    var outputBox = document.getElementById('outputBox');\n    // Prepend the new content to keep older messages visible\n    outputBox.innerHTML = newContent + '<br>' + outputBox.innerHTML;\n    // Ensure the scrollbar is at the bottom\n    outputBox.scrollTop = 0;\n}\n// Example of calling updateOutput frequently (every second for demonstration)\nsetInterval(function() {\n    // Here you would normally make an AJAX call to fetch data from a server-side script.\n    // For this example, we'll just use static text.\n    var randomText = Math.random().toString(36).substring(2, 10);\n    updateOutput(randomText);\n}, 1000);