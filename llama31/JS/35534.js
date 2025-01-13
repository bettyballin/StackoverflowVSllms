// Start the process\nfunction startProcess() {\n  new Ajax.Request('/start-process', {\n    method: 'post',\n    parameters: {},\n    onSuccess: function(response) {\n      var token = response.responseText;\n      pollForUpdates(token);\n    }\n  });\n}\n\n// Poll for updates\nfunction pollForUpdates(token) {\n  new Ajax.Request('/get-progress', {\n    method: 'get',\n    parameters: { token: token },\n    onSuccess: function(response) {\n      var progress = response.responseText;\n      updateUI(progress);\n    }\n  });\n  setTimeout(pollForUpdates, 1000, token); // poll every 1 second\n}\n\n// Update the UI\nfunction updateUI(progress) {\n  // update the UI with the received progress information\n  // ...\n}