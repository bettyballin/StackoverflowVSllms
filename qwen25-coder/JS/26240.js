function escapeHtml(unsafe) {\n    return unsafe\n         .replace(/&/g, "&amp;")\n         .replace(/</g, "&lt;")\n         .replace(/>/g, "&gt;")\n         .replace(/"/g, "&quot;")\n         .replace(/'/g, "&#039;");\n}\n\n// Example usage:\nvar userInput = "<script>alert('XSS')</script>";\nvar safeOutput = escapeHtml(userInput);\n$("#preview").text(safeOutput);  // Use .text() to treat the string as text, not HTML