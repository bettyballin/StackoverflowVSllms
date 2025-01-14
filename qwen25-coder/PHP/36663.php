<?php\n\nclass DynamicBlacklist {\n    private $offenses = [];\n    private $maxOffenses = 50; // Minor offenses threshold\n    private $tempBanDuration = 3600 * 24; // 1 day in seconds\n    private const OFFENSE_WEIGHTS = [\n        'invalid_password' => 1,\n        'strange_http_request' => 10,\n        'vulnerability_scan' => 50\n    ];\n\n    function reportOffense($ip, $offenseType) {\n        if (!isset($this->offenses[$ip])) {\n            $this->offenses[$ip] = ['count' => 0, 'timestamp' => time()];\n        }\n        \n        $weight = self::OFFENSE_WEIGHTS[$offenseType] ?? 1;\n        $this->offenses[$ip]['count'] += $weight;\n\n        if ($this->offenses[$ip]['count'] >= $this->maxOffenses) {\n            header("HTTP/1.1 403 Forbidden");\n            die("Access Denied: Too many offenses.");\n        }\n    }\n\n    function checkBan($ip) {\n        if (isset($this->offenses[$ip]) && time() - $this->offenses[$ip]['timestamp'] < $this->tempBanDuration) {\n            header("HTTP/1.1 403 Forbidden");\n            die("Access Denied: IP temporarily banned.");\n        } else {\n            unset($this->offenses[$ip]); // Automatically forgive after the ban period\n        }\n    }\n\n    function clearOldOffenses() {\n        $currentTime = time();\n        foreach ($this->offenses as $ip => $details) {\n            if ($currentTime - $details['timestamp'] >= $this->tempBanDuration) {\n                unset($this->offenses[$ip]);\n            }\n        }\n    }\n}\n\n// Example usage:\n$blacklist = new DynamicBlacklist();\n\n// For every request, check the ban status\n$blacklist->checkBan($_SERVER['REMOTE_ADDR']);\n\n// When there's an offense (e.g., invalid password attempt)\nif ($loginFailed) {\n    $blacklist->reportOffense($_SERVER['REMOTE_ADDR'], 'invalid_password');\n}\n\n?>