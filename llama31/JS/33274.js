// Assuming you have a meta tag with id="refreshMeta"\n<meta id="refreshMeta" http-equiv="refresh" content="300;url=/logout">\n\n// In your JavaScript code, after an async request\nvar meta = document.getElementById('refreshMeta');\nmeta.content = '600;url=/logout'; // Update the meta refresh timeout to 10 minutes (600 seconds)