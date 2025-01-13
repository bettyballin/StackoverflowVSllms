function incrementCookie() {\n  const cookieName = "myCounter";\n  const defaultValue = 0;\n  const incrementValue = 10;\n\n  // Read current cookie value\n  let value = getCookie(cookieName);\n\n  // If cookie doesn't exist, set default value\n  if (value === "") {\n    value = defaultValue;\n  } else {\n    // Convert string to integer and increment\n    value = parseInt(value) + incrementValue;\n  }\n\n  // Write new value back to cookie\n  setCookie(cookieName, value);\n}\n\n// Helper function to get cookie value\nfunction getCookie(name) {\n  const cookies = document.cookie.split(";");\n  for (let i = 0; i < cookies.length; i++) {\n    let cookie = cookies[i].trim();\n    if (cookie.startsWith(name + "=")) {\n      return cookie.substring(name.length + 1);\n    }\n  }\n  return "";\n}\n\n// Helper function to set cookie value\nfunction setCookie(name, value) {\n  const expires = new Date(Date.now() + 30 * 24 * 60 * 60 * 1000).toUTCString(); // 30 days\n  document.cookie = `${name}=${value}; expires=${expires}; path=/`;\n}