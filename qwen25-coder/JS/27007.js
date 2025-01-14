// Example: Adjust H1 size based on viewport width\nfunction scaleH1() {\n    const h1 = document.querySelector('h1');\n    const vw = Math.max(document.documentElement.clientWidth || 0, window.innerWidth || 0);\n    if (vw < 600) {\n        h1.style.fontSize = '24px';\n    } else if (vw >= 600 && vw < 900) {\n        h1.style.fontSize = '32px';\n    } else {\n        h1.style.fontSize = '48px';\n    }\n}\n\nwindow.addEventListener('resize', scaleH1);\ndocument.addEventListener('DOMContentLoaded', scaleH1);