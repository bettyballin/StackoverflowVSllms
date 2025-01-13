function updateProgress() {\n  console.log("Making AJAX request...");\n  new Ajax.Request('/fmfiles/progress_monitor', {\n    parameters: 'authenticity_token=' + encodeURIComponent(AUTH_TOKEN),\n    onSuccess: function(response) {\n      console.log("Received response: " + response.responseText);\n      fillProgress('progressBar',response.responseText);\n    }\n  });\n}