function playsong(song) {\n    var htmlString = '<object width="199" height="26">' +\n                     '<param name="movie" value="audio_player_black.swf">' +\n                     '<embed src="audio_player_black.swf?audio_file=upload/' + song + '&color=00000" width="199" height="26">' +\n                     '</embed></object>';\n    parent.document.getElementById('player').innerHTML = htmlString;\n}