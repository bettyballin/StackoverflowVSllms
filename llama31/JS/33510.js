function isMobile() {\n  const userAgent = navigator.userAgent;\n  const mobileRegex = /Android|webOS|iPhone|iPad|iPod|BlackBerry|Windows Phone/i;\n  return mobileRegex.test(userAgent);\n}\n\nif (isMobile()) {\n  // Display mobile version\n} else {\n  // Display desktop version\n}