// Example (JavaScript) - Basic HTML escaping\nfunction escapeHtml(unsafe) {\n    return unsafe\n         .replace(/&/g, "&amp;")\n         .replace(/</g, "&lt;")\n         .replace(/>/g, "&gt;")\n         .replace(/"/g, "&quot;")\n         .replace(/'/g, "&#039;");\n}