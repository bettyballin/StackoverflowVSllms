var batch = [];\nfor (var i = 0; i < 5; ++i) {\n  batch.push('/Test/LongOperation?p=' + new Date());\n  if (batch.length == 4) {\n    sendBatch(batch);\n    batch = [];\n  }\n}\nif (batch.length > 0) {\n  sendBatch(batch);\n}\n\nfunction sendBatch(urls) {\n  for (var i = 0; i < urls.length; ++i) {\n    var xhr = new XMLHttpRequest();\n    xhr.open('GET', urls[i]);\n    xhr.send('');\n  }\n}