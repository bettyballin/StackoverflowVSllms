document.addEventListener('DOMContentLoaded', function() {\n    var username = document.getElementById('username');\n    var password = document.getElementById('password');\n\n    // Ensure no default selection on username field\n    username.onfocus = function() {\n        this.setSelectionRange(0, 0);\n    };\n\n    // Prevent any script from focusing the username when the password is clicked\n    password.onclick = function(event) {\n        event.stopPropagation();\n        this.focus();\n    };\n});