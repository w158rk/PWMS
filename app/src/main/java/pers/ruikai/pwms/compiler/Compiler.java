package pers.ruikai.pwms.compiler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pers.ruikai.pwms.warehouse.Warehouse;

/**
 * not important in current version
 *
 *
 */
public class Compiler {

    private InputStream origin = null;
    private InputStream processed = null;
    private String rootDir = null;

    public Compiler() {

    }

    public Compiler(String path) {
        String [] elems = path.split("/");
        String ret = "";
        for(int i=0; i<elems.length-1; i++) {
            ret += (elems[i] + "/");
        }
        rootDir = ret;
    }

    private String readFile(String filename) throws IOException{
        InputStream is = null;
        File file = null;
        if(rootDir!=null) {
            file = new File(rootDir + filename);
        }
        if(file==null || !file.exists()) {
            file = new File(filename);
        }
        if(file==null || !file.exists()) {
            file = new File(getClass().getClassLoader().getResource(filename).getPath());
        }
        if(file==null || !file.exists()) {
            throw new FileNotFoundException();
        }

        is = new FileInputStream(file);
        byte [] bytes = is.readAllBytes();
        is.close();
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private void preCompile() throws IOException {
        Reader reader = new InputStreamReader(origin);
        BufferedReader breader = new BufferedReader(reader);
        Writer writer = null;
        Pattern pattern = Pattern.compile("include\\s+\"(.*)\"");
        String line = null;
        boolean changed = true;

        // iterate until there is no include statement
        while(changed) {
            changed = false;
            writer = new StringWriter();
            while((line = breader.readLine())!=null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()) {
                    String filename = matcher.group(1);
                    System.out.println(filename);
                    String content = readFile(filename);
                    writer.write(content);
                    changed = true;
                }
                else {
                    writer.write(line);
                    writer.write("\n");
                }
            }
            writer.flush();
            writer.close();
            breader.close();
            breader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8))));
        }

        processed = new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8));
        reader.close();
        origin.close();
    }

    public Warehouse compile(String path) throws IOException {
        return new Builder().build(path);
    }

    public Warehouse compile(InputStream is) throws IOException {
        origin = is;
        preCompile();
        return new Builder().build(processed);
    }

}
