fetch(url, {\n  redirect: 'manual'\n})\n  .then(response => {\n    if (response.status >= 300 && response.status < 400) {\n      // Handle redirect status code\n    } else {\n      // Handle non-redirect status code\n    }\n  })\n  .catch(error => {\n    console.error(error);\n  });