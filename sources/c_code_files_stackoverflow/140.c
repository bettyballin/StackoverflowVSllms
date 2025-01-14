++
#include<iostream>
#include<fstream>   //used for reading/writing to files, ifstream could have been used, but used fstream for that 'just in case' feeling.
#include<string>    //needed for the filename.
#include<stdio.h>   //for goto statement

using namespace std;

int main()
{
    program:
    char choice;  //lets user choose whether to do another document or not.
    char letter;  //used to track each character in the document.
    int x = 1;    //first counter for tracking correct letter.
    int y = 1;    //second counter (1 is used instead of 0 for ease of reading, 1 being the "first character").
    int z;        //third counter (used as a check to see if the first two counters are equal).
    string filename;    //allows for user to input the filename they wish to use.
    cout << "Please make sure the document is in the same file as the program, thank you!" << endl << "Please input document name: " ;
    cin >> filename; //getline(cin, filename);
    cout << endl;
    cout << "'Every nth character is good', what number is n?: ";
    cin >> z;   //user inputs the number at which the character is good. IE: every 5th character is good, they would input 5.
    cout << endl;
    z = z - 1;  //by subtracting 1, you now have the number of characters you will be skipping, the one after those is the letter you want.
    ifstream infile(filename.c_str()); //gets the filename provided, see below for incorrect input.
    if(infile.is_open()) //checks to see if the file is opened.
    {
        while(!infile.eof())    //continues looping until the end of the file.
        {   
                infile.get(letter);  //gets the letters in the order that that they are in the file.
                if (x == y)          //checks to see if the counters match...
                {
                    x++;             //...if they do, adds 1 to the x counter.
                }
                else
                {
                    if((x - y) == z)            //for every nth character that is good, x - y = nth - 1.
                    {
                        cout << letter;         //...if they don't, that means that character is one you want, so it prints that character.
                        y = x;                  //sets both counters equal to restart the process of counting.
                    }
                    else                        //only used when more than every other letter is garbage, continues adding 1 to the first
                    {                           //counter until the first and second counters are equal.
                        x++;
                    }
                }
        }
        cout << endl << "Decryption complete...if unreadable, please check to see if your input key was correct then try again." << endl;
        infile.close();
        cout << "Do you wish to try again? Please press y then enter if yes (case senstive).";
        cin >> choice;
        if(choice == 'y')
        {
            goto program;
        }
    }
    else  //this prints out and program is skipped in case an incorrect file name is used.
    {
        cout << "Unable to open file, please make sure the filename is correct and that you typed in the extension" << endl;
        cout << "IE:" << "     filename.txt" << endl;
        cout << "You input: " << filename << endl;
        cout << "Do you wish to try again? Please press y then enter if yes (case senstive)." ;
        cin >> choice;
        if(choice == 'y')
        {
            goto program;
        }
    }
    getchar();  //because I use visual C++ express.
}