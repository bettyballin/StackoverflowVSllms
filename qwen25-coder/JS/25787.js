var url = "http://localhost:9080/chat/MyChat";\nvar name = document.getElementById("username").value; // Use .value instead of getAttribute("value")\nvar message = document.getElementById("message").value;\n\nvar tosend = "?name=" + encodeURIComponent(name) + "&message=" + encodeURIComponent(message);\nrequest.open('GET', url + tosend, true);\nrequest.send();