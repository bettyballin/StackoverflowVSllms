axios.get('https://api.example.com/endpoint')\n  .then(function (response) {\n    console.log(response.data);\n  })\n  .catch(function (error) {\n    console.log(error);\n  });