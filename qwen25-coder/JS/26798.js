// Example of a simple GET request in RESTful API (using Fetch API)\nfetch('https://api.example.com/blobs/file.txt')\n  .then(response => response.blob())\n  .then(data => console.log(data))\n  .catch(error => console.error('Error:', error));\n\n// Example of a PROPFIND request in WebDAV (simplified using XMLHttpRequest for illustration)\nlet xhr = new XMLHttpRequest();\nxhr.open("PROPFIND", "https://webdav.example.com/blobs/file.txt");\nxhr.setRequestHeader("Depth", "0");\nxhr.onload = function(e) {\n  if (xhr.status === 200) {\n    console.log('File properties retrieved:', xhr.response);\n  } else {\n    console.error('Error fetching file properties');\n  }\n};\nxhr.send();