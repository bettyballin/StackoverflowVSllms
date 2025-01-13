$.fn.identify = function(prefix) {\n  var id = 1;\n  return this.each(function() {\n    var newId = prefix + '_' + id++;\n    while (document.getElementById(newId)) {\n      newId = prefix + '_' + id++;\n    }\n    this.id = newId;\n  });\n};