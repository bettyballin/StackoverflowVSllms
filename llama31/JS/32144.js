$('.click').editable('updatedb.php', {\n    indicator: "<img src='indicator.gif'>",\n    tooltip: "Click to edit...",\n    onblur: 'submit',\n    style: "inherit",\n    submitdata: function(settings, value) {\n        return { tr_id: $(this).closest('tr').attr('id') };\n    }\n});