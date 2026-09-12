public class OrderedArray extends GenericArray {
  OrderedArray(int size) {
    super(size);
  }

  void insertLinear(int x) {
    // doing this linearly just for differential testing purposes
    if (occupiedAmount == capacity) {
      // simple resizing if we're full
      resize(nextResizeAmount(capacity));
    }
    int insertionIndex = 0;
    for (insertionIndex = 0; insertionIndex < occupiedAmount; insertionIndex++) {
      if (arr[insertionIndex] >= x) {
        break;
      }
    }
    rightShift(insertionIndex);
    arr[insertionIndex] = x;
  }

  @Override
  void insert(int x) {
    // insert by doing doing binary search to find the index where it's
    // greater than or equal to the previous term and less than or equal to the
    // previous term and then inserting it there.

    // this can be done by a .rightShift at that index, and then simply inserting it
    // at that index (so, the difficult part is the binary search).

    // 3.2. insertion requires binary search which is O(log(n)) and a rightShift
    // which is O(n), meaning that insertion takes O(log(n)) + O(n) = O(n)
    if (occupiedAmount == capacity) {
      // simple resizing if we're full
      resize(nextResizeAmount(capacity));
    }
    int insertionIndex = binarySearch(x);
    // even if we're at the end, a rightShift in this case does nothing.
    rightShift(insertionIndex);
    arr[insertionIndex] = x;
  }

  @Override
  int find(int x) {
    // 5.2. find requires one binarySearch which is O(log(n))
    int foundIndex = binarySearch(x);
    if (foundIndex == occupiedAmount) {
      // this prevents us from trying to check for the case when occupiedAmount ==
      // capacity, which would then lead to an index out of range error
      return -1;
    }
    if (arr[foundIndex] != x) {
      return -1;
    }
    return foundIndex;
  }
}
