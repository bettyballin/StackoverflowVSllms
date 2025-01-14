$(function() {\n    $("#flex1").flexigrid({\n        url: 'your_data_url_here.php',\n        dataType: 'json',\n        colModel : [\n            {display: 'ID', name : 'id', width : 50, sortable : true, align: 'left'},\n            {display: 'Name', name : 'name', width : 150, sortable : true, align: 'center'},\n            {display: 'Description', name : 'description', width : 200, sortable : false, align: 'right'}\n        ],\n        usepager: true,\n        title: 'My Data Grid',\n        useRp: true,\n        rp: 15,\n        showTableToggleBtn: true,\n        onSuccess: function() {\n            adjustColumnWidths();\n        }\n    });\n\n    function adjustColumnWidths() {\n        var headers = $('#flex1 .hDiv tr th');\n        var rows = $('#flex1 .bDiv table tr:first-child td');\n\n        headers.each(function(index) {\n            $(this).find('div').width(rows.eq(index).outerWidth());\n        });\n    }\n});