public class OrderedArrayTest {
    public static void main(String[] args) {
        testConstructor();
        testConstructorSizeZero();
        testInsert();
        testInsertAtBeginning();
        testInsertAtEnd();
        testInsertAtMiddle();
        testInsertAutoResize();
        testInsertMultipleAfterResize();
        testInsertMaintainsOrder();
        testInsertMaintainsOrderNegative();
        testInsertMaintainsOrderZero();
        testInsertDuplicates();
        testInsertDuplicatesPreserveAll();
        testInsertAllSameElements();
        testFind();
        testFindFirstOccurrenceDuplicates();
        testFindSmallerThanAll();
        testFindLargerThanAll();
        testFindBetweenElements();
        testFindNotFound();
        testFindOnEmptyArray();
        testFindSingleElement();
        testDeleteFirstElement();
        testDeleteLastElement();
        testDeleteMiddleElement();
        testDeleteOnlyElement();
        testDeleteNotFound();
        testDeleteFromEmptyArray();
        testDeleteMultipleInSequence();
        testDeleteMaintainsSortedOrder();
        testSize();
        testSizeDoesNotChangeAfterDelete();
        testCount();
        testCountAfterMultipleDeletes();
        testResizeExpand();
        testResizeShrink();
        testResizeToZero();
        testResizePreserveOrder();
        testResizeLargerThenSmaller();
        testResizeInsertAfterShrink();
        testResizeGetNullPositionsAfterShrink();
        testGet();
        testGetNullPosition();
        testGetNullAfterShrink();
        testGetIndexZeroOnEmptyCapacity();
        testGetIndexOutOfBoundsNegative();
        testGetIndexOutOfBoundsLarge();
        testGetIndexAtCapacity();
        testDeleteThenInsert();
        testInsertAfterDeleteMaintainsOrder();
        testEmptyArray();
        testSortedProperty();
        testInsertIntoCapacityZeroThenInsert();
        testLargeArrayOperations();
        System.out.println("All OrderedArrayTest tests passed!");
    }

    static void testConstructor() {
        OrderedArray oa = new OrderedArray(5);
        assert oa.size() == 5 : "size should be 5";
        assert oa.count() == 0 : "count should be 0";
    }

    static void testConstructorSizeZero() {
        OrderedArray oa = new OrderedArray(0);
        assert oa.size() == 0 : "size should be 0";
        assert oa.count() == 0 : "count should be 0";
    }

    static void testInsert() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(30);
        oa.insert(10);
        oa.insert(20);
        assert oa.count() == 3 : "count should be 3";
        assert oa.find(10) == 0 : "10 at index 0";
        assert oa.find(20) == 1 : "20 at index 1";
        assert oa.find(30) == 2 : "30 at index 2";
    }

    static void testInsertAtBeginning() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(2);
        oa.insert(1);
        assert oa.find(1) == 0 : "1 at index 0 (inserted at beginning)";
        assert oa.find(2) == 1 : "2 at index 1";
    }

    static void testInsertAtEnd() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.insert(3);
        assert oa.find(3) == 2 : "3 at index 2 (inserted at end)";
    }

    static void testInsertAtMiddle() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(3);
        oa.insert(2);
        assert oa.find(1) == 0 : "1 at index 0";
        assert oa.find(2) == 1 : "2 at index 1 (middle)";
        assert oa.find(3) == 2 : "3 at index 2";
    }

    static void testInsertAutoResize() {
        OrderedArray oa = new OrderedArray(2);
        oa.insert(2);
        oa.insert(1);
        assert oa.size() == 2 : "size still 2 before overflow";
        oa.insert(3);
        assert oa.size() == 4 : "size doubled to 4";
        assert oa.count() == 3 : "count should be 3";
        assert oa.find(1) != -1 : "1 found";
        assert oa.find(2) != -1 : "2 found";
        assert oa.find(3) != -1 : "3 found";
    }

    static void testInsertMultipleAfterResize() {
        OrderedArray oa = new OrderedArray(2);
        oa.insert(1);
        oa.insert(2);
        oa.insert(3);
        oa.insert(4);
        oa.insert(5);
        assert oa.size() == 8 : "size should be 8 after two resizes";
        assert oa.count() == 5 : "count should be 5";
        assert oa.find(1) == 0 : "1 at index 0";
        assert oa.find(5) == 4 : "5 at index 4";
    }

    static void testInsertMaintainsOrder() {
        OrderedArray oa = new OrderedArray(10);
        oa.insert(5);
        oa.insert(1);
        oa.insert(3);
        oa.insert(2);
        oa.insert(4);
        assert oa.find(1) == 0 : "1 at 0";
        assert oa.find(2) == 1 : "2 at 1";
        assert oa.find(3) == 2 : "3 at 2";
        assert oa.find(4) == 3 : "4 at 3";
        assert oa.find(5) == 4 : "5 at 4";
    }

    static void testInsertMaintainsOrderNegative() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(-1);
        oa.insert(-5);
        oa.insert(0);
        oa.insert(-3);
        assert oa.find(-5) == 0 : "-5 at 0";
        assert oa.find(-3) == 1 : "-3 at 1";
        assert oa.find(-1) == 2 : "-1 at 2";
        assert oa.find(0) == 3 : "0 at 3";
    }

    static void testInsertMaintainsOrderZero() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(0);
        oa.insert(0);
        assert oa.find(0) != -1 : "0 found";
        assert oa.count() == 2 : "two zeros inserted";
    }

    static void testInsertDuplicates() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(5);
        oa.insert(5);
        oa.insert(5);
        assert oa.count() == 3 : "count should be 3 with duplicates";
        assert oa.find(5) != -1 : "5 found";
    }

    static void testInsertDuplicatesPreserveAll() {
        OrderedArray oa = new OrderedArray(10);
        oa.insert(3);
        oa.insert(1);
        oa.insert(3);
        oa.insert(2);
        oa.insert(3);
        assert oa.count() == 5 : "count should be 5";
        assert oa.find(1) == 0 : "1 at index 0";
        assert oa.find(2) == 1 : "2 at index 1";
        assert oa.find(3) == 2 : "first 3 at index 2";
    }

    static void testInsertAllSameElements() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(7);
        oa.insert(7);
        oa.insert(7);
        assert oa.count() == 3 : "count should be 3";
        assert oa.find(7) == 0 : "first 7 at index 0";
    }

    static void testFind() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(20);
        oa.insert(30);
        assert oa.find(10) == 0 : "10 at 0";
        assert oa.find(20) == 1 : "20 at 1";
        assert oa.find(30) == 2 : "30 at 2";
    }

    static void testFindFirstOccurrenceDuplicates() {
        OrderedArray oa = new OrderedArray(10);
        oa.insert(5);
        oa.insert(3);
        oa.insert(5);
        oa.insert(5);
        assert oa.count() == 4 : "all duplicates stored";
        assert oa.find(5) == 1 : "first 5 at index 1";
        assert oa.find(3) == 0 : "3 at index 0";
    }

    static void testFindSmallerThanAll() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(20);
        oa.insert(30);
        assert oa.find(5) == -1 : "5 smaller than all not found";
    }

    static void testFindLargerThanAll() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(20);
        oa.insert(30);
        assert oa.find(50) == -1 : "50 larger than all not found";
    }

    static void testFindBetweenElements() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(30);
        assert oa.find(20) == -1 : "20 between 10 and 30 not found";
    }

    static void testFindNotFound() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(10);
        oa.insert(30);
        assert oa.find(20) == -1 : "20 between elements not found";
        assert oa.find(5) == -1 : "5 below min not found";
        assert oa.find(50) == -1 : "50 above max not found";
    }

    static void testFindOnEmptyArray() {
        OrderedArray oa = new OrderedArray(3);
        assert oa.find(1) == -1 : "find on empty returns -1";
    }

    static void testFindSingleElement() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(42);
        assert oa.find(42) == 0 : "single element at index 0";
        assert oa.find(41) == -1 : "41 not found";
        assert oa.find(43) == -1 : "43 not found";
    }

    static void testDeleteFirstElement() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(20);
        oa.insert(30);
        assert oa.delete(10) : "delete returns true";
        assert oa.count() == 2 : "count should be 2";
        assert oa.find(20) == 0 : "20 shifts to index 0";
        assert oa.find(30) == 1 : "30 shifts to index 1";
    }

    static void testDeleteLastElement() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(20);
        oa.insert(30);
        assert oa.delete(30) : "delete returns true";
        assert oa.count() == 2 : "count should be 2";
        assert oa.find(30) == -1 : "30 gone";
        assert oa.find(10) == 0 : "10 at index 0";
        assert oa.find(20) == 1 : "20 at index 1";
    }

    static void testDeleteMiddleElement() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(20);
        oa.insert(30);
        oa.insert(40);
        assert oa.delete(20) : "delete 20 (middle)";
        assert oa.count() == 3 : "count should be 3";
        assert oa.find(20) == -1 : "20 gone";
        assert oa.find(10) == 0 : "10 at index 0";
        assert oa.find(30) == 1 : "30 at index 1";
        assert oa.find(40) == 2 : "40 at index 2";
    }

    static void testDeleteOnlyElement() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(42);
        assert oa.delete(42) : "delete returns true";
        assert oa.count() == 0 : "count should be 0";
        assert oa.find(42) == -1 : "42 not found";
    }

    static void testDeleteNotFound() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(1);
        assert !oa.delete(99) : "delete returns false";
        assert oa.count() == 1 : "count unchanged";
    }

    static void testDeleteFromEmptyArray() {
        OrderedArray oa = new OrderedArray(3);
        assert !oa.delete(1) : "delete on empty returns false";
        assert oa.count() == 0 : "count should be 0";
        assert oa.size() == 3 : "size should not change";
    }

    static void testDeleteMultipleInSequence() {
        OrderedArray oa = new OrderedArray(10);
        for (int i = 1; i <= 5; i++) oa.insert(i * 10);
        assert oa.delete(30) : "delete 30";
        assert oa.delete(10) : "delete 10";
        assert oa.delete(50) : "delete 50";
        assert oa.count() == 2 : "count should be 2";
        assert oa.find(20) != -1 : "20 found";
        assert oa.find(40) != -1 : "40 found";
        assert oa.find(10) == -1 : "10 gone";
        assert oa.find(30) == -1 : "30 gone";
        assert oa.find(50) == -1 : "50 gone";
    }

    static void testDeleteMaintainsSortedOrder() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.insert(3);
        oa.insert(4);
        oa.delete(2);
        assert oa.find(1) == 0 : "1 at 0";
        assert oa.find(3) == 1 : "3 at 1 (sorted)";
        assert oa.find(4) == 2 : "4 at 2 (sorted)";
    }

    static void testSize() {
        OrderedArray oa = new OrderedArray(10);
        assert oa.size() == 10 : "size should be 10";
        oa.resize(20);
        assert oa.size() == 20 : "size should be 20 after resize";
    }

    static void testSizeDoesNotChangeAfterDelete() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.delete(1);
        assert oa.size() == 5 : "size should still be 5 after delete";
    }

    static void testCount() {
        OrderedArray oa = new OrderedArray(5);
        assert oa.count() == 0 : "count should be 0 initially";
        oa.insert(1);
        oa.insert(2);
        assert oa.count() == 2 : "count should be 2";
        oa.delete(1);
        assert oa.count() == 1 : "count should be 1 after delete";
    }

    static void testCountAfterMultipleDeletes() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.insert(3);
        oa.delete(1);
        oa.delete(2);
        oa.delete(3);
        assert oa.count() == 0 : "count should be 0 after deleting all";
    }

    static void testResizeExpand() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(100);
        oa.insert(200);
        oa.resize(5);
        assert oa.size() == 5 : "size should be 5";
        assert oa.count() == 2 : "count should be 2";
        assert oa.find(100) != -1 : "100 found";
        assert oa.find(200) != -1 : "200 found";
        assert oa.get(0) == 100 : "get(0)=100";
        assert oa.get(1) == 200 : "get(1)=200";
    }

    static void testResizeShrink() {
        OrderedArray oa = new OrderedArray(10);
        oa.insert(1);
        oa.insert(2);
        oa.insert(3);
        oa.resize(2);
        assert oa.size() == 2 : "size should be 2";
        assert oa.count() == 2 : "count clamped to 2";
        assert oa.find(1) != -1 : "1 found";
        assert oa.find(2) != -1 : "2 found";
        assert oa.find(3) == -1 : "3 discarded";
    }

    static void testResizeToZero() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.resize(0);
        assert oa.size() == 0 : "size should be 0";
        assert oa.count() == 0 : "count clamped to 0";
    }

    static void testResizePreserveOrder() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.insert(3);
        oa.resize(4);
        assert oa.find(1) == 0 : "1 at 0";
        assert oa.find(2) == 1 : "2 at 1";
        assert oa.find(3) == 2 : "3 at 2";
    }

    static void testResizeLargerThenSmaller() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(10);
        oa.insert(20);
        oa.resize(10);
        assert oa.size() == 10 : "size should be 10";
        oa.resize(1);
        assert oa.size() == 1 : "size should be 1";
        assert oa.count() == 1 : "count clamped to 1";
        assert oa.find(10) != -1 : "10 preserved";
        assert oa.find(20) == -1 : "20 discarded";
    }

    static void testResizeInsertAfterShrink() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(1);
        oa.insert(2);
        oa.resize(2);
        assert oa.size() == 2 : "size is 2";
        assert oa.count() == 2 : "count is 2";
        assert oa.find(1) == 0 : "1 at index 0";
        assert oa.find(2) == 1 : "2 at index 1";
    }

    static void testResizeGetNullPositionsAfterShrink() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.insert(3);
        oa.resize(2);
        assert oa.get(0) == 1 : "get(0)=1";
        assert oa.get(1) == 2 : "get(1)=2";
        oa.resize(3);
        assert oa.get(2) == null : "get(2) returns null (unoccupied after resize back)";
    }

    static void testInsertIntoCapacityZeroThenInsert() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.resize(0);
        boolean crashed = false;
        try { oa.insert(2); } catch (ArrayIndexOutOfBoundsException e) { crashed = true; }
        assert crashed : "insert after resize to 0 should throw ArrayIndexOutOfBoundsException";
    }

    static void testGet() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(42);
        try {
            assert oa.get(0) == 42 : "get(0) returns 42";
        } catch (IndexOutOfBoundsException e) {
            assert false : "get(0) should not throw";
        }
    }

    static void testGetNullPosition() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        assert oa.get(0) == 10 : "get(0) returns 10";
        assert oa.get(1) == null : "get(1) returns null (unoccupied)";
        assert oa.get(4) == null : "get(4) returns null";
    }

    static void testGetNullAfterShrink() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(2);
        oa.resize(2);
        assert oa.get(0) == 1 : "get(0)=1";
        assert oa.get(1) == 2 : "get(1)=2";
        oa.resize(3);
        assert oa.get(2) == null : "get(2) returns null (unoccupied after resize back)";
    }

    static void testGetIndexZeroOnEmptyCapacity() {
        OrderedArray oa = new OrderedArray(0);
        boolean caught = false;
        try { oa.get(0); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(0) on capacity-0 array should throw IndexOutOfBoundsException";
    }

    static void testGetIndexOutOfBoundsNegative() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(1);
        boolean caught = false;
        try { oa.get(-1); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(-1) throws IndexOutOfBoundsException";
    }

    static void testGetIndexOutOfBoundsLarge() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(1);
        boolean caught = false;
        try { oa.get(5); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(5) throws IndexOutOfBoundsException";
    }

    static void testGetIndexAtCapacity() {
        OrderedArray oa = new OrderedArray(3);
        oa.insert(1);
        boolean caught = false;
        try { oa.get(3); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(capacity=3) throws IndexOutOfBoundsException";
    }

    static void testDeleteThenInsert() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(10);
        oa.insert(30);
        oa.delete(10);
        oa.insert(20);
        assert oa.count() == 2 : "count should be 2";
        assert oa.find(20) != -1 : "20 found";
        assert oa.find(30) != -1 : "30 found";
        assert oa.find(10) == -1 : "10 gone";
    }

    static void testInsertAfterDeleteMaintainsOrder() {
        OrderedArray oa = new OrderedArray(5);
        oa.insert(1);
        oa.insert(3);
        oa.delete(1);
        oa.insert(2);
        assert oa.count() == 2 : "count should be 2";
        assert oa.find(2) == 0 : "2 at index 0";
        assert oa.find(3) == 1 : "3 at index 1";
        assert oa.find(1) == -1 : "1 gone";
    }

    static void testEmptyArray() {
        OrderedArray oa = new OrderedArray(3);
        assert oa.find(1) == -1 : "find on empty returns -1";
        assert !oa.delete(1) : "delete on empty returns false";
        assert oa.count() == 0 : "count is 0";
        assert oa.size() == 3 : "size unchanged";
    }

    static void testSortedProperty() {
        OrderedArray oa = new OrderedArray(10);
        oa.insert(5);
        oa.insert(1);
        oa.insert(3);
        oa.insert(2);
        oa.insert(4);
        assert oa.find(1) == 0 : "1 at 0";
        assert oa.find(2) == 1 : "2 at 1";
        assert oa.find(3) == 2 : "3 at 2";
        assert oa.find(4) == 3 : "4 at 3";
        assert oa.find(5) == 4 : "5 at 4";
    }

    static void testLargeArrayOperations() {
        OrderedArray oa = new OrderedArray(4);
        for (int i = 20; i >= 1; i--) oa.insert(i);
        assert oa.count() == 20 : "count should be 20 after many inserts";
        assert oa.find(1) == 0 : "1 at index 0";
        assert oa.find(20) == 19 : "20 at index 19";
        assert oa.find(10) == 9 : "10 at index 9";
        for (int i = 2; i <= 20; i += 2) {
            assert oa.delete(i) : "delete " + i;
        }
        assert oa.count() == 10 : "count should be 10 after deleting even numbers";
        for (int i = 1; i <= 20; i += 2) {
            assert oa.find(i) != -1 : i + " should still be found";
        }
    }
}
