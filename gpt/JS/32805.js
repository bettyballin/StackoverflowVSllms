<script type="text/javascript">\n    function resizeAccordion() {\n        var container = document.getElementById('container');\n        var accordion = document.getElementById('<%= Accordion1.ClientID %>');\n        accordion.style.height = container.clientHeight + 'px';\n        // Add any additional resizing logic here\n    }\n\n    window.addEventListener('resize', resizeAccordion);\n    window.addEventListener('load', resizeAccordion);\n</script>