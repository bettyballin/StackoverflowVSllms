#include <stdexcept>

class InvalidParameter : public std::exception {
  const char* what() const throw() {
    return "Invalid parameter";
  }
};

class Score {

  private:
   int score;

  public:
   static bool valid( int score ) { 
    return score > 0  ; 
   }
 
    Score( int s ) {
    if( ! valid( s ) ) { 
      throw InvalidParameter();
    }

    score = s;
   }
};

int main() {
  try {
    Score s(10);
  } catch (const InvalidParameter& e) {
    // Handle the exception
  }
  return 0;
}