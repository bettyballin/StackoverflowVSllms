function scrollToBottom() {\n    var scrollDiv = document.getElementById('scroll');\n    scrollDiv.scrollTop = scrollDiv.scrollHeight;\n}\n\n// Call this function after your initial content is loaded\nscrollToBottom();\n\n// Call this function inside the AJAX request's success callback or wherever you append new messages\nfunction handleNewMessages() {\n    // Code to append new messages here\n\n    scrollToBottom();\n}