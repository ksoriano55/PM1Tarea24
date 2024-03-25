package Configurations;

public class Transaccion {
    public static final String DBName = "PM1T24KS";
    public static final String TableFirmas = "signatures";
    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String firmadigital = "firmadigital";
    public static final String CreateTableFirma = "Create table "+ TableFirmas +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion TEXT, firmadigital BLOB )";

    public static final String DropTableFirma = "DROP TABLE IF EXISTS "+ TableFirmas;
    public static final String SelectAllFirma = "SELECT * FROM " + TableFirmas;
}
