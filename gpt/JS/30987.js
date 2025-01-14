document.getElementById('uploadForm').addEventListener('submit', function(event) {\n    event.preventDefault();\n    var fileInput = document.getElementById('fileInput');\n    var formData = new FormData();\n    formData.append('file', fileInput.files[0]);\n\n    var xhr = new XMLHttpRequest();\n    xhr.open('POST', '/upload', true);\n\n    xhr.upload.onprogress = function(event) {\n        if (event.lengthComputable) {\n            var percentComplete = (event.loaded / event.total) * 100;\n            document.getElementById('progressBar').value = percentComplete;\n            document.getElementById('status').innerText = Math.round(percentComplete) + '% uploaded';\n        }\n    };\n\n    xhr.onload = function() {\n        if (xhr.status == 200) {\n            document.getElementById('status').innerText = 'Upload complete!';\n        } else {\n            document.getElementById('status').innerText = 'Upload failed!';\n        }\n    };\n\n    xhr.send(formData);\n});