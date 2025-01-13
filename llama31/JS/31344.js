const image = document.getElementById('map-image');\nconst tooltip = document.getElementById('tooltip');\n\nimage.addEventListener('mouseover', (e) => {\n  const area = e.target.closest('area');\n  if (area) {\n    const title = area.getAttribute('title');\n    tooltip.textContent = title;\n    tooltip.style.top = `${e.clientY}px`;\n    tooltip.style.left = `${e.clientX}px`;\n    tooltip.style.visibility = 'visible';\n  }\n});\n\nimage.addEventListener('mouseout', () => {\n  tooltip.style.visibility = 'hidden';\n});