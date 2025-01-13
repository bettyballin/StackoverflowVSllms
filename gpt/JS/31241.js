document.addEventListener('DOMContentLoaded', function() {\n  var dialog = document.getElementById('dialog');\n  var closeButton = document.getElementById('closeButton');\n\n  closeButton.addEventListener('click', function() {\n    dialog.style.display = 'none';\n    // Optionally, send a request to the server to remember this preference\n  });\n});