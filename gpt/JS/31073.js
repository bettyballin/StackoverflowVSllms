function playSong() {\n    var downloadUrl = 'download.php'; // URL to the PHP script\n\n    fetch(downloadUrl)\n        .then(response => response.blob())\n        .then(blob => {\n            var url = URL.createObjectURL(blob);\n            var audio = new Audio(url);\n            audio.play();\n        })\n        .catch(error => console.error('Error downloading the file:', error));\n}