function generateWindowId() {\n  const randomUUID = crypto.randomUUID();\n  localStorage.setItem('windowId', randomUUID);\n  return randomUUID;\n}\n\n// Get or generate the window ID\nlet windowId = localStorage.getItem('windowId');\nif (!windowId) {\n  windowId = generateWindowId();\n}