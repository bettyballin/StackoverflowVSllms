function getAspectRatio(width, height) {\n    const gcd = (a, b) => {\n        while(b) {\n            [a, b] = [b, a % b];\n        }\n        return a;\n    };\n\n    const divisor = gcd(width, height);\n    const ratioWidth = width / divisor;\n    const ratioHeight = height / divisor;\n\n    return `${ratioWidth}:${ratioHeight}`;\n}\n\n// Example usage:\nconst windowAspectRatio = getAspectRatio(window.innerWidth, window.innerHeight);\nconsole.log(windowAspectRatio); // Outputs something like "16:9" depending on the window size