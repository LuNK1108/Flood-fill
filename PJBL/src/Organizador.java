public class Organizador<T> {

    T valor;
    Organizador<T> proximo;
    Organizador<T> anterior;

    public Organizador(T valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}