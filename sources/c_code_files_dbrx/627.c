#include <stdio.h>
#include <libxml/xpath.h>

int main() {
    int col = 0; /* Make sure it is defined outside of for loop */
    // assuming expr and subCtx are already defined and initialized
    for (col = 0; col < expr.nbItems; col++) {
        fprintf(stderr, "Evaluating expression:%s\n", expr.itemList[col].val);
        // Evaluate expression
        xpathRows = xmlXPathEvalExpression((xmlChar *)expr.itemList[col].val, subCtx);
    }
    return 0;
}