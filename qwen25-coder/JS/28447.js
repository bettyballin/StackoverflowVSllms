document.addEventListener("DOMContentLoaded", function() {\n  const container = document.querySelector('#container'); // Adjust this selector, it should be the parent of all divs\n  let printSections = container.querySelectorAll('div');\n  \n  const pageHeight = window.innerHeight; // Approximate page height in pixels for splitting\n\n  let currentPos = 0;\n  let currentPageDiv;\n\n  function startNewPage() {\n    currentPageDiv = document.createElement('div');\n    currentPageDiv.className = 'print-section';\n    container.appendChild(currentPageDiv);\n  }\n\n  printSections.forEach((div) => {\n    const elHeight = div.offsetHeight + 60; // add some margin/padding to avoid clipping\n\n    if (!currentPageDiv || (currentPos + elHeight > pageHeight)) {\n      startNewPage();\n      currentPos = 0;\n    }\n    \n    currentPageDiv.appendChild(div);\n    currentPos += elHeight;\n  });\n});