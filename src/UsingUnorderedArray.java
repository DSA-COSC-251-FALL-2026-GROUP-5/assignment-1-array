class UsingUnorderedArray {
  public static void main(String[] args) {
    /*
     * UnorderedArray unorderedArray = new UnorderedArray(10);
     * unorderedArray.insert(1);
     * unorderedArray.insert(5);
     * unorderedArray.insert(2);
     * unorderedArray.insert(7);
     * unorderedArray.printInfo();
     * 
     * // resizing test
     * unorderedArray.resize(unorderedArray.nextResizeAmount(unorderedArray.size()))
     * ;
     * unorderedArray.printInfo();
     * 
     * unorderedArray.insert(100);
     * unorderedArray.insert(80);
     * // let's shrink in a lossy way
     * System.out.println("Shrinking...");
     * unorderedArray.resize(5);
     * unorderedArray.printInfo();
     * 
     * // let's now do a left shift at index i
     * int leftShiftIndex = 1;
     * System.out.printf("doing a left shift at index %d\n", leftShiftIndex);
     * unorderedArray.leftShift(leftShiftIndex);
     * unorderedArray.printInfo();
     * 
     * // let's now try the .find method
     * System.out.printf("Finding %d: found at index %d\n", 100,
     * unorderedArray.find(100));
     * 
     * System.out.printf("Finding %d: found at index %d\n", 2,
     * unorderedArray.find(2));
     * 
     * System.out.printf("Finding %d: found at index %d\n", 1000,
     * unorderedArray.find(1000));
     * 
     * unorderedArray.printInfo();
     * int rightShiftIndex = 2;
     * unorderedArray.rightShift(rightShiftIndex);
     * System.out.printf("Right shifting to create space at index %d\n",
     * rightShiftIndex);
     * unorderedArray.printInfo();
     * 
     * int valueToDelete = 0;
     * System.out.println(unorderedArray.delete(10));
     * unorderedArray.printInfo();
     * System.out.println(unorderedArray.delete(7));
     * unorderedArray.printInfo();
     */

    UnorderedArray unorderedArray = new UnorderedArray(10);
    /*
     * unorderedArray.insert(1);
     * unorderedArray.insert(2);
     * unorderedArray.insert(4);
     * unorderedArray.insert(4);
     * unorderedArray.insert(4);
     * unorderedArray.insert(6);
     * unorderedArray.insert(7);
     * unorderedArray.insert(10);
     * unorderedArray.insert(10);
     * unorderedArray.insert(10);
     * unorderedArray.insert(10);
     * unorderedArray.printInfo();
     * System.out.printf("finding 1: %d\n", unorderedArray.binarySearch(1));
     * System.out.printf("finding 2: %d\n", unorderedArray.binarySearch(2));
     * System.out.printf("finding 10: %d\n", unorderedArray.binarySearch(10));
     * System.out.printf("finding 4: %d\n", unorderedArray.binarySearch(4));
     * System.out.printf("finding 3: %d\n", unorderedArray.binarySearch(3));
     * System.out.printf("finding 11: %d\n", unorderedArray.binarySearch(11));
     */
    unorderedArray.insert(1);
    unorderedArray.printInfo();
    System.out.printf("finding 2: %d\n", unorderedArray.binarySearch(2));
  }
}
