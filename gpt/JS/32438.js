document.addEventListener('DOMContentLoaded', function() {\n    const navBar = document.getElementById('navBar');\n\n    // Example of dynamically adding tabs\n    for (let i = 4; i <= 20; i++) {\n        const tab = document.createElement('div');\n        tab.className = 'nav-tab';\n        tab.textContent = `Tab ${i}`;\n        navBar.appendChild(tab);\n    }\n});