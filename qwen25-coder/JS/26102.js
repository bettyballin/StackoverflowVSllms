<script type="text/javascript">\n    // Add an event listener for beforeunload\n    window.addEventListener('beforeunload', function (e) {\n        // Set the value in the parent window\n        if (window.opener && !window.opener.closed) {\n            window.opener.document.getElementById('yourHiddenFieldId').value = 'yourValue';\n        }\n\n        // Cancel the event as stated by the standard.\n        e.preventDefault();\n        // Chrome requires returnValue to be set.\n        e.returnValue = '';\n    });\n</script>