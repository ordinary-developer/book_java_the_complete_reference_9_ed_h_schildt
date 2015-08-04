class Gen<T extends Number> {
    T ob;

    T vals[];

    Gen(T o, T[] nums) {
        ob = o;
        //this stattemant is illegal
        // vals = new T[10];
        
        // this is OK
        vals = nums;
    }
}

class GenArrays {
    public static void main(String args[]) {
        Integer n[] = { 1, 2, 3, 4, 5 };
        Gen<Integer> iOb = new Gen<Integer>(50, n);

        // Wrong
        // Gen<Integer> gens[] = new Gen<Integer>[10];
        
        // this is OK
        Gen<?> gen[] = new Gen<?>[10];
    }
}
