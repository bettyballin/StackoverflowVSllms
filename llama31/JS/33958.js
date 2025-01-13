// Add checkboxes to options\nconst select = document.getElementById('mySelect');\nselect.addEventListener('click', (e) => {\n  if (e.target.tagName === 'OPTION') {\n    e.target.innerHTML = '<input type="checkbox" checked>' + e.target.textContent;\n  }\n});\n\n// Allow multiple selections\nselect.addEventListener('change', (e) => {\n  e.preventDefault();\n  const options = select.options;\n  for (let i = 0; i < options.length; i++) {\n    if (options[i].selected) {\n      options[i].innerHTML = '<input type="checkbox" checked>' + options[i].textContent;\n    } else {\n      options[i].innerHTML = '<input type="checkbox">' + options[i].textContent;\n    }\n  }\n});