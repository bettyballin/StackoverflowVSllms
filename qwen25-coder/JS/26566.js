document.querySelectorAll('.link-like-button').forEach(button => {\n    button.addEventListener('click', function(event) {\n        if (!confirm('Are you sure you want to delete this item?')) {\n            event.preventDefault();\n        }\n    });\n});