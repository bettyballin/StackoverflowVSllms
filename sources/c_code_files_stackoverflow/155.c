pp
#include <iostream>
#include <fstream>
#include <string>

int main() {
    std::ifstream fifo;
    std::string   line;
    bool          done = false;

    // code to open your FIFO
    fifo.open("path_to_your_fifo");  // Replace "path_to_your_fifo" with your actual fifo path

    while (!done)
    {
        while (std::getline(fifo, line))
        {
            // do stuff with line
            std::cout << line << std::endl;
        }
        if (fifo.eof())
        {
            fifo.clear();  // Clear the EOF bit to enable further reading
        }
        else
        {
            done = true;
        }
    }

    fifo.close();
    return 0;
}