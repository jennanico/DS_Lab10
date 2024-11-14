import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTreeTest {
	
	BSTree tree0;
	BSTree tree;
	BSTree tree2;
	BSTree tree3;
	BSTree tree4;
	BSTree tree4A;
	BSTree tree5;
	BSTree tree6;
	BSTree tree6A;
	BSTree tree7;
	BSTree tree7A;
	
	@BeforeEach
	void setUp() throws Exception {
		tree0 = new BSTree();
		tree = new BSTree();
		tree2 = new BSTree();
		tree3 = new BSTree();
		tree4 = new BSTree();
		tree4A = new BSTree();
		tree5 = new BSTree();
		tree6 = new BSTree();
		tree6A = new BSTree();
		tree7 = new BSTree();
		tree7A = new BSTree();
	}

	@Test
	void myEqualsTest() {		
		assertEquals(true, tree.myEquals(tree0)); // compare two empty

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
		
		// same values, different structure
		tree3.insert(20);
		tree3.insert(5);
		tree3.insert(15);
		tree3.insert(10);
		tree3.insert(25);
		tree3.insert(11);
		
		// one additional value to right
		tree4.insert(15);
		tree4.insert(10);
		tree4.insert(5);
		tree4.insert(25);
		tree4.insert(11);
		tree4.insert(20);
		tree4.insert(30);
		
		// one additional value to left
		tree4A.insert(15);
		tree4A.insert(10);
		tree4A.insert(5);
		tree4A.insert(25);
		tree4A.insert(11);
		tree4A.insert(20);
		tree4A.insert(1);
	
		// same structure, different values
		tree5.insert(16);
		tree5.insert(11);
		tree5.insert(6);
		tree5.insert(26);
		tree5.insert(12);
		tree5.insert(21);
		
		// one less value from the right
		tree6.insert(15);
		tree6.insert(10);
		tree6.insert(5);
		tree6.insert(11);
		tree6.insert(20);

		// one less value from the left
		tree6A.insert(15);
		tree6A.insert(10);
		tree6A.insert(25);
		tree6A.insert(11);
		tree6A.insert(20);
		
		// one value is off on right
		tree7.insert(15);
		tree7.insert(10);
		tree7.insert(5);
		tree7.insert(24);
		tree7.insert(11);
		tree7.insert(20);
		
		// one value is off on left
		tree7A.insert(15);
		tree7A.insert(9);
		tree7A.insert(5);
		tree7A.insert(25);
		tree7A.insert(11);
		tree7A.insert(20);
		
		assertEquals(false, tree.myEquals(tree0)); // compare full against empty
		assertEquals(false, tree0.myEquals(tree)); // compare empty against full
		
		assertEquals(true, tree.myEquals(tree));
		
		assertEquals(true, tree.myEquals(tree2));
		assertEquals(true, tree2.myEquals(tree));
				
		assertEquals(false, tree.myEquals(tree3));
		assertEquals(false, tree3.myEquals(tree));

		assertEquals(false, tree.myEquals(tree4));
		assertEquals(false, tree4.myEquals(tree));

		assertEquals(false, tree.myEquals(tree4A));
		assertEquals(false, tree4A.myEquals(tree));
		
		assertEquals(false, tree.myEquals(tree5));
		assertEquals(false, tree5.myEquals(tree));
		
		assertEquals(false, tree.myEquals(tree6));
		assertEquals(false, tree6.myEquals(tree));
		
		assertEquals(false, tree.myEquals(tree6A));
		assertEquals(false, tree6A.myEquals(tree));

		assertEquals(false, tree.myEquals(tree7));
		assertEquals(false, tree7.myEquals(tree));

		assertEquals(false, tree.myEquals(tree7A));
		assertEquals(false, tree7A.myEquals(tree));
	}
	
	
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
