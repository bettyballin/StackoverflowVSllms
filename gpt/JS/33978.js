<script>\nfunction SelectSubCheckboxes(link) {\n    $(link).closest('td').next().find('div#Grup input[type="checkbox"]').prop('checked', true);\n}\n</script>