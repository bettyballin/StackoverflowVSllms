fetch(url, { method: 'HEAD' })\n  .then(response => {\n    const contentType = response.headers.get('Content-Type');\n    if (contentType === 'application/x-shockwave-flash') {\n      console.log('SWF file');\n    } else if (contentType === 'image/jpeg') {\n      console.log('JPG file');\n    } else {\n      console.log('Unknown file type');\n    }\n  })\n  .catch(error => console.error(error));