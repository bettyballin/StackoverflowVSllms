$.ajax({\n  url: "X.asp",\n  cache: false,\n  type: "POST",\n  data: queryString,\n  success: function(response) {\n    // Process the returned status\n    $('#x_'+Num).append(response);\n  }\n});