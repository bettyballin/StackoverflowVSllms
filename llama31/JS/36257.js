const selectElement = document.getElementById('mySelect');\nselectElement.addEventListener('change', (event) => {\n  const selectedValue = event.target.options[event.target.selectedIndex].getAttribute('value');\n  changeCurrentWebsite(selectedValue);\n});