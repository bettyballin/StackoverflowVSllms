function togglePopup(popupId) {\n  var popup = document.getElementById(popupId);\n  if (popup.style.display === "none" || popup.style.display === "") {\n    popup.style.display = "block";\n  } else {\n    popup.style.display = "none";\n  }\n}\n\n// Optional: Adjust popup position based on dynamic content height\nfunction adjustPopupPosition(popupId) {\n  var popup = document.getElementById(popupId);\n  var parent = popup.parentElement;\n  var toolbarHeight = document.getElementById('toolbar').offsetHeight;\n  var popupHeight = popup.offsetHeight;\n  popup.style.bottom = (toolbarHeight + popupHeight + 5) + "px";\n}