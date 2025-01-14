// Example JSON array returned from the web service\nconst data = [\n  { url: 'https://example.com/image1.jpg', name: 'Image 1' },\n  { url: 'https://example.com/image2.jpg', name: 'Image 2' }\n];\n\n// Function to create and populate the div with the JSON data\nfunction populateDiv(data) {\n  const container = document.getElementById('container'); // Assuming you have a div with id 'container'\n\n  // Clear the container before populating\n  container.innerHTML = '';\n\n  // Iterate over the array of objects\n  data.forEach(item => {\n    // Create the div element\n    const div = document.createElement('div');\n\n    // Create the img element and set the src attribute\n    const img = document.createElement('img');\n    img.src = item.url;\n    div.appendChild(img);\n\n    // Create the text node for the name and append it to the div\n    const textNode = document.createTextNode(item.name);\n    div.appendChild(textNode);\n\n    // Append the div to the container\n    container.appendChild(div);\n  });\n}\n\n// Call the function with the example data\npopulateDiv(data);