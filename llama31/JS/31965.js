var url = "http://localhost:9080/chat";\n\nvar name = document.getElementById("username").getAttribute("value");\nvar message = document.getElementById("message").getAttribute("value");\n\nvar tosend = name + "," + message;\n\nrequest.open('POST', url, true);\nrequest.setRequestHeader("Content-Type", "text/plain");\nrequest.send(tosend);\nrequest.onreadystatechange = interpretRequest;