var xhr = new XMLHttpRequest();\nxhr.open('POST', 'iframe-contents.php', true);\nxhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\nxhr.send('test-post-parameter=test-post-value');\nxhr.onload = function() {\n  var iframe = document.getElementById('myiframe');\n  iframe.contentWindow.document.body.innerHTML = xhr.responseText;\n};