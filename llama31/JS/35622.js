XHR = {\n  init: function() {\n    this.xhr = new XMLHttpRequest();\n    this.xhr.open("GET", "proxy.php?salt=" + Math.round(Math.random() * 10000), true);\n    this.xhr.onreadystatechange = this.process.bind(this);\n    this.xhr.send(null);\n  },\n  process: function() {\n    if (this.xhr.readyState == 4) {\n      console.log(this.xhr.responseText);\n      this.init();\n    }\n  }\n};\n\nwindow.onload = function() {\n  XHR.init();\n};