// Get the menu div and the title div\nconst menuDiv = document.getElementById('menu');\nconst titleDiv = document.getElementById('title');\n\n// Get the initial position of the menu div\nconst menuInitialTop = menuDiv.offsetTop;\n\n// Function to handle scroll event\nfunction handleScroll() {\n  // Get the current scroll position\n  const scrollPosition = window.scrollY;\n\n  // If the scroll position is greater than or equal to the initial position of the menu div\n  if (scrollPosition >= menuInitialTop) {\n    // Add the 'fixed' class to the menu div\n    menuDiv.classList.add('fixed');\n  } else {\n    // Remove the 'fixed' class from the menu div\n    menuDiv.classList.remove('fixed');\n  }\n}\n\n// Add event listener to window scroll event\nwindow.addEventListener('scroll', handleScroll);