function getSessionId() {\n    const name = 'session_id=';\n    const decodedCookie = decodeURIComponent(document.cookie);\n    const cookieArray = decodedCookie.split(';');\n    for(let i = 0; i < cookieArray.length; i++) {\n        let cookie = cookieArray[i].trim();\n        if (cookie.indexOf(name) === 0) {\n            return cookie.substring(name.length, cookie.length);\n        }\n    }\n    return null;\n}\n\nconst sessionId = getSessionId();\nconsole.log("Session ID:", sessionId);