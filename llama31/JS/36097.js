$.blockUI({\n  message: $('#dialog'),\n  css: {\n    top: ($(window).height() - $('#dialog').height()) / 2 + 'px',\n    left: ($(window).width() - $('#dialog').width()) / 2 + 'px'\n  }\n});