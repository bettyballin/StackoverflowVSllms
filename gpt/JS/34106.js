<script type="text/javascript">\n    // Get the client-side ID of the server control\n    var btnID = '<%= OKToContinueCheckInButton.ClientID %>';\n    var answer = confirm("Some Warning");\n    if (answer) {\n        document.getElementById(btnID).click();\n    }\n</script>