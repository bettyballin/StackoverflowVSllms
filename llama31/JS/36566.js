function display(fid) {\n  // Make your Ajax call here\n  new Ajax.Request('my.php', {\n    method: 'post',\n    parameters: {\n      action: 'show',\n      id: fid\n    }\n  });\n  Event.stop(event);\n}