const checkboxes = document.querySelectorAll('input[name="us"]');\nconst allUnchecked = Array.prototype.every.call(checkboxes, checkbox => !checkbox.checked);\nconsole.log(allUnchecked); // true if all checkboxes are unselected