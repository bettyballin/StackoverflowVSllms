function setSecureCookie(name, value, days) {\n    let expires = "";\n    if (days) {\n        const date = new Date();\n        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));\n        expires = "; expires=" + date.toUTCString();\n    }\n    document.cookie = name + "=" + (value || "") + expires + "; path=/; Secure; SameSite=Strict";\n}\n\nfunction setNonSecureCookie(name, value, days) {\n    let expires = "";\n    if (days) {\n        const date = new Date();\n        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));\n        expires = "; expires=" + date.toUTCString();\n    }\n    document.cookie = name + "=" + (value || "") + expires + "; path=/";\n}\n\n// Example usage\nsetSecureCookie("session_id", "your_secure_session_id", 7); // Secure cookie for HTTPS\nsetNonSecureCookie("logged_in_flag", "true", 7); // Non-secure cookie for HTTP