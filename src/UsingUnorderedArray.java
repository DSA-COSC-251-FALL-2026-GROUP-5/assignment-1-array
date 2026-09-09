class UsingUnorderedArray {
  public static void main(String[] args) {
    UnorderedArray unorderedArray = new UnorderedArray(10);
    unorderedArray.insert(1);
    unorderedArray.insert(5);
    unorderedArray.insert(2);
    unorderedArray.insert(7);
    unorderedArray.show();
    System.out.printf("Unordered array size: %d\n", unorderedArray.size());
    System.out.printf("Unordered array occupied: %d\n", unorderedArray.count());

    // resizing test
    unorderedArray.resize(unorderedArray.nextResizeAmount(unorderedArray.size()));
    unorderedArray.show();
    System.out.printf("Unordered array size: %d\n", unorderedArray.size());
    System.out.printf("Unordered array occupied: %d\n", unorderedArray.count());

    unorderedArray.insert(100);
    unorderedArray.insert(80);
    // let's shrink in a lossy way
    unorderedArray.show();
    System.out.println("Shrinking...");
    unorderedArray.resize(5);
    unorderedArray.show();
    System.out.printf("Unordered array size: %d\n", unorderedArray.size());
    System.out.printf("Unordered array occupied: %d\n", unorderedArray.count());
  }
}
