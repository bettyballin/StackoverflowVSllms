const form = document.getElementById('myForm');\nconst submitBtn = document.getElementById('submitBtn');\nconst modal = document.getElementById('myModal');\nconst closeBtn = document.getElementById('closeBtn');\n\n// Prevent default form submission\nsubmitBtn.addEventListener('click', (e) => {\n  e.preventDefault();\n  // Open modal/popup window\n  modal.style.display = 'block';\n});\n\n// Handle modal/popup closure\ncloseBtn.addEventListener('click', () => {\n  // Get additional data from modal/popup\n  const additionalData = document.getElementById('additionalData').value;\n  // Resume form submission\n  submitForm(additionalData);\n});\n\n// Submit form programmatically\nfunction submitForm(additionalData) {\n  // Create a new form data object\n  const formData = new FormData(form);\n  // Append additional data to form data\n  formData.append('additionalData', additionalData);\n  // Submit form using XMLHttpRequest or fetch API\n  const xhr = new XMLHttpRequest();\n  xhr.open('POST', '/your-endpoint', true);\n  xhr.send(formData);\n}