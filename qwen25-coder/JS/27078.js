function playsong(song) {\n    parent.document.getElementById('player').innerHTML = `<object width="199" height="26">\n        <param name="movie" value="audio_player_black.swf">\n        <embed src="audio_player_black.swf?audio_file=upload/${song}&color=00000" width="199" height="26"></embed>\n    </object>`;\n}