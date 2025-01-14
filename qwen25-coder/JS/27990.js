// Legacy ActiveX way (example)\n// const activeXObject = new ActiveXObject("Microsoft.REMOTE");\n// activeXObject.OpenURL("http://your-data-service-url");\n\n// Modern JavaScript using Fetch API\nfetch('http://your-data-service-url')\n  .then(response => response.json())\n  .then(data => {\n    console.log('Success:', data);\n  })\n  .catch((error) => {\n    console.error('Error:', error);\n  });