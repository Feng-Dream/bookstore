package com.zking.bookstore.model;

public class Dict {
    private Long dictId;

    private String dictName;

    private String text;

    private Long value;

    private Long position;

    private String remark;

    public Dict(Long dictId, String dictName, String text, Long value, Long position, String remark) {
        this.dictId = dictId;
        this.dictName = dictName;
        this.text = text;
        this.value = value;
        this.position = position;
        this.remark = remark;
    }

    public Dict() {
        super();
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}