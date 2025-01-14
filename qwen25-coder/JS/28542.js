function detectMarkup(text) {\n    // Markdown has specific patterns like `#` for headers or `[link text](url)`\n    const markdownPattern = /(^|\n)\s*#{1,6} | \[.*?\]\(.*?\)/gm;\n    // Textile uses different conventions like `h1. Title` or `"Link":http://example.com`\n    const textilePattern = /(^|\n)\s*h\d\.\s| ".*?":\S+/gm;\n\n    if (markdownPattern.test(text)) {\n        return 'Markdown';\n    } else if (textilePattern.test(text)) {\n        return 'Textile';\n    }\n\n    // Fallback, might want to improve this\n    return 'Unknown or mixed format';\n}\n\nconsole.log(detectMarkup("# Header"));  // Output: Markdown\nconsole.log("h1. Header");  // Output: Textile