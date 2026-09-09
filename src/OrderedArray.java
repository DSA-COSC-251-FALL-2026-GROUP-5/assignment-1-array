public class OrderedArray extends GenericArray {
  OrderedArray(int size) {
    super(size);
  }

  @Override
  void insert(int x) {
    // TODO: insert by doing doing binary search to find the index where it's
    // greater than or equal to the previous term and less than or equal to the
    // previous term and then inserting it there.

    // this can be done by a .rightShift at that index, and then simply inserting it
    // at that index (so, the difficult part is the binary search).

    if (occupiedAmount == capacity) {
      // simple resizing if we're full
      resize(nextResizeAmount(capacity));
    }

  }

  @Override
  int find(int x) {
    // TODO: find by doing binary search.
    //
    //
    // NOTE: we can implement a binarySearch utility method that returns the index
    // it
    // should insert, and also returns whether or not it found that value or not so
    // that we can use it for both the .insert and the .find method
    return 0;
  }
}
