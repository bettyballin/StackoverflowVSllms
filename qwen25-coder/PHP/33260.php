// Assuming $twitter is an instance of Twitter class from twitterlibphp\n$tweets = $twitter->GetFriendsTimeline();\n\nforeach ($tweets as $tweet) {\n    echo clickable_link($tweet['text']);\n}