package io.github.supercube.domain;

public enum AuthorityType {

    /**
     * 读
     * */
    READ("R"),
    /**
     * 写
     * */
    WRITE("W");

    private String read = "";
    private String write = "";

    AuthorityType(String type) {
        if (type.equals("W")) {
            this.write = "W";
        }
        if (type.equals("R")) {
            this.read = "R";
        }
    }

    @Override
    public String toString() {
        return this.read + this.write;
    }
}

