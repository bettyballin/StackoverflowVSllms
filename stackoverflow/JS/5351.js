function getWidth() {
\n  return Math.max(
\n    document.body.scrollWidth,
\n    document.documentElement.scrollWidth,
\n    document.body.offsetWidth,
\n    document.documentElement.offsetWidth,
\n    document.documentElement.clientWidth
\n  );
\n}
\n
\nfunction getHeight() {
\n  return Math.max(
\n    document.body.scrollHeight,
\n    document.documentElement.scrollHeight,
\n    document.body.offsetHeight,
\n    document.documentElement.offsetHeight,
\n    document.documentElement.clientHeight
\n  );
\n}
\n
\nconsole.log('Width:  ' +  getWidth() );
\nconsole.log('Height: ' + getHeight() );