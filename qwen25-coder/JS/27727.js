<script>\n// Function to refresh the notification container\nfunction refreshNotificationContainer() {\n  $('#notificationcontainer').load('http://localhost/member/beta_new/notifications.inc.php').fadeIn("slow");\n}\n\n// Load the notification container immediately on page load\nrefreshNotificationContainer();\n\n// Set an interval to refresh it every X amount of seconds (e.g., 10000 ms = 10 seconds)\nvar auto_refresh = setInterval(refreshNotificationContainer, 10000);\n</script>