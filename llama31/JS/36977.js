// Check if the URL has an anchor\nif (window.location.hash) {\n  // Scroll to the anchor smoothly\n  var anchor = document.querySelector(window.location.hash);\n  if (anchor) {\n    window.scrollTo({ top: anchor.offsetTop, behavior: 'smooth' });\n  }\n}