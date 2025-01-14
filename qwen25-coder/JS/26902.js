// Start timer when the page loads\n   var startTime = new Date().getTime();\n\n   // Send time data to server before navigating away\n   window.addEventListener('beforeunload', function (event) {\n       var endTime = new Date().getTime();\n       var timeSpent = endTime - startTime;\n\n       navigator.sendBeacon('/log-time?time=' + timeSpent);\n   });