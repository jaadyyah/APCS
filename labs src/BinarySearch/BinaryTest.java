package BinarySearch;
import org.junit.Test;

import testHelp.verify;


public class BinaryTest 
{
	@Test
	public void searchShouldFindItemInOneItemList()
	{
		verify.that(BinarySearchTester.binarySearch(7, new int[] { 7 })).isEqualTo(0);
	}

	@Test
	public void searchShouldNotFindItemInOneItemList()
	{
		verify.that(BinarySearchTester.binarySearch(7, new int[] { 9 })).isEqualTo(-1);
	}

	@Test
	public void searchShouldFindFirstItemInTwoItemList()
	{
		verify.that(BinarySearchTester.binarySearch(7, new int[] { 7, 12 })).isEqualTo(0);
	}

	@Test
	public void searchShouldFindSecondItemInTwoItemList()
	{
		verify.that(BinarySearchTester.binarySearch(12, new int[] { 7, 12 })).isEqualTo(1);
	}

	@Test
	public void searchShouldNotFindFirstItemInTwoItemList()
	{
		verify.that(BinarySearchTester.binarySearch(5, new int[] { 7, 12 })).isEqualTo(-1);
	}

	@Test
	public void searchShouldNotFindMidItemInTwoItemList()
	{
		verify.that(BinarySearchTester.binarySearch(9, new int[] { 7, 12 })).isEqualTo(-1);
	}

	@Test
	public void searchShouldNotFindLastItemInTwoItemList()
	{
		verify.that(BinarySearchTester.binarySearch(23, new int[] { 7, 12 })).isEqualTo(-1);
	}

	@Test
	public void searchShouldNotFindFirstItemInThreeItemList()
	{
		verify.that(BinarySearchTester.binarySearch(5, new int[] { 7, 12, 19 })).isEqualTo(-1);
	}

	@Test
	public void searchShouldNotFindMidItemInThreeItemList()
	{
		verify.that(BinarySearchTester.binarySearch(9, new int[] { 7, 12, 19 })).isEqualTo(-1);
	}

	@Test
	public void searchShouldNotFindLastItemInThreeItemList()
	{
		verify.that(BinarySearchTester.binarySearch(23, new int[] { 7, 12, 19 })).isEqualTo(-1);
	}

	@Test
	public void searchShouldFindFirstItemInThreeItemList()
	{
		verify.that(BinarySearchTester.binarySearch(7, new int[] { 7, 12, 19 })).isEqualTo(0);
	}

	@Test
	public void searchShouldFindSecondItemInThreeItemList()
	{
		verify.that(BinarySearchTester.binarySearch(12, new int[] { 7, 12, 19 })).isEqualTo(1);
	}

	@Test
	public void searchShouldFindThirdItemInThreeItemList()
	{
		verify.that(BinarySearchTester.binarySearch(19, new int[] { 7, 12, 19 })).isEqualTo(2);
	}

	@Test
	public void searchShouldFindItemInLongerList()
	{
		verify.that(BinarySearchTester.binarySearch(19, new int[] { 7, 12, 19, 23, 25, 26, 30, 31, 37 })).isEqualTo(2);
	}

	@Test
	public void searchShouldNotFindItemInLongerList()
	{
		verify.that(BinarySearchTester.binarySearch(28, new int[] { 7, 12, 19, 23, 25, 26, 30, 31, 37 })).isEqualTo(-1);
	}
}