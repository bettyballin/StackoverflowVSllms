pp
#include <iostream>

class CustomAudioNotification {
public:
    CustomAudioNotification() {}
    ~CustomAudioNotification() {}
};

class Session {
public:
    void RegisterSessionNotification(CustomAudioNotification* notification) {
        // implementation of RegisterSessionNotification
    }
};

int main() {
    CustomAudioNotification* customNotification = new CustomAudioNotification();
    Session* SESSION = new Session();
    SESSION->RegisterSessionNotification(customNotification);
    delete customNotification;
    delete SESSION;
    return 0;
}