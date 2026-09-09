abstract class GenericArray {
  // this class will contain methods that will be inherited by both OrderedArray
  // and UnorderedArray because they share a similar constructor, and utility
  // functions such
  // as .show

  // protected keyword is used because we want the child classes to inherit it
  protected Integer[] arr;

  GenericArray(int size) {
    // 1. creating the Integer arr[]. java already sets every integer to null when
    // initializing.

    // 2. constructor accepts an integer called size (we use int and not Integer
    // because we don't want the user to input a null when initializing the array)
    arr = new Integer[size];
  }

  void show() {
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
    }
  }
}
