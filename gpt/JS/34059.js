document.addEventListener('DOMContentLoaded', function () {\n    const links = document.querySelectorAll('a.ajax-link');\n    links.forEach(link => {\n        link.addEventListener('click', function (event) {\n            event.preventDefault();\n            const url = this.getAttribute('href');\n            loadContent(url);\n            history.pushState({ path: url }, '', url);\n        });\n    });\n\n    window.onpopstate = function (event) {\n        if (event.state) {\n            loadContent(event.state.path);\n        }\n    };\n\n    function loadContent(url) {\n        const xhr = new XMLHttpRequest();\n        xhr.open('GET', url, true);\n        xhr.onload = function () {\n            if (this.status >= 200 && this.status < 400) {\n                document.querySelector('#content').innerHTML = this.response;\n            } else {\n                console.error('Error loading content');\n            }\n        };\n        xhr.onerror = function () {\n            console.error('Request failed');\n        };\n        xhr.send();\n    }\n});