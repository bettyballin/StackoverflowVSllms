class Cache {\n    public function __construct(string $inputSource) {\n        if (is_file($inputSource)) {\n            // handle file input\n        } elseif (filter_var($inputSource, FILTER_VALIDATE_URL)) {\n            // handle URL input\n        } else {\n            // handle string input\n        }\n    }\n}