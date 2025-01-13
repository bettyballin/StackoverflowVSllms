// Example using vanilla JavaScript\nconst h1Element = document.querySelector('h1');\nconst viewportWidth = globalThis.innerWidth || 1920; // fallback to a default value\nconst fontSize = viewportWidth * 0.05; // 5% of viewport width\nh1Element.style.fontSize = `${fontSize}px`;