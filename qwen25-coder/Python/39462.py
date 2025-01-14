function handleUSSDRequest(msisdn, sessionId, ussdCode):\n    if (sessionDoesNotExist(sessionId)):\n        startNewSession(msisdn, sessionId)\n        return "Welcome to our service. Press 1 to proceed."\n    \n    else:\n        switch (ussdCode):\n            case '1':\n                return "Service option. Processing request... #"\n            default:\n                return "Invalid input. Try again."\n\nfunction terminateUSSDSession(sessionId):\n    endCurrentSession(sessionId)\n    return "Thank you for using our service."