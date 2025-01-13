const leftSelect = document.getElementById('left-select');\nconst rightSelect = document.getElementById('right-select');\nconst addBtn = document.getElementById('add-btn');\nconst removeBtn = document.getElementById('remove-btn');\n\naddBtn.addEventListener('click', () => {\n  const selectedOptions = leftSelect.selectedOptions;\n  for (const option of selectedOptions) {\n    rightSelect.appendChild(option.cloneNode(true));\n    leftSelect.removeChild(option);\n  }\n});\n\nremoveBtn.addEventListener('click', () => {\n  const selectedOptions = rightSelect.selectedOptions;\n  for (const option of selectedOptions) {\n    leftSelect.appendChild(option.cloneNode(true));\n    rightSelect.removeChild(option);\n  }\n});