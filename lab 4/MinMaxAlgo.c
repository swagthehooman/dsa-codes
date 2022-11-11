#include <stdio.h>
#include <limits.h>

void findMinMax(int lb, int ub, int *maxVal, int *minVal, int arr[])
{
    if (lb == ub)
    {
        *maxVal = (*maxVal < arr[ub]) ? arr[ub] : *maxVal;
        *minVal = (*minVal > arr[lb]) ? arr[lb] : *minVal;
        return;
    }

    if (lb == ub - 1)
    {
        if (arr[ub] > arr[lb])
        {
            *maxVal = (*maxVal < arr[ub]) ? arr[ub] : *maxVal;
            *minVal = (*minVal > arr[lb]) ? arr[lb] : *minVal;
        }
        else
        {
            *maxVal = (*maxVal < arr[lb]) ? arr[lb] : *maxVal;
            *minVal = (*minVal > arr[ub]) ? arr[ub] : *minVal;
        }
        return;
    }
    int mid = (lb + ub) / 2;
    findMinMax(lb, mid, maxVal, minVal, arr);
    findMinMax(mid + 1, ub, maxVal, minVal, arr);
}

int main()
{
    printf("Enter number of numbers in array : ");
    int n;
    scanf("%d", &n);
    printf("Enter %d numbers :-\n", n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    int mx = INT_MIN;
    int mn = INT_MAX;
    findMinMax(0, n - 1, &mx, &mn, arr);
    printf("max = %d, min = %d", mx, mn);
    return 0;
}