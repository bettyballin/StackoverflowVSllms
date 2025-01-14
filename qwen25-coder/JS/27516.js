function areAllCheckboxesUnchecked() {\n    const checkboxes = document.querySelectorAll('input[name="us"]');\n    return Array.from(checkboxes).every(checkbox => !checkbox.checked);\n}\n\nconsole.log(areAllCheckboxesUnchecked()); // Returns true if all are unchecked, false otherwise.