function openFullscreenPopup(url) {\n    var width = screen.width;\n    var height = screen.height;\n    window.open(url, 'newWin', `width=${width},height=${height},resizable=yes,scrollbars=yes`);\n}