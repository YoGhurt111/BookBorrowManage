package com.shu.entity;

/**
 * Created by Dell on 2017/2/23.
 */
public class Booktype {
    private int id;
    private String typename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booktype booktype = (Booktype) o;

        if (id != booktype.id) return false;
        if (typename != null ? !typename.equals(booktype.typename) : booktype.typename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typename != null ? typename.hashCode() : 0);
        return result;
    }
}
