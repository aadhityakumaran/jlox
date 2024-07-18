package com.craftinginterpreters.lox;

abstract class Stmt {
    interface Visitor<R> {
        R visit(Expression stmt);
        R visit(Print stmt);
    }

    static class Expression extends Stmt {
        final Expr expression;

        Expression(Expr expression) {
            this.expression = expression;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visit(this);
        }
    }

    static class Print extends Stmt {
        final Expr expression;

        Print(Expr expression) {
            this.expression = expression;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visit(this);
        }
    }

    abstract <R> R accept(Visitor<R> visitor);
}

