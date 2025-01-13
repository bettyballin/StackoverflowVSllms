<?php\nsession_start(); // Start the session\n\nif(isset($_POST["song"]) && $_POST['song'] != "") {\n    $songs = $_POST["song"];\n} else {\n    $songs = array();\n}\n\n// Generate a unique filename for the playlist\n$playlistFilename = "playlist_" . session_id() . ".xml";\n\n$dom = new DOMDocument("1.0");\n\n// Create root element\n$root = $dom->createElement("playlist");\n$dom->appendChild($root);\n$root->setAttribute('version', "1");\n$root->setAttribute('xmlns', "http://xspf.org/ns/0/");\n$rootnext = $dom->createElement("trackList");\n$root->appendChild($rootnext);\n\nforeach ($songs as $counter) {\n    $tokens = ",";\n    $tokenized = strtok($counter, $tokens);\n\n    // Create child elements\n    $track = $dom->createElement("track");\n    $rootnext->appendChild($track);\n    \n    $creator = $dom->createElement("creator");\n    $track->appendChild($creator);\n    $text = $dom->createTextNode("www.musicking.in");\n    $creator->appendChild($text); \n\n    $title = $dom->createElement("title");\n    $track->appendChild($title);\n    $text = $dom->createTextNode($tokenized);\n    $title->appendChild($text); \n\n    $tokenized = strtok($tokens);\n    $location = $dom->createElement("location");\n    $track->appendChild($location);\n    $text = $dom->createTextNode($tokenized);\n    $location->appendChild($text); \n}\n\n// Save the playlist to a unique file\n$dom->save($playlistFilename);\n?>\n\n<object data="musicplayer.swf?autostart=true&playlist=<?php echo $playlistFilename; ?>" type="application/x-shockwave-flash" width="400" height="300">\n    <param name="movie" value="musicplayer.swf?autostart=true&playlist=<?php echo $playlistFilename; ?>"/>\n</object>