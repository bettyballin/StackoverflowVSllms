$(document).ready(function(){\n\n        $("#tags1").autocomplete("/taglookup/", {\n        width: 320,\n        max: 4,\n        highlight: false,\n        multiple: true,\n        multipleSeparator:",",\n        scroll: true,\n        scrollHeight: 300,\n        delay: 10\n         });\n\n      });