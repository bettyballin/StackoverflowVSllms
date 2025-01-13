fetch('/upload', {\n  method: 'POST',\n  body: file,\n  headers: {\n    'Content-Type': 'application/octet-stream',\n  },\n})\n  .then((response) => response.json())\n  .catch((error) => console.error('Error:', error))\n  .then((data) => console.log('Success:', data));\n\nconst progress = new Progress();\nfetch('/upload', {\n  method: 'POST',\n  body: file,\n  headers: {\n    'Content-Type': 'application/octet-stream',\n  },\n  progress,\n})\n  .then((response) => response.json())\n  .catch((error) => console.error('Error:', error))\n  .then((data) => console.log('Success:', data));\n\nprogress.addEventListener('progress', (e) => {\n  const percent = Math.round((e.loaded / e.total) * 100);\n  console.log(`Uploaded ${percent}%`);\n  // Update your progress bar here\n});