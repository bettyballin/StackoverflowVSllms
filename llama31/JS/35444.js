const urlRegex = /^https?:\/\/[^\s]+\/[^\/]+\.[\w]+$/;\nconst url = "http://example.com/file.pdf";\nif (urlRegex.test(url)) {\n  console.log("URL matches pattern");\n} else {\n  console.log("URL does not match pattern");\n}