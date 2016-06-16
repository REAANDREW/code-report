import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by vagrant on 6/15/16.
 */

public class TestSomething {

    @Test
    public void doesSomething() throws IOException, ParseException {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        System.out.println(currentDirectory.getCanonicalPath());
        System.out.println(currentDirectory.getAbsolutePath());


        String file = new File("./src/test/java/examples/Something.java").getCanonicalPath();

        FileInputStream in = new FileInputStream(file);

        CompilationUnit cu;
        try {
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }
        
        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
    }


}
