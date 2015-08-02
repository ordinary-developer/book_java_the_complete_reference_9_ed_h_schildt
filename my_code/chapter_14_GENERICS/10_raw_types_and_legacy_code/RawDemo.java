class Gen<T> {
    T ob;
    Gen(T o) {
        ob = o;
    }
    T getob() {
        return ob;
    }
}

class RawDemo {
    public static void main(String args[]) {
        Gen<Integer> iOb = new Gen<Integer>(88);
        Gen<String> strOb = new Gen<String>("Generics Test");

        Gen raw = new Gen(new Double(98.6));
        double d = (Double)raw.getob();
        System.out.println("value: " + d);

        // The following cast causes a run-time error!
        // int i = (Integer)raw.getob();
        
        // This assignment overrides type safety
        // strOb = raw;
        // run-time error
        // String str = strOb.getob();
        
        // raw = iOb;
        // run-time error
        // d = (Double)raw.getob();
    }
}
