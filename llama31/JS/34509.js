// Assuming you have a function to load content via AJAX\nfunction loadContent(url) {\n  // Your AJAX implementation here\n  // For example:\n  var xhr = new XMLHttpRequest();\n  xhr.open('GET', url, true);\n  xhr.onload = function() {\n    if (xhr.status === 200) {\n      document.getElementById('content').innerHTML = xhr.responseText;\n    }\n  };\n  xhr.send();\n}\n\n// Function to handle history changes (back button, forward button, refresh)\nwindow.addEventListener('popstate', function(event) {\n  if (event.state) {\n    loadContent(event.state.url);\n  }\n});\n\n// When you load new content via AJAX, push the new state to the history\nfunction loadNewContent(url) {\n  loadContent(url);\n  window.history.pushState({ url: url }, '', url);\n}\n\n// Example usage:\nloadNewContent('/path/to/content');