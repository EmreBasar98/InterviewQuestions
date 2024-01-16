
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    static class LinkedList {
        int key;
        int value;
        LinkedList next = null;

        LinkedList prev = null;

        public LinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList cacheHead;

    LinkedList cacheTail;

    private final Map<Integer, LinkedList> cache = new HashMap<>();

    private final int capacity;

    private int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkedList elem = cache.get(key);
            if (elem != cacheTail) {
                removeNode(elem);
                makeMRU(elem);
            }
            return elem.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LinkedList elem = cache.get(key);
            elem.value = value;
            if (elem != cacheTail) {
                removeNode(elem);
                makeMRU(elem);
            }
        } else {
            size++;
            if (size > capacity){
                removeLRU();
                size--;
            }
            if (cacheHead == null) {
                cacheHead = new LinkedList(key, value);
                cache.put(key, cacheHead);
                cacheTail = cacheHead;
            } else {
                cacheTail.next = new LinkedList(key, value);
                cache.put(key, cacheTail.next);
                cacheTail.next.prev = cacheTail;
                cacheTail = cacheTail.next;
            }
        }

    }

    public void makeMRU(LinkedList node) {
        node.next = null;
        cacheTail.next = node;
        cache.put(node.key, cacheTail.next);
        cacheTail.next.prev = cacheTail;
        cacheTail = cacheTail.next;
    }

    public LinkedList removeLRU() {
        LinkedList lru = cache.remove(cacheHead.key);
        cacheHead = cacheHead.next;
        if (cacheHead != null) cacheHead.prev = null;
        return lru;
    }

    public void removeNode(LinkedList node) {
        if (node == cacheHead) removeLRU();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

//////////////////////////////////////
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 1);
        lRUCache.put(2, 2);

        lRUCache.get(2);


        printCache(lRUCache.cacheHead);

        lRUCache.put(4, 1);


        lRUCache.get(2);

    }


    public static void printCache(LinkedList cacheHead) {
        LinkedList temp = cacheHead;
        while (temp != null) {
            System.out.print(temp.key + " : " + temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void printCacheBackwards(LinkedList cacheTail) {
        LinkedList temp = cacheTail;
        while (temp != null) {
            System.out.print(temp.key + " : " + temp.value + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

}
