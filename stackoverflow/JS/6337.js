var recordList = yourMethodToGetRecordListWithAjax();\n\njQuery.each(recordList, function()\n{\n    alert(this.Name); // For example\n});