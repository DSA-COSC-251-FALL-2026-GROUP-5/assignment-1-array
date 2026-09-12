class UsingOrderedArray {
  public static void main(String[] args) {
    OrderedArray orderedArray = new OrderedArray(10);
    orderedArray.insert(10);
    orderedArray.insert(9);
    orderedArray.insert(3);
    orderedArray.insert(3);
    orderedArray.insert(3);
    orderedArray.insert(5);
    orderedArray.insert(1);
    orderedArray.insert(3);
    orderedArray.insert(4);
    orderedArray.insert(12);
    orderedArray.insert(13);
    orderedArray.delete(3);
    orderedArray.printInfo();
  }
}
