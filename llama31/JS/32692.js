setInterval(function() {\n  $.ajax({\n    type: "POST",\n    url: "/KeepAlive.aspx"\n  });\n}, 300000); // 5 minutes