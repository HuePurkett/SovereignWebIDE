/**
 * Created by Hue on 4/24/2016.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Authentication {
    static String fileName="users.txt";
    public static boolean chop(String info, int type){
        if(info.startsWith("{\"email\":\"\",\"userName\":\"\",\"password\":\"\"}")){
            System.out.println("empty\n");
            return false;
        }else{
            int i=info.indexOf(":")+2;
            int j=info.indexOf("\"", i);
            if(j==-1){System.out.println("bad string\n"); return false;}
            String s1=info.substring(i, j);
            i=info.indexOf(":", j)+2;
            j=info.indexOf("\"", i);
            String s2=info.substring(i, j);
            i=info.indexOf(":", j)+2;
            j=info.indexOf("\"", i);
            String s3=info.substring(i, j);
            switch(type) {
                case 1:
                    return Authentication.createUser(s2, s3, s1);
                case 2:
                    return Authentication.logIn(s3, s2);
                default:
                    System.out.println("incorrect call\n");
                    return false;
            }
        }
    }

    public static boolean createUser(String uName, String password, String email){
        try{
            if(Authentication.isUser(uName, password, false)){
                return false;
            }else {
                String temp=uName+"\n"+password+"\n"+email+"\n\n";
                Files.write(Paths.get(Authentication.fileName), temp.getBytes(), StandardOpenOption.APPEND);
                return true;
            }
        }catch(Exception e){
            System.out.println("exception-create");
            return false;
        }
    }

    public static boolean isUser(String uName, String password, Boolean checkPass){
        try{
            File f=new File(Authentication.fileName);
            if(f.createNewFile()){System.out.println("file created"); return false;}
            BufferedReader in=new BufferedReader(new FileReader(f));
            String line;
            while((line=in.readLine())!=null){
                if(line.startsWith(uName)){
                    if(checkPass){
                        return (in.readLine()).startsWith(password);
                    }else {
                        return true;
                    }
                }else{
                    in.readLine();
                    in.readLine();
                    in.readLine();
                }
            }
            return false;
        }catch(Exception e){
            System.out.println("exception-test");
            return false;
        }
    }

    public static boolean logIn(String uName, String password) {
        try {
            return Authentication.isUser(uName, password, true);
        } catch (Exception e) {
            return false;
        }
    }
}
