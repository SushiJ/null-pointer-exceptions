package com.sushi.lox;

import java.util.ArrayList;
import static com.sushi.lox.TokenType.*;

class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    Scanner(String source) {
        this.source = source;
    }
}
