function getQueryParam(param) {\n    const urlParams = new URLSearchParams(window.location.search);\n    return urlParams.get(param);\n}\n\nfunction isValidPParam(value) {\n    // P followed by 9 integers\n    return /^[P]\d{9}$/.test(value);\n}\n\nfunction isValidBParam(value) {\n    // 15 alphanumeric characters\n    return /^[a-zA-Z0-9]{15}$/.test(value);\n}\n\nfunction setIframeSrc() {\n    const p = getQueryParam('a');\n    const b = getQueryParam('b');\n\n    if (isValidPParam(p) && isValidBParam(b)) {\n        const iframe = document.getElementById("targetIframe");\n        // Constructing a URL with safe parameters\n        iframe.src = `http://someothersite/Page.aspx?a=${encodeURIComponent(p)}&b=${encodeURIComponent(b)}`;\n    } else {\n        console.error("Invalid parameters provided.");\n    }\n}\n\n// Assuming there's an iframe element with id "targetIframe" in your HTML\nsetIframeSrc();