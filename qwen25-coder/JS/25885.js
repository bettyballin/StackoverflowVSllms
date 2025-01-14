document.getElementById('submitBtn').addEventListener('click', function(e) {\n    e.preventDefault(); // Prevent the default form submission\n\n    var formData = new FormData(document.querySelector('#pdfForm'));\n    \n    fetch('/generate-pdf', { // Replace with your server endpoint\n        method: 'POST',\n        body: formData\n    })\n    .then(response => response.json())\n    .then(data => {\n        if (data.url) {\n            // Disable the button after starting the AJAX request to prevent multiple submissions\n            this.disabled = true;\n            // Assuming data.url is the URL of the generated PDF\n            window.location.href = data.url; // This should trigger the download\n        } else {\n            alert('Failed to generate the PDF.');\n            this.disabled = false; // Re-enable the button if something went wrong\n        }\n    })\n    .catch(error => {\n        console.error('Error:', error);\n        alert('An error occurred while generating the PDF.');\n        this.disabled = false; // Re-enable the button in case of an error\n    });\n});