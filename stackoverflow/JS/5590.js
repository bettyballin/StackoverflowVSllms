function stripCrap(val) {\n  var result = '';\n\n  for(var i = 0, l = val.length; i < l; i++) {\n    var s = val[i];\n    if(String.toCharCode(s) > 31)\n      result += s;\n  }\n\n  return result;\n}