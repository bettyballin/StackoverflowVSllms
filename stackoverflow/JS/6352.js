$.ajax({\n  url : "place_list.php",\n  data : {action: "create", name: myvariable4},\n  cache : false,\n  error : function(XMLHttpRequest, textStatus, errorThrown){\n     //console.log or alert error\n     alert(errorThrown);\n  },\n  success: function(html){\n     alert("Data Loaded: " + data);\n  }\n});