function makewindows(html) {\n    var child1 = window.open("about:blank");\n    try {\n        child1.document.write(html);\n    } catch (e) {\n        console.error('Failed to write to window:', e);\n    }\n    child1.document.close();\n}