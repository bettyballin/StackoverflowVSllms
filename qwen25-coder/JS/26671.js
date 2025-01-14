$("#"+tableId).jqGrid ({\n    url:'getAwards.php?id='+classId,\n    dataType : 'json',\n    mtype:'POST',\n    colNames:['Id','Badge','Name','Description',''],\n    colModel : [\n        {name:'awardId', width:30, sortable:true, align:'center'},\n        {name:'badge', width:40, sortable:false, align:'center'},\n        {name:'name', width:180, sortable:true, align:'left'},\n        {name:'description', width:380, sortable:true, align:'left'},\n        {name:'selected', width:0, sortable:false, align:'center'}\n    ],\n    sortname: "awardId",\n    sortorder: "asc",\n    pager: $('#'+tableId+'_pager'),\n    rowNum:15,\n    rowList:[15,30,50],\n    caption: 'Awards',\n    viewrecords:true,\n    imgpath: 'scripts/jqGrid/themes/green/images',\n    jsonReader : { \n        root: "rows", \n        page: "page", \n        total: "total", \n        records: "records",\n        repeatitems: false,  // Set to false\n        cell: function(row) { return row.cell; },  // Adjust the cell reader\n        id: "id"\n    },\n    width: 700,\n    height: 200\n});