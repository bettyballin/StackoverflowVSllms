const text = "Hello, check out #758 and #123";\nconst regex = /#(\d+)/g;\nconst replacement = '<a href="#">#$1</a>';\nconst result = text.replace(regex, replacement);\nconsole.log(result);