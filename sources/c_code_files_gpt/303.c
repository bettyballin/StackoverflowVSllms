#include <stdio.h>
#include <gsl/gsl_integration.h>

struct parameters
{
    double a, b;
};

// Define the function to integrate
static double f(double x, void *params)
{
    struct parameters *p = (struct parameters *)params;
    double a = p->a;
    double b = p->b;
    // Adjust this to your actual expression
    return a * x + b;
}

// Function to perform integration
double stuff(double a, double b)
{
    struct parameters par = {a, b};
    gsl_integration_workspace *w;
    double result, error;

    w = gsl_integration_workspace_alloc(1000);

    gsl_function F;
    F.function = &f;
    F.params = &par;

    // Integrate from 0 to 1, adjust the limits as necessary
    gsl_integration_qag(&F, 0, 1, 0, 1e-7, 1000, w, &result, &error);

    gsl_integration_workspace_free(w);

    // Return the result of the integration
    return result;
}

int main()
{
    double a = 2.0, b = 1.0;
    double result = stuff(a, b);

    printf("Result of integration: %g\n", result);

    return 0;
}