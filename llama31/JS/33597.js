// Client-side (JavaScript)\nfunction checkForUpdates() {\n  // Send request to message queue\n  $.ajax({\n    type: 'POST',\n    url: '/message-queue',\n    data: { action: 'check-for-updates' }\n  });\n}