import java.lang.Comparable;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;



   public BSTNode(T val)
   {
      this(val,null,null);
   }
    

   public BSTNode(T val, BSTNode<T> l,BSTNode<T> r)
   {
	   this.val = val;
	   this.left = l;
	   this.right = r;
   }



   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
	   if (target.compareTo(val) < 0  && left == null)
	   {
		   left = new BSTNode<T>(target);
	   }
	   else if (target.compareTo(val) > 0 && right == null)
	   {
		   right = new BSTNode<T>(target);
	   }
	   
	   if (target.compareTo(val) < 0) { left.insert(target); }
	   else if (target.compareTo(val) > 0) { right.insert(target); }
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
	   if (target.equals(val)) { return target; }
	   
	   if (target.compareTo(val) < 0 && left == null) { return null; }
	   if (target.compareTo(val) > 0 && right == null) { return null; }
	   
	   if (target.compareTo(val) < 0) { return left.retrieve(target); }
	   else { return right.retrieve(target); } 
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target)
   {
	   int sum = 0;
	   if (target.equals(val)) { return sum; }
	   
	   if (target.compareTo(val) < 0 && left == null) { return sum + 1; }
	   if (target.compareTo(val) > 0 && right == null) { return sum + 1; }
	   
	   if (target.compareTo(val) < 0) { sum = left.retrieveDepth(target); }
	   else if (target.compareTo(val) > 0) { sum = right.retrieveDepth(target); }
	   
	   return sum + 1;
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
	   if (right == null) { return val; }
	   return right.getLargest();
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {
	   if (left == null && right != null) 
	   { 
		   consume.accept(val);
		   return; 
	   }
	   if (left == null) { return; }
	   
	   left.inOrderTraversal(consume);
	   
	   consume.accept(val);
	   
	   if (right == null && left != null) 
	   { 
		   consume.accept(val);
		   return; 
	   }
	   if (right == null) { return; }
	   
	   right.inOrderTraversal(consume);
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
	return false;
   

   }

}
