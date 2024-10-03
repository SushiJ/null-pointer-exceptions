package com.sushi.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GenerateAst {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.err.println("Usage: generate_ast <output dir>");
            System.exit(64);
        }
        String outoutDir = args[0];
        defineAst(outoutDir, "Expr", Arrays.asList(
                "Binary   : Expr left, Token operator, Expr right",
                "Grouping : Expr expression",
                "Literal  : Object value",
                "Unary    : Token operator, Expr right"
        ));
    }
    private static void defineAst(String outputDir, String baseName, List<String> types) throws IOException {
        String path = outputDir + "/" + baseName + ".java";
        PrintWriter wr = new PrintWriter(path, StandardCharsets.UTF_8);

        wr.println("package com.sushi.lox;");
        wr.println();
        wr.println("import java.util.List;");
        wr.println();
        wr.println("abstract class " + baseName + " {");

        defineVisitor(wr, baseName, types);

        for (String type : types) {
            String className = type.split(":")[0].trim();
            String fields = type.split(":")[1].trim();
            defineType(wr, baseName, className, fields);
        }

        wr.println();
        wr.println("  abstract <R> R accept(Visitor<R> visitor);");

        wr.println("}");
        wr.close();
    }
    private static void defineType(PrintWriter w, String baseName, String className, String fieldList) {
        w.println(" static class " + className + " extends " + baseName + " {");
        w.println("    " + className + "(" + fieldList + ") {");
        String[] fields = fieldList.split(", ") ;
        for(String field : fields) {
            String name = field.split(" ")[1];
            w.println("    this." + name + " = " + name + ";");
        }
        w.println("    }");
        w.println();
        w.println("    @Override");
        w.println("    <R> R accept(Visitor<R> visitor) {");
        w.println("      return visitor.visit" + className + baseName + "(this);");
        w.println("    }");

        for (String field : fields) {
            w.println("    final " + field + ";");
        }
        w.println("  }");
    }
    private static void defineVisitor(PrintWriter w, String baseName, List<String> types) {
       w.println("  interface Visitor<R> {");

       for (String type: types) {
          String typeName = type.split(":")[0].trim();
          w.println("    R visit" + typeName + baseName + "(" + typeName + " " + baseName.toLowerCase() + ");");
       }

       w.println("  }");
    }
}
