document.addEventListener('DOMContentLoaded', () => {\n  const button = document.getElementById('fetchDataButton');\n  \n  button.addEventListener('click', () => {\n    fetch('/api/data')\n      .then(response => response.json())\n      .then(data => console.log(data))\n      .catch(error => console.error('Error fetching data:', error));\n  });\n});