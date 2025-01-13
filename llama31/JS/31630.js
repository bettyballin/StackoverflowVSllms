// Get all links on the page\nconst links = document.querySelectorAll('a');\n\n// Loop through each link and get its coordinates\nlinks.forEach(link => {\n  const rect = link.getBoundingClientRect();\n  console.log(`Link: ${link.href}`);\n  console.log(`X: ${rect.left}`);\n  console.log(`Y: ${rect.top}`);\n  console.log(`Height: ${rect.height}`);\n  console.log(`Width: ${rect.width}`);\n  console.log('---');\n});