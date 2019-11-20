package org.folio.processing.mapping.model.context;

public class Rule {
    private String fieldName;
    private String fieldCode;
    private String ruleExpression;

    public Rule(String fieldName, String fieldCode, String ruleExpression) {
        this.fieldName = fieldName;
        this.fieldCode = fieldCode;
        this.ruleExpression = ruleExpression;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getRuleExpression() {
        return ruleExpression;
    }

    public void setRuleExpression(String ruleExpression) {
        this.ruleExpression = ruleExpression;
    }
}
