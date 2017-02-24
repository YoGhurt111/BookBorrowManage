package com.shu.entity;

import java.io.Serializable;

/**
 * Created by Dell on 2017/2/23.
 */
public class BorrowbookPK implements Serializable {
    private String readerid;
    private String isbn;

    public String getReaderid() {
        return readerid;
    }

    public void setReaderid(String readerid) {
        this.readerid = readerid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BorrowbookPK that = (BorrowbookPK) o;

        if (readerid != null ? !readerid.equals(that.readerid) : that.readerid != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = readerid != null ? readerid.hashCode() : 0;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }
}
