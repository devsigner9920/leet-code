

import static java.lang.Math.random;

class RandomizedSet {
    private Map<Integer, Object> set;
    Random ran = new Random();
    public RandomizedSet() {
        this.set = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (set.containsKey(val)) return false;

        set.put(val, new Object());
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.containsKey(val)) return false;

        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int size = set.size();
        List<Integer> list = new ArrayList<>(set.keySet());
        return list.get(ran.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */