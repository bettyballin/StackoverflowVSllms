// On the user's website, include the JavaScript widget\n<div id="MySite_Info"></div>\n<script>\n  (function() {\n    var script = document.createElement('script');\n    script.src = 'https://your-server.com/jsonp?callback=displayData';\n    document.body.appendChild(script);\n  })();\n\n  function displayData(data) {\n    var infoDiv = document.getElementById('MySite_Info');\n    infoDiv.innerHTML = 'Username: ' + data.username + ', Reputation: ' + data.reputation;\n  }\n</script>