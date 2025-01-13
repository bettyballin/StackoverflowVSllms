function getLineOffset(element, lineNumber) {\n  var rects = element.get(0).getClientRects();\n  var offset = 0;\n  for (var i = 0; i < rects.length; i++) {\n    if (i === lineNumber - 1) {\n      offset = rects[i].top;\n      break;\n    }\n  }\n  return offset;\n}\n\n// Usage:\nvar block = $('#block');\nvar offset = getLineOffset(block, 5);\nconsole.log(offset);