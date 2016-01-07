import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/*
<applet code="TextAreaDemo" width=300 height=250>
</applet>
*/ 


public class TextAreaDemo extends Applet {
    public void init() {
        String val = 
            "as;dlfkjasdlfkjaslkfjlk a;skjdf alskaskdjfa\n" +
            "a;sldasldkfjlkfjalskjflkasjlfj\n" +
            "asdflkasdflkasjdfksdjflkasjdlkkja\n" +
            "asdfa;skdf;aslkdfjsaldkfjaslkdfj\n" +
            "zxcvzxcbcbn,nweriwuoqwiueroqwueroqwuxv";

        TextArea text = new TextArea(val, 10, 30);
        add(text);
    }
}
