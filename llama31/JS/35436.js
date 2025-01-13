function bookmarkPage() {\n  var title = "Custom title";\n  var url = window.location.href;\n  // Create a bookmark using the browser's bookmark API (if supported)\n  if (window.sidebar) { // Firefox\n    window.sidebar.addPanel(title, url, "");\n  } else if (window.external) { // IE\n    window.external.addFavorite(url, title);\n  } else { // Other browsers (e.g., Chrome, Safari)\n    alert("Press Ctrl+D (Windows) or Cmd+D (Mac) to bookmark this page.");\n  }\n}