const input = document.getElementById('textbox');\nconst sanitizedHtml = DOMPurify.sanitize(input.value);