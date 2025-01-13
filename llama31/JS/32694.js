// Check if the browser is online or offline\nfunction isOnline() {\n  return navigator.onLine;\n}\n\n// Add event listeners for online and offline events\nwindow.addEventListener('online', function() {\n  console.log('Browser is online');\n  // Update the page content and hide the offline message\n});\n\nwindow.addEventListener('offline', function() {\n  console.log('Browser is offline');\n  // Show the offline message and prevent page content from changing\n});\n\n// Check the initial online status\nif (!isOnline()) {\n  console.log('Browser is offline');\n  // Show the offline message and prevent page content from changing\n}