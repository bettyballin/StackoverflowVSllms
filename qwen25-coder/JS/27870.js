function sendText(visbool){\n  var http = new GetXmlHttpObject();\n  var form = document.form1;\n  var formData = new FormData();\n  formData.append('overskrift', encodeURIComponent(form.overskrift.value));\n  formData.append('content', encodeURIComponent(form.content.value));\n\n  http.open("POST", "sendtext.php", true);\n  http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");\n  \n  var data = 'overskrift=' + encodeURIComponent(form.overskrift.value) +\n             '&content=' + encodeURIComponent(form.content.value);\n\n  http.send(data);\n}