<!-- User input is injected directly into a script tag -->\n<script>\n    var userInput = "<script>alert('XSS')</script>";\n    document.getElementById("output").innerHTML = encodeURIComponent(userInput);\n</script>