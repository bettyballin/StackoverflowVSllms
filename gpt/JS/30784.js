<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>\n<script>\n  $.get("https://ipinfo.io?token=<YOUR_ACCESS_TOKEN>", function(response) {\n    console.log(response);\n    // You can access the location data here\n    var clientLocation = response;\n    console.log("Client Location: ", clientLocation);\n  }, "jsonp");\n</script>