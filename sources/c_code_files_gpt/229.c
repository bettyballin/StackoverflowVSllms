// example.c
#include <wx/wx.h>

int main(int argc, char** argv) {
    wxApp app(argc, argv);
    wxFrame* frame = new wxFrame(nullptr, wxID_ANY, "Hello, World!");
    frame->Show();
    app.MainLoop();
    return 0;
}