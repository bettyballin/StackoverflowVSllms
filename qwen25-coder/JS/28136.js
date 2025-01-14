<script>\n    // Capture the URL fragment\n    var urlFragment = window.location.hash.substr(1); // Remove the '#' character\n\n    // Send the fragment to the server via an AJAX request or by setting it as a parameter in a form submission\n    if (urlFragment) {\n        fetch('/capture-fragment', {\n            method: 'POST',\n            headers: {\n                'Content-Type': 'application/x-www-form-urlencoded'\n            },\n            body: 'fragment=' + encodeURIComponent(urlFragment)\n        }).then(response => response.json())\n        .then(data => console.log(data))\n        .catch(error => console.error('Error:', error));\n    }\n</script>