// Add this script to thanks.jsp\n<script type="text/javascript">\n    // Check if the current document is inside an iframe\n    if (window.top !== window.self) {\n        // Change the parent window's location to the current URL (thanks.jsp)\n        window.top.location.href = window.location.href;\n    }\n</script>