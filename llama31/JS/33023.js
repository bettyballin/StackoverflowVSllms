// Get the viewport size\nvar viewportWidth = window.innerWidth;\nvar viewportHeight = window.innerHeight;\n\n// Send the viewport size to PHP using AJAX\nvar xhr = new XMLHttpRequest();\nxhr.open('POST', 'your_php_script.php', true);\nxhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\nxhr.send('viewportWidth=' + viewportWidth + '&viewportHeight=' + viewportHeight);