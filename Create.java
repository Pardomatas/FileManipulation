import java.io.*;

public class Create{
    public static void main(String[] args) {
        try{
            ObjectOutputStream st = new ObjectOutputStream(new FileOutputStream("binary.dat"));
            st.writeUTF("This is the first line.");
            st.writeUTF("This is the second line.");
            st.close();
        }catch(IOException e){ 
            System.out.println(
             "Error: Cannot create the file.");
            System.exit(0);
        }
    }
}
