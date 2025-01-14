++
#include <fstream>
#include <sstream>
using std::ios_base;

template<typename Iterator, typename Value>
void iota(Iterator start, Iterator end, Value val) {
    while (start != end) {
        *(start++) = val++;
    }
}

int main() {

    const int dim = 1000;
    const int cubesize = dim*dim*dim;
    const int squaresize = dim*dim;
    const int steps = 7; //ranges from 1 to  255
    typedef unsigned char uchar;

    uchar *partMap = new uchar[cubesize];
    // dummy data. I timed this separately and it takes about
    // a second, so I won't worry about its effect on overall timings.
    iota(partMap, partMap + cubesize, uchar(7));
    uchar *projection = new uchar[squaresize];

    for (int stage = 1; stage < steps; stage++) {
        for (int j = 0; j < dim; j++) {
                for (int i = 0; i < dim; i++)
                {
                        int sum = 0;
                        for (int k = 0; k < dim; k++)
                            if (partMap[(((i * dim) + k) * dim) + j] >= stage)
                                sum++;

                        projection[(j*dim) + i] = sum;
                }
        }

        std::stringstream filename;
        filename << "results" << stage << ".bin";
        std::ofstream file(filename.str().c_str(), 
            ios_base::out | ios_base::binary | ios_base::trunc);
        file.write((char *)projection, squaresize);
    }

    delete[] projection;
    delete[] partMap;
    return 0;
}