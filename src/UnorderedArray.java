public class UnorderedArray extends GenericArray {
  UnorderedArray(int size) {
    super(size);
  }

  @Override
  void insert(int x) {
    // 3. insertion simply inserts it at the end, which should take O(1) because
    // we're keeping track of the occupiedAmount pointer, so we resize if it's going
    // to overflow
    if (occupiedAmount == capacity) {
      resize(nextResizeAmount(capacity));
    }
    arr[occupiedAmount] = x;
    occupiedAmount++;
  }

  @Override
  int find(int x) {
    // TODO: find can only be done through linear search
    return 0;
  }
}
