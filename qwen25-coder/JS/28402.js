<script>\n   var conn = new WebSocket('ws://yourserver:port');\n   conn.onopen = function(e) {\n       console.log("Connection established!");\n   };\n\n   conn.onmessage = function(e) {\n       console.log(e.data);\n   };\n\n   conn.onclose = function(e) {\n       console.log("Connection closed.");\n   };\n   </script>