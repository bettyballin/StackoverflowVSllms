function getScreen(url, size) {\n    if (!url) { return ""; }\n    \n    size = (size === 'small') ? '1' : '0';\n    const regex = /[?&]v=([^&#]*)/;\n    let vid = url.match(regex);\n    vid = (vid === null) ? url : vid[1];\n    \n    return `https://img.youtube.com/vi/${vid}/${size}.jpg`;\n}\n\n// Example usage:\nconst imgUrlBig = getScreen("uVLQhRiEXZs"); // default is big\nconst imgUrlSmall = getScreen("uVLQhRiEXZs", 'small');\nconsole.log(imgUrlBig);\nconsole.log(imgUrlSmall);