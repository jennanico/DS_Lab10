import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTreeTest {
	
	BSTree tree0;
	BSTree tree;
	BSTree tree2;
	
	@BeforeEach
	void setUp() throws Exception {
		tree0 = new BSTree();
		tree = new BSTree();
		tree2 = new BSTree();
	}

	@Test
	void myEqualsEmptyTest() {		
		assertEquals(true, tree.myEquals(tree0)); // compare two empty

		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		assertEquals(false, tree.myEquals(tree0)); // compare full against empty
		assertEquals(false, tree0.myEquals(tree)); // compare empty against full
	}
	
	@Test
	void myEqualsSameTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// same tree
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(25);
		tree2.insert(11);
		tree2.insert(20);
		
		assertEquals(true, tree.myEquals(tree));
		
		assertEquals(true, tree.myEquals(tree2));
		assertEquals(true, tree2.myEquals(tree));
	}
	
	@Test 
	void myEqualsDifferentStructureTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// same values, different structure
		tree2.insert(20);
		tree2.insert(5);
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(25);
		tree2.insert(11);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	@Test
	void myEqualsAdditionalValRightTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// one additional value to right
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(25);
		tree2.insert(11);
		tree2.insert(20);
		tree2.insert(30);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	@Test
	void myEqualsAdditionalValLeftTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// one additional value to left
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(25);
		tree2.insert(11);
		tree2.insert(20);
		tree2.insert(1);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	@Test
	void myEqualsDifferentValsTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);

		// same structure, different values
		tree2.insert(16);
		tree2.insert(11);
		tree2.insert(6);
		tree2.insert(26);
		tree2.insert(12);
		tree2.insert(21);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	@Test
	void myEqualsLessValRightTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);

		// one less value from the right
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(25);
		tree2.insert(20);

		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}

	@Test
	void myEqualsLessValLeftTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// one less value from the left
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(25);
		tree2.insert(11);
		tree2.insert(20);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	@Test
	void myEqualsOneValWrongRightTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// one value is off on right
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(5);
		tree2.insert(24);
		tree2.insert(11);
		tree2.insert(20);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	@Test
	void myEqualsOneValWrongLeftTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// one value is off on left
		tree2.insert(15);
		tree2.insert(9);
		tree2.insert(5);
		tree2.insert(25);
		tree2.insert(11);
		tree2.insert(20);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	@Test
	void myEqualsLessValNoMatchTest() { // one less value
		tree.insert(15);
		tree.insert(10);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		// remaining node from subtracted pair is wrong
		tree2.insert(15);
		tree2.insert(10);
		tree2.insert(25);
		tree2.insert(12);
		tree2.insert(20);
		
		assertEquals(false, tree.myEquals(tree2));
		assertEquals(false, tree2.myEquals(tree));
	}
	
	
	
	
	// end of myEquals tests 
	
	
	
	@Test
	void getSizeTest() {
		assertEquals(0, tree.getSize());
		
		tree.insert(15);
		tree.insert(10);
		
		assertEquals(2, tree.getSize());
		
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		assertEquals(6, tree.getSize());
	}
	
	@Test
	void sumTest() {
		assertEquals(0, tree.sum());
		
		tree.insert(15);
		
		assertEquals(15, tree.sum());
		
		tree.insert(10);
		tree.insert(5);
		
		assertEquals(30, tree.sum());
		
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		tree.insert(50);
		tree.insert(35);
		tree.insert(45);
		
		assertEquals(216, tree.sum());
	}
	
	@Test
	void retrieveDepthTest() {
		assertEquals(0, tree.retrieveDepth(5));
		
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		assertEquals(0, tree.retrieveDepth(15));
		assertEquals(1, tree.retrieveDepth(10));
		assertEquals(2, tree.retrieveDepth(5));
		assertEquals(2, tree.retrieveDepth(20));
		
		assertEquals(2, tree.retrieveDepth(35));
		assertEquals(3, tree.retrieveDepth(1));
	}
	
	@Test
	void retrieveTest() {
		assertEquals(null, tree.retrieve(5));
		
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		assertEquals(10, tree.retrieve(10));
		assertEquals(5, tree.retrieve(5));
		assertEquals(20, tree.retrieve(20));
		assertEquals(null, tree.retrieve(35));
	}
	
	@Test
	void largestTest() {
		assertEquals(null, tree.largest());
		
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		
		assertEquals(15, tree.largest());
		
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
		
		assertEquals(25, tree.largest());
		
		tree2.insert(35);
		tree2.insert(50);
		tree2.insert(5);
		tree2.insert(65);
		tree2.insert(45);
		tree2.insert(200);
		tree2.insert(1);
		tree2.insert(205);
		
		assertEquals(205, tree2.largest());
	}
	
	@Test
	void toListTest() {
		tree.insert(15);
		tree.insert(10);
		tree.insert(5);
		tree.insert(25);
		tree.insert(11);
		tree.insert(20);
				
	    List<Integer> L= new ArrayList<Integer>();
	    L.add(5);
	    L.add(10);
	    L.add(11);
	    L.add(15);
	    L.add(20);
	    L.add(25);
	    
	    assertEquals(L, tree.toList());
	}
	
	@Test
	void isEmptyTest() {
		assertEquals(true, tree.isEmpty());
		
		tree.insert(1);
		assertEquals(false, tree.isEmpty());
	}
	

}
