document.addEventListener("DOMContentLoaded", function() {\n    var progressBar = document.getElementById("progress-bar");\n\n    function updateProgressBar(percentage) {\n        progressBar.style.width = percentage + '%';\n        progressBar.textContent = percentage + '%';\n    }\n\n    function loadPage() {\n        var xhr = new XMLHttpRequest();\n        xhr.open("GET", "your-page-url-here", true);\n\n        xhr.onprogress = function(event) {\n            if (event.lengthComputable) {\n                var percentage = Math.round((event.loaded / event.total) * 100);\n                updateProgressBar(percentage);\n            }\n        };\n\n        xhr.onload = function() {\n            if (xhr.status === 200) {\n                // Page loaded successfully\n                updateProgressBar(100);\n            }\n        };\n\n        xhr.onerror = function() {\n            // Handle error\n            alert("An error occurred while loading the page.");\n        };\n\n        xhr.send();\n    }\n\n    loadPage();\n});