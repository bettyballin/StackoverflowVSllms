function downloadWithProgress(url) {\n    var xhr = new XMLHttpRequest();\n\n    // Progress event\n    xhr.addEventListener("progress", function(evt) {\n        if (evt.lengthComputable) {\n            var percentComplete = evt.loaded / evt.total;\n            console.log(percentComplete); // or update your progress bar here\n        }\n    }, false);\n\n    // Completion event\n    xhr.onload = function() {\n        if (this.status === 200) {\n            // Assuming you're fetching an image and want to display it as a data URL\n            var blob = new Blob([this.response], { type: 'image/jpeg' }); // Change MIME type as needed\n            var imageUrl = window.URL.createObjectURL(blob);\n            $('#yourImageElement').attr('src', imageUrl); // Replace with your actual element ID\n        }\n    };\n\n    // Error handling\n    xhr.onerror = function() {\n        console.error("Download error");\n    };\n\n    xhr.responseType = 'arraybuffer'; // Set response type to handle binary data correctly\n    xhr.open('GET', url, true);\n    xhr.send();\n}\n\n// Usage\ndownloadWithProgress('https://example.com/large-image.jpg');