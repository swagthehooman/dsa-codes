#include <iostream>
using namespace std;

void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}
int main()
{
    int a, b, c;
    cout << "Enter 3 numbers" << endl;
    cin >> a >> b >> c;
    cout << "a= " << a << endl;
    cout << "b= " << b << endl;
    cout << "c= " << c << endl;

    swap(&a, &b);
    swap(&a, &c);

    cout << "After Swap" << endl;
    cout << "a= " << a << endl;
    cout << "b= " << b << endl;
    cout << "c= " << c << endl;

    return 0;
}