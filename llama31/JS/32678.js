$.ajax({\n  // your Ajax request settings\n  success: function(data) {\n    // update your chat messages\n    const scrollDiv = document.getElementById('scroll');\n    scrollDiv.scrollTop = scrollDiv.scrollHeight;\n  }\n});