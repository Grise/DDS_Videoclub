package logica;

class test {

    public static test testcreator(final int prueba, final int prueba2) {
        return new test(prueba, prueba2);
    }

    private int prueba;
    private int prueba2;

    private test(final int prueba, final int prueba2) {
        this.prueba = prueba;
        this.prueba2 = prueba2;
    }
}