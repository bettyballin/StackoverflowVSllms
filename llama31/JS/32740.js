// Assuming you have a server-side generated token to prevent tampering\nvar examToken = '-generated-token-';\n\n// Set the countdown timer\nvar duration = 60 * 60 * 1000; // 1 hour in milliseconds\nvar startTime = new Date().getTime();\nvar endTime = startTime + duration;\n\n// Update the countdown timer every second\nsetInterval(function() {\n  var currentTime = new Date().getTime();\n  var remainingTime = endTime - currentTime;\n  if (remainingTime <= 0) {\n    alert('Time is up!');\n    window.location.href = '/redirect-page';\n  } else {\n    // Update the countdown display\n    document.getElementById('countdown').innerHTML = formatTime(remainingTime);\n  }\n}, 1000);\n\n// Prevent users from tampering with the timer\nwindow.onbeforeunload = function() {\n  if (new Date().getTime() > endTime) {\n    return 'You cannot leave this page until the exam is finished.';\n  }\n};\n\n// Helper function to format the remaining time\nfunction formatTime(millis) {\n  var minutes = Math.floor(millis / 60000);\n  var seconds = Math.floor((millis % 60000) / 1000);\n  return minutes + ':' + (seconds < 10 ? '0' + seconds : seconds);\n}