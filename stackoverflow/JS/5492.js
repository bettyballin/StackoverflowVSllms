function doSomething ( e ) {\n  // get event object and target element\n  var e = e || window.event;\n  var target = e.srcElement || e.target;\n  // is target a div?\n  if ( target && /^div$/i.test( target.nodeName ) ) {\n\n    // do your magic in here ...\n\n  }\n}