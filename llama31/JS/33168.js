const text = "Hello, my email is test@example.com and another email is test2@example.com";\nconst regex = /\b([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)\.([a-zA-Z]{2,})\b/g;\nconst matches = Array.from(text.matchAll(regex));\n\nconsole.log(matches); // Output: [["test@example.com", "test", "example.com", "com"], ["test2@example.com", "test2", "example.com", "com"]]