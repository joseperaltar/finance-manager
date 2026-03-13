package enums;

public enum MenuType {
    MAIN("0. Salir\n1. Insertar registro.\n2. Ver registros.\n3. Eliminar registro\n4. Buscar por monto", 0, 4),
    ENTRY_TYPE("1. Ingreso\n2. Egreso", 1, 2),
    SEARCH_TYPE("1. Mayor que el monto referencial\n2. Menor que el monto referencial", 1, 2);

    private final String options;
    private final int min;
    private final int max;

    MenuType(String options, int min, int max) {
        this.options = options;
        this.min = min;
        this.max = max;
    }

    public boolean isValid(int choice) {
        return choice >= min && choice <= max;
    }

    public String getOptions() {
        return options;
    }
}
