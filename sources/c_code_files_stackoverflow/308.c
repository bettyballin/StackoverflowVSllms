#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <vector>

void smartSplit(const char* text, char delim, char esc, std::vector<std::string>& tokens) {
    enum State { NORMAL, IN_ESC };
    State state = NORMAL;
    std::string frag;

    for (size_t i = 0; i < strlen(text); ++i) {
        char c = text[i];
        switch (state) {
        case NORMAL:
            if (c == delim) {
                if (!frag.empty())
                    tokens.push_back(frag);
                frag.clear();
            } else if (c == esc)
                state = IN_ESC;
            else
                frag.append(1, c);
            break;
        case IN_ESC:
            frag.append(1, c);
            state = NORMAL;
            break;
        }
    }
    if (!frag.empty())
        tokens.push_back(frag);
}

int main() {
    std::vector<std::string> tokens;
    const char* text = "hello,world\\,foo,bar";
    smartSplit(text, ',', '\\', tokens);
    for (const auto& token : tokens) {
        printf("%s\n", token.c_str());
    }
    return 0;
}