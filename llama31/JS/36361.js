// JavaScript code to render the grid\njQuery(document).ready(function(){\n    jQuery('#grid').jqGrid({\n        url: 'data.php',\n        datatype: 'json',\n        colModel: [\n            {name:'id', index:'id', width:50},\n            {name:'name', index:'name', width:200},\n            {name:'email', index:'email', width:200}\n        ],\n        pager: '#pager',\n        rowNum: 10,\n        rowList: [10,20,30],\n        sortorder: 'asc',\n        viewrecords: true,\n        gridview: true,\n        caption: 'My Grid'\n    });\n});