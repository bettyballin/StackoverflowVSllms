function toggleTimeInButton(TimeOutButton) {\n    var TimeInButton = TimeOutButton.parentNode.querySelector('#TimeInButton');\n    TimeInButton.style.display = TimeInButton.style.display == 'none' ? '' : 'none';\n}