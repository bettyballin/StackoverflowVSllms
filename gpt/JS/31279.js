// Example AJAX request using XMLHttpRequest\n   var xhr = new XMLHttpRequest();\n   xhr.onreadystatechange = function() {\n       if (xhr.readyState == 4 && xhr.status == 200) {\n           document.getElementById('result').innerHTML = xhr.responseText;\n       }\n   };\n   xhr.open('GET', 'your_php_file.php', true);\n   xhr.send();