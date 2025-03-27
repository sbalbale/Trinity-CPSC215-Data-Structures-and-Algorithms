package edu.trincoll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class BSTJUnitTest {
    
    private BST<String, String> playlist;
    
    @BeforeEach
    public void setUp() {
        playlist = new BST<>();
    }
    
    @Test
    public void testInitialState() {
        assertThat(playlist.isEmpty()).isTrue();
        assertThat(playlist.size()).isEqualTo(0);
    }
    
    @Test
    public void testInsertAndSize() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        playlist.insert("Dancing Queen", "ABBA - Disco");
        
        assertThat(playlist.size()).isEqualTo(3);
        assertThat(playlist.isEmpty()).isFalse();
    }
    
    @Test
    public void testFind() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        
        assertThat(playlist.find("Africa")).isEqualTo("Toto - Rock");
        assertThat(playlist.find("Nonexistent")).isNull();
    }
    
    @Test
    public void testMinAndMax() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        playlist.insert("Dancing Queen", "ABBA - Disco");
        
        assertThat(playlist.getMin()).isEqualTo("Africa");
        assertThat(playlist.getMax()).isEqualTo("Imagine");
    }
    
    @Test
    public void testContainsValue() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        
        assertThat(playlist.containsValue("Toto - Rock")).isTrue();
        assertThat(playlist.containsValue("Michael Jackson - Pop")).isFalse();
    }
    
    @Test
    public void testSuccessorAndPredecessor() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        playlist.insert("Dancing Queen", "ABBA - Disco");
        playlist.insert("Bohemian Rhapsody", "Queen - Rock");
        playlist.insert("Hotel California", "Eagles - Rock");
        
        assertThat(playlist.successor("Bohemian Rhapsody")).isEqualTo("Dancing Queen");
        assertThat(playlist.predecessor("Hotel California")).isEqualTo("Dancing Queen");
        assertThat(playlist.successor("Imagine")).isNull();
        assertThat(playlist.predecessor("Africa")).isNull();
    }
    
    @Test
    public void testRemove() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        playlist.insert("Dancing Queen", "ABBA - Disco");
        playlist.insert("Bohemian Rhapsody", "Queen - Rock");
        playlist.insert("Hotel California", "Eagles - Rock");
        
        // Remove existing song
        assertThat(playlist.remove("Dancing Queen")).isEqualTo("ABBA - Disco");
        assertThat(playlist.size()).isEqualTo(4);
        
        // Remove non-existent song
        assertThat(playlist.remove("Thriller")).isNull();
        assertThat(playlist.size()).isEqualTo(4);
    }
    
    @Test
    public void testRemoveAny() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        
        String removed = playlist.removeAny();
        assertThat(removed).isNotNull();
        assertThat(playlist.size()).isEqualTo(1);
    }
    
    @Test
    public void testClear() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.insert("Africa", "Toto - Rock");
        
        playlist.clear();
        assertThat(playlist.isEmpty()).isTrue();
        assertThat(playlist.size()).isEqualTo(0);
    }
    
    @Test
    public void testOperationsAfterClear() {
        playlist.insert("Imagine", "John Lennon - Folk");
        playlist.clear();
        
        playlist.insert("Stairway to Heaven", "Led Zeppelin - Rock");
        playlist.insert("Smells Like Teen Spirit", "Nirvana - Grunge");
        
        assertThat(playlist.size()).isEqualTo(2);
        assertThat(playlist.getMin()).isEqualTo("Smells Like Teen Spirit");
        assertThat(playlist.getMax()).isEqualTo("Stairway to Heaven");
    }
    
    @Test
    public void testHeight() {
        assertThat(playlist.height()).isEqualTo(-1); // Empty tree
        
        playlist.insert("Imagine", "John Lennon - Folk");
        assertThat(playlist.height()).isEqualTo(0); // Single node
        
        playlist.insert("Africa", "Toto - Rock");
        playlist.insert("Dancing Queen", "ABBA - Disco");
        assertThat(playlist.height()).isGreaterThan(0); // Multiple nodes
    }
}