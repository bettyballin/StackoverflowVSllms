if (window.top !== window.self) {\n    // If we're in an iframe, break out by redirecting the top-level window\n    window.top.location.href = 'https://your-redirect-url.com';\n}