function asSendSyncMulti() {\n    var httpReq = new XMLHttpRequest();\n\n    showMessage( 'Sending Sync Multipart ' + (++this.reqCount)  );\n\n    // Sync - wait until data arrives\n    httpReq.multipart   = true;     \n    httpReq.open( 'GET', 'server.php?multipart=true&c=' + (this.reqCount), false );\n    httpReq.onload = showReq;\n    httpReq.send( null );\n}\n\nfunction showReq( event ) {\n    if ( event.target.readyState == 4 ) {\n        showMessage( 'Data arrives: ' + event.target.responseText );\n    }\n    else {\n        alert( 'an error occured: ' + event.target.readyState );\n    }\n\n}