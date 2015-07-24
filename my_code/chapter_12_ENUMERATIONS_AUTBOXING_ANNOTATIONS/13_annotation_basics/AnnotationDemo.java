import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

class AnnotationDemo {
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {
        System.out.println("myMeth() calling");
    }

    public static void main(String args[]) {
        AnnotationDemo.myMeth();
    }
}
