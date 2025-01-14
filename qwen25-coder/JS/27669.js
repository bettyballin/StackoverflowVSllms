document.observe('dom:loaded', function() {\n  var checkStatus = function() {\n    new Ajax.Request('process.php', {\n      method: 'get',\n      onSuccess: function(response) {\n        var data = response.responseJSON;\n        if (data.status === 'processing') {\n          $('status').innerHTML = "Processing: " + data.progress + "/" + data.total + "...";\n        } else if (data.status === 'complete') {\n          $('status').innerHTML = "Completed!";\n          // Stop checking once the process is complete\n          clearInterval(interval);\n        }\n      },\n      onFailure: function(response) {\n        $('status').innerHTML = "Failed to update status.";\n      }\n    });\n  };\n\n  var interval = setInterval(checkStatus, 100); // Check every 100ms\n\n  // Trigger the process (e.g., via button click)\n  $('startButton').observe('click', function(event) {\n    event.preventDefault();\n    checkStatus(); // Start checking status\n  });\n});