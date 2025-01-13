const ul = document.querySelector('ul');\n\nul.addEventListener('click', (e) => {\n  if (e.target.tagName === 'A') {\n    const activeElement = ul.querySelector('.active');\n    if (activeElement) {\n      activeElement.classList.remove('active');\n    }\n    e.target.parentNode.classList.add('active');\n  }\n});