document.querySelectorAll('.ajax-link').forEach(link => {\n    link.addEventListener('click', function(event) {\n        event.preventDefault(); // Prevent default link behavior\n\n        // Remove the 'larger-image' class from all links\n        document.querySelectorAll('.ajax-link').forEach(l => l.classList.remove('larger-image'));\n\n        // Add the 'larger-image' class to the clicked link\n        this.classList.add('larger-image');\n\n        // Load content using AJAX (using Fetch API in this example)\n        fetch(this.href)\n            .then(response => response.text())\n            .then(data => {\n                document.getElementById('content-area').innerHTML = data; // Assuming 'content-area' is your target element ID\n            })\n            .catch(error => console.error('Error loading content:', error));\n    });\n});