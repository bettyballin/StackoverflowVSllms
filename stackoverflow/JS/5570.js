var scripts = document.getElementsByTagName('script');\nvar lastScript = scripts[scripts.length-1];\nvar scriptName = lastScript.src;\nalert("loading: " + scriptName);