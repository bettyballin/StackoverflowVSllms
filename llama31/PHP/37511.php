class MakeItLink {\n    // ... (existing code remains the same)\n\n    protected function _link_reply( $matches ) {\n        $reply = $matches[1];\n        return "<a href='http://twitter.com/{$reply}'>@{$reply}</a>";\n    }\n\n    protected function _link_hashtag( $matches ) {\n        $hashtag = $matches[1];\n        return "<a href='http://search.twitter.com/search?q=%23{$hashtag}'>#{$hashtag}</a>";\n    }\n\n    public function transform( $text ) {\n        // ... (existing code remains the same)\n\n        // Add new preg_replace_callback for @replies\n        $text = preg_replace_callback(\n            '/@(\w+)/',\n            array( 'MakeItLink', '_link_reply' ),\n            $text\n        );\n\n        // Add new preg_replace_callback for #hashtags\n        $text = preg_replace_callback(\n            '/#(\w+)/',\n            array( 'MakeItLink', '_link_hashtag' ),\n            $text\n        );\n\n        return $text;\n    }\n}