package special_types;
public enum Physical {
    HARDCOVER("hardcover"),
    PAPERBACK("paperback");

    final String type;
    Physical(String type){
        this.type = type;
    };
    
    public String getType() {
        return type;
    }
}
