<script type="text/javascript">\n    window.onload = function() {\n        if (window.history.replaceState) {\n            const url = new URL(window.location.href);\n            if (url.searchParams.has('QS')) {\n                url.searchParams.delete('QS');\n                window.history.replaceState({}, document.title, url.pathname);\n            }\n        }\n    };\n</script>