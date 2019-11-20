package org.folio.processing.mapping.model.context;

public class Rule {
    private String field;
    private String expression;

    public Rule(String field, String expression) {
        this.field = field;
        this.expression = expression;
    }

    public String getField() {
        return field;
    }

    public String getExpression() {
        return expression;
    }
}
