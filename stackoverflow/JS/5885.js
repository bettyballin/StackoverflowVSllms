function getSelectedParagraphText() {\n  if (window.getSelection) {\n      selection = window.getSelection();\n  } else if (document.selection) {\n      selection = document.selection.createRange();\n  }\n  var parent = selection.anchorNode;\n  while (parent != null && parent.localName != "P") {\n    parent = parent.parentNode;\n  }\n  if (parent == null) {\n    return "";\n  } else {\n    return parent.innerText || parent.textContent;\n  }\n}