// Create a new WaveMaker project\nvar project = new Project("MyApp");\n\n// Create a new page\nvar page = new Page("MyPage");\n\n// Add a button widget to the page\nvar button = new Button("Click me!");\npage.addWidget(button);\n\n// Add an AJAX request to the button's click event\nbutton.addClickHandler(function() {\n  // Make an AJAX request to a web service\n  var xhr = new XMLHttpRequest();\n  xhr.open("GET", "http://example.com/myservice", true);\n  xhr.onload = function() {\n    // Handle the response from the web service\n    console.log(xhr.responseText);\n  };\n  xhr.send();\n});