document.getElementById('yourForm').addEventListener('submit', function(event) {\n    event.preventDefault(); // Prevent form submission to handle it via AJAX\n\n    const formData = new FormData(this);\n    \n    fetch('/start-process', {\n        method: 'POST',\n        body: formData\n    })\n    .then(response => response.json())\n    .then(data => {\n        if (data.success) {\n            window.location.href = '/another-page'; // Redirect the user to another page\n        } else {\n            alert('Error starting process');\n        }\n    })\n    .catch(error => console.error('Error:', error));\n});