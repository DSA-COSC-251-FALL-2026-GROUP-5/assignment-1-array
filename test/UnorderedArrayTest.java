public class UnorderedArrayTest {
    public static void main(String[] args) {
        testConstructor();
        testConstructorSizeZero();
        testInsert();
        testInsertAtEnd();
        testInsertAutoResize();
        testInsertMultipleAfterResize();
        testFullArrayInsertTriggersResize();
        testInsertNegativeNumbers();
        testInsertAfterResize();
        testFind();
        testFindFirstOccurrenceDuplicates();
        testFindNotFound();
        testFindOnEmptyArray();
        testDeleteFirstElement();
        testDeleteLastElement();
        testDeleteMiddleElement();
        testDeleteOnlyElement();
        testDeleteNotFound();
        testDeleteFromEmptyArray();
        testDeleteMultipleInSequence();
        testDeleteMaintainsContiguity();
        testGet();
        testGetNullPosition();
        testGetNullAfterShrink();
        testGetIndexZeroOnEmptyCapacity();
        testGetIndexOutOfBoundsNegative();
        testGetIndexOutOfBoundsLarge();
        testGetIndexAtCapacity();
        testSize();
        testSizeDoesNotChangeAfterDelete();
        testCount();
        testCountAfterMultipleDeletes();
        testResizeExpand();
        testResizeShrink();
        testResizeToZero();
        testResizeToZeroThenInsert();
        testResizePreserveOrder();
        testResizeLargerThenSmaller();
        testResizeGetNullPositionsAfterShrink();
        testDeleteThenInsert();
        testInsertAfterDeleteFillsGap();
        testEmptyArray();
        testUnsortedProperty();
        System.out.println("All UnorderedArrayTest tests passed!");
    }

    static void testConstructor() {
        UnorderedArray ua = new UnorderedArray(5);
        assert ua.size() == 5 : "size should be 5";
        assert ua.count() == 0 : "count should be 0";
    }

    static void testConstructorSizeZero() {
        UnorderedArray ua = new UnorderedArray(0);
        assert ua.size() == 0 : "size should be 0";
        assert ua.count() == 0 : "count should be 0";
    }

    static void testInsert() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(10);
        assert ua.count() == 1 : "count should be 1";
        assert ua.find(10) == 0 : "10 at index 0";
        ua.insert(20);
        ua.insert(30);
        assert ua.count() == 3 : "count should be 3";
        assert ua.find(20) == 1 : "20 at index 1";
        assert ua.find(30) == 2 : "30 at index 2";
    }

    static void testInsertAtEnd() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(100);
        assert ua.get(0) == 100 : "100 at index 0";
        ua.insert(200);
        assert ua.get(1) == 200 : "200 at index 1 (inserted at end)";
        ua.insert(300);
        assert ua.get(2) == 300 : "300 at index 2";
    }

    static void testInsertAutoResize() {
        UnorderedArray ua = new UnorderedArray(2);
        ua.insert(1);
        ua.insert(2);
        assert ua.size() == 2 : "size still 2 before overflow";
        ua.insert(3);
        assert ua.size() == 4 : "size doubled to 4";
        assert ua.count() == 3 : "count should be 3";
        assert ua.find(1) != -1 : "1 found";
        assert ua.find(2) != -1 : "2 found";
        assert ua.find(3) != -1 : "3 found";
    }

    static void testInsertMultipleAfterResize() {
        UnorderedArray ua = new UnorderedArray(2);
        ua.insert(1);
        ua.insert(2);
        ua.insert(3);
        ua.insert(4);
        ua.insert(5);
        assert ua.size() == 8 : "size should be 8 after two resizes";
        assert ua.count() == 5 : "count should be 5";
        assert ua.find(5) != -1 : "5 found";
        assert ua.get(4) == 5 : "5 at index 4";
    }

    static void testInsertAfterResize() {
        UnorderedArray ua = new UnorderedArray(2);
        ua.insert(1);
        ua.insert(2);
        ua.insert(3);
        assert ua.size() == 4 : "size is 4 after resize";
        ua.insert(4);
        assert ua.count() == 4 : "count should be 4";
        ua.insert(5);
        assert ua.count() == 5 : "count should be 5 after auto-resize";
        assert ua.size() == 8 : "size should be 8";
    }

    static void testFullArrayInsertTriggersResize() {
        UnorderedArray ua = new UnorderedArray(2);
        ua.insert(10);
        ua.insert(20);
        assert ua.count() == 2 : "array is full";
        ua.insert(30);
        assert ua.count() == 3 : "count should be 3 after auto-resize";
        assert ua.find(10) != -1 : "10 found";
        assert ua.find(20) != -1 : "20 found";
    }

    static void testInsertNegativeNumbers() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(-5);
        ua.insert(-1);
        ua.insert(0);
        assert ua.count() == 3 : "count should be 3";
        assert ua.find(-5) != -1 : "-5 found";
        assert ua.find(-1) != -1 : "-1 found";
        assert ua.find(0) != -1 : "0 found";
        assert ua.find(1) == -1 : "1 not found";
    }

    static void testFind() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(5);
        ua.insert(3);
        ua.insert(8);
        assert ua.find(5) == 0 : "5 at index 0";
        assert ua.find(3) == 1 : "3 at index 1";
        assert ua.find(8) == 2 : "8 at index 2";
    }

    static void testFindFirstOccurrenceDuplicates() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(7);
        ua.insert(3);
        ua.insert(7);
        ua.insert(7);
        int index = ua.find(7);
        assert index == 0 : "find returns first occurrence at index 0";
        assert ua.count() == 4 : "all duplicates stored";
        assert ua.find(3) == 1 : "3 at index 1";
    }

    static void testFindNotFound() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(1);
        assert ua.find(99) == -1 : "99 not found";
    }

    static void testFindOnEmptyArray() {
        UnorderedArray ua = new UnorderedArray(3);
        assert ua.find(1) == -1 : "find on empty returns -1";
    }

    static void testDeleteFirstElement() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(10);
        ua.insert(20);
        ua.insert(30);
        assert ua.delete(10) : "delete returns true";
        assert ua.count() == 2 : "count should be 2";
        assert ua.find(20) == 0 : "20 shifts to index 0";
        assert ua.find(30) == 1 : "30 shifts to index 1";
    }

    static void testDeleteLastElement() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(10);
        ua.insert(20);
        ua.insert(30);
        assert ua.delete(30) : "delete returns true";
        assert ua.count() == 2 : "count should be 2";
        assert ua.find(30) == -1 : "30 gone";
        assert ua.find(10) == 0 : "10 at index 0";
        assert ua.find(20) == 1 : "20 at index 1";
    }

    static void testDeleteMiddleElement() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(10);
        ua.insert(20);
        ua.insert(30);
        ua.insert(40);
        assert ua.delete(20) : "delete 20 (middle)";
        assert ua.count() == 3 : "count should be 3";
        assert ua.find(20) == -1 : "20 gone";
        assert ua.find(10) == 0 : "10 at index 0";
        assert ua.find(30) == 1 : "30 at index 1";
        assert ua.find(40) == 2 : "40 at index 2";
    }

    static void testDeleteOnlyElement() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(42);
        assert ua.delete(42) : "delete returns true";
        assert ua.count() == 0 : "count should be 0";
        assert ua.find(42) == -1 : "42 not found";
    }

    static void testDeleteNotFound() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(1);
        assert !ua.delete(99) : "delete returns false for non-existent";
        assert ua.count() == 1 : "count unchanged";
    }

    static void testDeleteFromEmptyArray() {
        UnorderedArray ua = new UnorderedArray(3);
        assert !ua.delete(1) : "delete on empty returns false";
        assert ua.count() == 0 : "count should remain 0";
        assert ua.size() == 3 : "size should not change";
    }

    static void testDeleteMultipleInSequence() {
        UnorderedArray ua = new UnorderedArray(10);
        for (int i = 1; i <= 5; i++) ua.insert(i * 10);
        assert ua.delete(30) : "delete 30";
        assert ua.delete(10) : "delete 10";
        assert ua.delete(50) : "delete 50";
        assert ua.count() == 2 : "count should be 2";
        assert ua.find(20) != -1 : "20 found";
        assert ua.find(40) != -1 : "40 found";
        assert ua.find(10) == -1 : "10 gone";
        assert ua.find(30) == -1 : "30 gone";
        assert ua.find(50) == -1 : "50 gone";
    }

    static void testDeleteMaintainsContiguity() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(10);
        ua.insert(20);
        ua.insert(30);
        ua.insert(40);
        ua.delete(20);
        assert ua.get(0) == 10 : "10 at 0";
        assert ua.get(1) == 30 : "30 at 1 (contiguous)";
        assert ua.get(2) == 40 : "40 at 2 (contiguous)";
        assert ua.get(3) == null : "3 is null";
        ua.delete(40);
        assert ua.get(0) == 10 : "10 at 0";
        assert ua.get(1) == 30 : "30 at 1 (contiguous)";
        assert ua.get(2) == null : "2 is null";
    }

    static void testGet() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(42);
        try {
            assert ua.get(0) == 42 : "get(0) returns 42";
        } catch (IndexOutOfBoundsException e) {
            assert false : "get(0) should not throw";
        }
    }

    static void testGetNullPosition() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(10);
        assert ua.get(0) == 10 : "get(0) returns 10";
        assert ua.get(1) == null : "get(1) returns null (unoccupied)";
        assert ua.get(4) == null : "get(4) returns null";
    }

static void testGetNullAfterShrink() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(1);
        ua.insert(2);
        ua.resize(2);
        assert ua.get(0) == 1 : "get(0)=1";
        assert ua.get(1) == 2 : "get(1)=2";
        ua.resize(3);
        assert ua.get(2) == null : "get(2) returns null (unoccupied after resize back)";
    }

    static void testGetIndexZeroOnEmptyCapacity() {
        UnorderedArray ua = new UnorderedArray(0);
        boolean caught = false;
        try { ua.get(0); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(0) on capacity-0 array should throw IndexOutOfBoundsException";
    }

    static void testGetIndexOutOfBoundsNegative() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(1);
        boolean caught = false;
        try { ua.get(-1); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(-1) throws IndexOutOfBoundsException";
    }

    static void testGetIndexOutOfBoundsLarge() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(1);
        boolean caught = false;
        try { ua.get(5); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(5) throws IndexOutOfBoundsException";
    }

    static void testGetIndexAtCapacity() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(1);
        boolean caught = false;
        try { ua.get(3); } catch (IndexOutOfBoundsException e) { caught = true; }
        assert caught : "get(capacity=3) throws IndexOutOfBoundsException";
    }

    static void testSize() {
        UnorderedArray ua = new UnorderedArray(10);
        assert ua.size() == 10 : "size should be 10";
        ua.resize(20);
        assert ua.size() == 20 : "size should be 20 after resize";
    }

    static void testSizeDoesNotChangeAfterDelete() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(1);
        ua.insert(2);
        ua.delete(1);
        assert ua.size() == 5 : "size should still be 5 after delete";
    }

    static void testCount() {
        UnorderedArray ua = new UnorderedArray(5);
        assert ua.count() == 0 : "count should be 0 initially";
        ua.insert(1);
        ua.insert(2);
        assert ua.count() == 2 : "count should be 2";
        ua.delete(1);
        assert ua.count() == 1 : "count should be 1 after delete";
    }

    static void testCountAfterMultipleDeletes() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(1);
        ua.insert(2);
        ua.insert(3);
        ua.delete(1);
        ua.delete(2);
        ua.delete(3);
        assert ua.count() == 0 : "count should be 0 after deleting all";
    }

    static void testResizeExpand() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(100);
        ua.insert(200);
        ua.resize(5);
        assert ua.size() == 5 : "size should be 5";
        assert ua.count() == 2 : "count should be 2";
        assert ua.find(100) != -1 : "100 found";
        assert ua.find(200) != -1 : "200 found";
        assert ua.get(0) == 100 : "get(0)=100";
        assert ua.get(1) == 200 : "get(1)=200";
    }

    static void testResizeShrink() {
        UnorderedArray ua = new UnorderedArray(10);
        ua.insert(1);
        ua.insert(2);
        ua.insert(3);
        ua.resize(2);
        assert ua.size() == 2 : "size should be 2";
        assert ua.count() == 2 : "count clamped to 2";
        assert ua.find(1) != -1 : "1 found";
        assert ua.find(2) != -1 : "2 found";
        assert ua.find(3) == -1 : "3 discarded";
    }

    static void testResizeToZero() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(1);
        ua.insert(2);
        ua.resize(0);
        assert ua.size() == 0 : "size should be 0";
        assert ua.count() == 0 : "count clamped to 0";
    }

    static void testResizeToZeroThenInsert() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(1);
        ua.resize(0);
        boolean crashed = false;
        try { ua.insert(2); } catch (ArrayIndexOutOfBoundsException e) { crashed = true; }
        assert crashed : "insert after resize to 0 should throw ArrayIndexOutOfBoundsException";
    }

    static void testResizePreserveOrder() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(1);
        ua.insert(2);
        ua.insert(3);
        ua.resize(4);
        assert ua.get(0) == 1 : "order preserved";
        assert ua.get(1) == 2 : "order preserved";
        assert ua.get(2) == 3 : "order preserved";
    }

    static void testResizeLargerThenSmaller() {
        UnorderedArray ua = new UnorderedArray(3);
        ua.insert(10);
        ua.insert(20);
        ua.resize(10);
        assert ua.size() == 10 : "size should be 10";
        ua.resize(1);
        assert ua.size() == 1 : "size should be 1";
        assert ua.count() == 1 : "count clamped to 1";
        assert ua.find(10) != -1 : "10 preserved";
        assert ua.find(20) == -1 : "20 discarded";
    }

    static void testResizeGetNullPositionsAfterShrink() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(1);
        ua.insert(2);
        ua.insert(3);
        ua.resize(2);
        assert ua.get(0) == 1 : "get(0)=1";
        assert ua.get(1) == 2 : "get(1)=2";
        ua.resize(3);
        assert ua.get(2) == null : "get(2) returns null (unoccupied after resize back)";
    }

    static void testDeleteThenInsert() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(10);
        ua.insert(20);
        ua.delete(10);
        ua.insert(30);
        assert ua.count() == 2 : "count should be 2";
        assert ua.find(20) != -1 : "20 found";
        assert ua.find(30) != -1 : "30 found";
    }

    static void testInsertAfterDeleteFillsGap() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(10);
        ua.insert(20);
        ua.insert(30);
        ua.delete(20);
        assert ua.count() == 2 : "count should be 2";
        ua.insert(40);
        assert ua.count() == 3 : "count should be 3";
        assert ua.find(40) != -1 : "40 found";
        assert ua.find(20) == -1 : "20 still gone";
    }

    static void testEmptyArray() {
        UnorderedArray ua = new UnorderedArray(3);
        assert ua.find(1) == -1 : "find on empty returns -1";
        assert !ua.delete(1) : "delete on empty returns false";
        assert ua.count() == 0 : "count is 0";
        assert ua.get(0) == null : "get(0) on empty array returns null";
        assert ua.size() == 3 : "size unchanged";
    }

    static void testUnsortedProperty() {
        UnorderedArray ua = new UnorderedArray(5);
        ua.insert(5);
        ua.insert(1);
        ua.insert(3);
        assert ua.count() == 3 : "count should be 3";
        assert ua.get(0) == 5 : "element at 0 is 5";
        assert ua.get(1) == 1 : "element at 1 is 1 (not sorted)";
        assert ua.get(2) == 3 : "element at 2 is 3";
    }
}
