abstract class GenericArray {
  // this class will contain methods that will be inherited by both OrderedArray
  // and UnorderedArray because they share a similar constructor, and utility
  // functions such
  // as .show

  // protected keyword is used because we want the child classes to inherit it
  protected Integer[] arr;
  protected int capacity;
  protected int occupiedAmount;

  GenericArray(int size) {
    // 1. creating the Integer arr[]. java already sets every integer to null when
    // initializing.

    // 2. constructor accepts an integer called size (we use int and not Integer
    // because we don't want the user to input a null when initializing the array)
    arr = new Integer[size];
    // because the occupied array is contiguous, we can keep track of the capacity
    // so that insertion is faster
    occupiedAmount = 0;
    capacity = size;
  }

  // UnorderedArray can just insert at the end, however, OrderedArray must insert
  // in order
  abstract void insert(int x);

  // clearly differs between ordered and unordered arrays
  abstract int find(int x);

  boolean delete(int x) {
    // 4. deletion does differ across ordered and unordered array, however, because
    // a deletion can be implemented using a .find() and a .leftShift() method, we
    // can write its different implementation in a subclass and simply use the
    // interface generically.

    // a .leftShift() is O(n) in the worst case. A .find is O(log(n)) for
    // an ordered array, and O(n) for unordered array
    //
    // As such, for an ordered array:
    // O(n) + O(log(n)) = O(n)
    //
    // For an unordered array:
    // O(n) + O(n) = O(n)

    int indexToDelete = find(x);
    if (indexToDelete == -1) {
      // if we can't find it, then we can't delete it
      return false;
    }
    // simply treat the value at that index as garbage and shift to the left to
    // override it.
    leftShift(indexToDelete);
    return true;
  }

  Integer get(int index) throws IndexOutOfBoundsException {
    // 6. get based on index doesn't differ across ordered and unordered array.

    // the time complexity is O(1) because an array is contiguous in memory, and if
    // the type of the array is known (since java is a statically typed language, it
    // is known), we can internally do some pointer arithmetic to get the location
    // of the address of the ith element and lookup its value.
    if (index >= arr.length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return arr[index];
  }

  int size() {
    // 7. I assume this is the total capacity that the array can hold, which is
    // simply the length of the current array (but if we don't want to use
    // arr.length, we can internally store it too). This will be executed in O(1)
    return capacity;
  }

  int count() {
    // 8. since we're internally storing the capacity anyway, this is a simple
    // lookup that can be executed in O(1) time
    return occupiedAmount;
  }

  void resize(int newSize) {
    // 9. the cannonical way to do this is to first create the new array
    Integer newArr[] = new Integer[newSize];
    // we copy everything up to either the capacity, or the newSize if we were to
    // shrink our array

    // Since we're copying everything, this has a time complexity of O(n)
    capacity = newSize;
    occupiedAmount = Math.min(newSize, occupiedAmount);
    for (int i = 0; i < occupiedAmount; i++) {
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  void leftShift(int index) {
    // a utility function that imagines that there's a hole at index i, and shifts
    // everything beyond it to the left to "fill the hole"

    // assume that error checking has been done prior
    if (occupiedAmount <= 0) {
      return;
    }

    for (int i = index + 1; i < occupiedAmount; i++) {
      arr[i - 1] = arr[i];
    }

    arr[occupiedAmount - 1] = null;
    occupiedAmount--;
  }

  void rightShift(int index) {
    // a utility function that imagines that we need a hole at index i, and shifts
    // everything from index i to the right

    // we assume that we've already checked that it's safe to right shift without
    // loss

    if (!(occupiedAmount <= 0)) {
      for (int i = occupiedAmount; i > index; i--) {
        arr[i] = arr[i - 1];
      }
    }
    // assume that we will replace the space with something else later
    // NOTE: In the case that we're rightShifting beyond occupiedAmount, we'll also
    // increment occupiedAmount and trust that the reason why we called rightShift
    // in the first place is to make space
    occupiedAmount++;
  }

  int nextResizeAmount(int size) {
    // a utility function used as a heuristic to increment the size of the array if
    // we've inserted too many items

    // for now, we'll just arbitrarily resize it to twice the current size.
    return 2 * size;
  }

  int binarySearch(int x) {
    int leftPtr = 0;
    int rightPtr = occupiedAmount;
    // we're searching in the range of [0, occupiedAmount). The reason for this
    // asymmetry is because, we want the index to be the same as doing linear search
    // of x on an ordered array, that is:
    // - we want the first instance of x if it exists
    // - if it doesn't exist, we want the index of the next greatest thing (which
    // works the same for the edge case when x > max(arr))

    int midPtr;
    while (leftPtr < rightPtr) {
      // when they're equal, we have something like: [leftPtr, leftPtr), meaning that
      // it doesn't exists because that range is just the null set. In our case
      // though, we will terminate and return the value of leftPtr.

      midPtr = (leftPtr + rightPtr) / 2;
      // we will update leftPtr such that it's somewhat lazy, meaning that it will
      // only move when we know that arr[midPtr] < x
      if (arr[midPtr] < x) {
        leftPtr = midPtr + 1;
        // this means that there's actually an upper bound on arr[leftPtr], that is,
        // arr[leftPtr] <= x through the whole algorithm, and in the case that
        // arr[leftPtr] == x, it has to be case that it's the first instance because the
        // step before that must have had arr[midPtr] < x, but then, arr[midPtr + 1] ==
        // x. After that happens, leftPtr will never be updated again since this
        // condition would never be satisifed (and this condition is the only place
        // where leftPtr gets updated).
      } else {
        // if arr[midPtr] >= x, then we still want to preserve the case that arr[midPtr]
        // == x. doing rightPtr = midPtr - 1 would be too aggressive because it might be
        // the case that arr[midPtr - 1] < x.
        rightPtr = midPtr;
      }
    }
    return leftPtr;
  }

  void printArray() {
    // an extra utility function for debugging and testing purposes, which just
    // prints the entire array as a string to standard out
    if (arr.length == 0) {
      System.out.println();
    } else {
      System.out.print(arr[0]);
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] == null) {
          System.out.print(", null");
        } else {
          System.out.printf(", %d", arr[i]);
        }
      }
      System.out.println();
    }
  }

  void printInfo() {
    printArray();
    System.out.printf("Unordered array size: %d\n", size());
    System.out.printf("Unordered array occupied: %d\n", count());
  }
}
