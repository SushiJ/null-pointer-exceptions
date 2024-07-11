package LRUcache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LRUTest {
    LRU<String, Integer> lru = new LRU<>(3);
    @Test
    void should_be_null_when_first_instantiated() {
        assertNull(lru.get("foo"));
    }
    @Test
    void foo() {
        lru.update("foo", 69);
        assertEquals(lru.get("foo"), 69);
    }

    @Test
    void bar() {
        lru.update("bar", 420);
        assertEquals(lru.get("bar"), 420);
    }

    @Test
    void baz() {
        lru.update("baz", 1337);
        assertEquals(lru.get("baz"), 1337);
    }

    @Test
    void ball() {
        lru.update("ball", 69420);
        assertEquals(lru.get("ball"), 69420);
    }

    @Test
    void get_foo_should_be_null() {
        assertNull(lru.get("foo"));
    }

    @Test
    void update_foo() {
        lru.update("foo", 69);
        assertEquals(lru.get("foo"), 69);
    }

    @Test
    void update_bar() {
        lru.update("bar", 420);
        assertEquals(lru.get("bar"), 420);
    }

    @Test
    void baz_to_be_null() {
        assertNull(lru.get("baz"));
    }
}