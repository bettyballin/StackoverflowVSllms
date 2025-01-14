<script>\nfunction sendHeartbeat() {\n    fetch('/keepAlive', { method: 'GET' })\n        .then(response => console.log('Heartbeat sent'))\n        .catch(error => console.error('Error:', error));\n}\n\n// Send heartbeat every 15 seconds\nsetInterval(sendHeartbeat, 15000);\n</script>