import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  Jubaer Ahmed Bhuiyan, Saad Equbal Syed and Fatiha Nowrin.
 * @version 08 November, 2021
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
     /**
     * Tests that the constructor initializes the variables correctly.
     */
    @Test
    public void testSalesItem(){
       SalesItem item1 = new SalesItem("Eternals",13);
       assertEquals("Eternals",item1.getName());
       assertEquals(13,item1.getPrice());
    }
    
     /**
     * Tests that the correct name is returned.
     */
    @Test
    public void testgetName(){
         SalesItem item1 = new SalesItem("Eternals",13);
         assertEquals("Eternals",item1.getName());
    }
    /**
     * Tests that the correct price is returned.
     */
    @Test
    public void testgetPrice(){
        SalesItem item1 = new SalesItem("Eternals",13);
        assertEquals(13,item1.getPrice());
    }
     /**
     * Tests that the correct number of comments is returned.
     */
    @Test
    public void testgetNumberOfComments(){
         SalesItem item1 = new SalesItem("Eternals",13);
         assertEquals(0,item1.getNumberOfComments());
         item1.addComment("James","This film is great",4);
         assertEquals(1,item1.getNumberOfComments());
    }
     /**
     * Tests that a comment has been added and size of the arraylist has been updated.
     */
    @Test
    public void testAddComment(){
        SalesItem item1 = new SalesItem("Eternals",13);
        assertEquals(true,item1.addComment("James","This film is great",4));
        assertEquals(1,item1.getNumberOfComments());
    }
    /**
     * Tests that a comment has been removed and size of the arraylist has been updated.
     */
    @Test
    public void testRemoveComment(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("James", "This film is great", 4);
        item1.removeComment(0);
        assertEquals(0, item1.getNumberOfComments());
    }
    
    /**
     * Tests that a comment has an upvote.
     */
    @Test
    public void testUpvoteComment(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("Henry", "Great cinematography and story", 5);
        item1.upvoteComment(0);
        Comment input1 = item1.getComment(0);
        assertEquals(1, input1.getVoteCount());
    }
    
    /**
     * Tests that a comment has a downvote.
     */
    @Test
    public void testDownvoteComment(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("Cole", "Film sux", 1);
        item1.downvoteComment(0);
        Comment input1 = item1.getComment(0);
        assertEquals(-1, input1.getVoteCount());
    }
    
    /**
     * Tests that the comment with the most upvotes have been returned.
     */
    @Test
    public void testFindMostHelpfulComment(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("James", "This film is great", 4);
        item1.addComment("Henry", "Great cinematography and story", 5);
        item1.addComment("Cole", "Did not like the film", 1);
        item1.upvoteComment(1);
        Comment helpful = item1.findMostHelpfulComment();
        assertEquals(1, helpful.getVoteCount());
    }
    
    /**
     * Tests if a comment has an invalid rating (must be 1 to 5).
     */
    @Test
    public void testRatingInvalid(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        assertEquals(false, item1.addComment("Cole", "I hated this film", -5));
    }
    
     /**
     * Tests whether the desired Author of the comment has been returned.
     */
    @Test
    public void testFindCommentByAuthor(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("James", "This film is great", 4);
        item1.addComment("Henry", "Great cinematography and story", 5);
        Comment searchAuthor = item1.findCommentByAuthor("Henry");
        assertEquals("Henry", searchAuthor.getAuthor());
    }
    
     /**
     * Tests whether the vote count of a comment is increasing or not.
     */
    @Test
    public void testUpvote(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("James", "This film is great", 4);
        item1.upvoteComment(0);
        item1.upvoteComment(0);
        Comment input1 = item1.getComment(0);
        assertEquals(2, input1.getVoteCount());
    }
    
     /**
     * Tests whether the vote count of a comment is decreasing or not.
     */
    @Test
    public void testDownvote(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("James", "This film is great", 4);
        item1.upvoteComment(0);
        item1.upvoteComment(0);
        item1.downvoteComment(0);
        Comment input1 = item1.getComment(0);
        assertEquals(1, input1.getVoteCount());
    }
    
     /**
     * Tests whether the rating of a comment is returned correctly or not.
     */
    @Test
    public void testGetRating(){
        SalesItem item1 = new SalesItem("Eternals", 13);
        item1.addComment("James", "This film is great", 4);
        Comment input1 = item1.getComment(0);
        assertEquals(4, input1.getRating());
    }
}
