function minifyJavaScript($javascript) {\n    // Remove all white spaces\n    $javascript = preg_replace('/\s+/', ' ', $javascript);\n    // Remove comments\n    $javascript = preg_replace('#(/\*.*?\*/|//.*?)([\r\n]?)#ms', '', $javascript);\n    return $javascript;\n}\n\n$originalJS = file_get_contents('script.js');\n$minifiedJS = minifyJavaScript($originalJS);\n\nheader("Content-type: application/javascript");\necho $minifiedJS;