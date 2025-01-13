const svg = d3.select('svg')\n  .attr('width', 500)\n  .attr('height', 500);\n\n// User-provided SVG content\nconst userInput = '<g><rect x="10" y="10" width="50" height="50" fill="red"/></g>';\n\n// Sanitize the input using D3.js\nconst sanitizedInput = d3.sanitize(userInput);\n\n// Append the sanitized SVG content to the page\nsvg.append('g').html(sanitizedInput);