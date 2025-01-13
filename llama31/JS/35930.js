// Add this script to your page\n(function() {\n  const truncateElements = document.querySelectorAll(".truncate");\n  truncateElements.forEach((element) => {\n    const textElement = element.querySelector(".text");\n    const textWidth = textElement.offsetWidth;\n    const truncateWidth = element.offsetWidth;\n    if (textWidth > truncateWidth) {\n      textElement.style.width = `${truncateWidth}px`;\n    }\n  });\n})();