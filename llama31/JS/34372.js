Modalbox.show('your_url', {\n  evalScripts: true,\n  onDomLoaded: function() {\n    new Ajax.Autocompleter("gl_name", "autocomplete_choices", "<? echo WEB_ROOT . $page_name; ?>?action=ajax_autocomplete", {\n      paramName: "value",\n      minChars: 2,\n      indicator: 'indicator1',\n      afterUpdateElement: getSelectionIdGL\n    });\n  }\n});