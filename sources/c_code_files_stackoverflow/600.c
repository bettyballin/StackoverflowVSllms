#include <wx/wx.h>

class MyApp : public wxApp {
public:
    bool OnInit() override {
        wxFrame* frame = new wxFrame(nullptr, wxID_ANY, "Font Example");
        wxFont font(24, wxFONTFAMILY_DEFAULT, wxFONTSTYLE_NORMAL, wxFONTWEIGHT_NORMAL, false, "Courier New");
        wxTextCtrl* textCtrl = new wxTextCtrl(frame, wxID_ANY, "Example Text");
        textCtrl->SetFont(font);

        frame->Show(true);
        return true;
    }
};

wxIMPLEMENT_APP(MyApp);