function frameset(a) {\n  document.all.frame.src = a + '?' + new Date().getTime();\n}