document.querySelectorAll('.tab').forEach(tab => {\n    tab.addEventListener('click', function() {\n        // Remove active class from all tabs\n        document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));\n        // Add active class to the current tab\n        this.classList.add('active');\n        \n        // Hide all content items\n        document.querySelectorAll('.content-item').forEach(item => item.classList.remove('active'));\n        \n        // Show the content item associated with the current tab\n        const target = this.getAttribute('data-target');\n        document.getElementById(target).classList.add('active');\n    });\n});