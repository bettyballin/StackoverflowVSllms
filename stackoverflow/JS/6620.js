function FocusSelected()\n{\n  var lb = document.getElementById("listBox1");\n  if (lb != null)\n  {\n    var options = lb.options;\n    for (var i = options.length - 1; i > 0 ; i--)\n    {\n      if (options[i].selected == true)\n      {\n        options[i].focus();\n        options[i].selected = true;\n        return;\n      }\n    }\n  }\n}