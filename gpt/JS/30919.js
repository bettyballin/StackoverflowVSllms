var xID = $('#xForm' + num).find('input[name="xID"]').val();\nvar xNum = $('#xForm' + num).find('input[name="xNumber"]').val();\nvar xAmt = $('#xForm' + num).find('input[name="xAmt"]').val();\n\n$.ajax({\n  url: "X.asp",\n  cache: false,\n  type: "POST",\n  data: {\n    XID: xID,\n    xNumber: xNum,\n    xAmt: xAmt\n  },\n  success: function(response) {\n    // Handle the response here\n  },\n  error: function(xhr, status, error) {\n    // Handle errors here\n  }\n});