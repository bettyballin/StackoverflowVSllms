// Get the link and pop-up elements\nconst trigger = document.getElementById('popup-trigger');\nconst popup = document.getElementById('popup');\nconst closeBtn = document.getElementById('close-popup');\n\n// Add event listeners\ntrigger.addEventListener('click', () => {\n  popup.style.display = 'block';\n});\n\ncloseBtn.addEventListener('click', () => {\n  popup.style.display = 'none';\n});